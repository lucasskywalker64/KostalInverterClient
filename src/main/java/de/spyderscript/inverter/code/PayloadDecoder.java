package de.spyderscript.inverter.code;

import de.spyderscript.inverter.misc.Format;
import de.spyderscript.util.ModbusUtils;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PayloadDecoder {
    private int[] registers;

    private PayloadDecoder(int[] registers) {
        this.registers = registers;
    }

    public static PayloadDecoder fromRegisters(int[] registers) {
        return new PayloadDecoder(registers);
    }

    public float decodeFloat() {
        if (registers.length != 2) {
            throw new IllegalArgumentException("Array length must be 2");
        }
        byte[] leadingBytes = ModbusUtils.toBytes(registers[1]);
        byte[] trailingBytes = ModbusUtils.toBytes(registers[0]);
        byte[] floatBytes = {
                leadingBytes[1],
                leadingBytes[0],
                trailingBytes[1],
                trailingBytes[0]
        };
        return ByteBuffer.wrap(floatBytes).getFloat();
    }

    public int decodeInt16() {
        if (registers.length != 1) {
            throw new IllegalArgumentException("Array length must be 1");
        }
        return registers[0];
    }

    public int decodeU16_2() {
        if (registers.length != 2) {
            throw new IllegalArgumentException("Array length must be 2");
        }

        if(registers[1] == 0) {
            return registers[0];
        } else {
            return Integer.parseInt("" + registers[0] + registers[1]);
        }
    }

    public String decodeString() {
        StringBuilder sb = new StringBuilder();
        for (int register : registers) {
            byte[] bytes = ModbusUtils.toBytes(register);
            sb.append(new String(ModbusUtils.reverseBytes(bytes), StandardCharsets.UTF_8));
        }
        return sb.toString();
    }

    public boolean decodeBoolean() {
        if (registers.length != 1) {
            throw new IllegalArgumentException("Array length must be 1");
        }
        return registers[0] == 1;
    }

    public int decodeU32() {
        if (registers.length != 2) {
            throw new IllegalArgumentException("Input Array length invalid");
        } else {
            int[] swappedRegisters = new int[]{registers[1], registers[0]};
            int highRegister = swappedRegisters[1];
            int lowRegister = swappedRegisters[0];
            byte[] highRegisterBytes = toByteArray(highRegister);
            byte[] lowRegisterBytes = toByteArray(lowRegister);
            byte[] doubleBytes = new byte[]{highRegisterBytes[1], highRegisterBytes[0], lowRegisterBytes[1], lowRegisterBytes[0]};
            return ByteBuffer.wrap(doubleBytes).getInt();
        }
    }

    public static byte[] toByteArray(int value) {
        byte[] result = new byte[]{(byte)value, (byte)(value >> 8)};
        return result;
    }

    public Object decode(Format format) {
        switch (format) {
            case U16:
                if(registers.length == 2) {
                    return this.decodeU16_2();
                }
                return this.decodeInt16();
            case S16:
                return this.decodeInt16();
            case STRING:
                return this.decodeString();
            case FLOAT:
                return this.decodeFloat();
            case BOOLEAN:
                return this.decodeBoolean();
            case U32:
                return this.decodeU32();
            default:
                throw new UnsupportedOperationException("The format \"" + format + "\" is currently not supported.");
        }
    }
}
