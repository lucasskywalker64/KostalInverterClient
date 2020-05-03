package de.spyderscript.util;

public class ModbusUtils {
    public static byte[] toBytes(int value) {
        byte[] result = new byte[2];
        result[1] = (byte) (value >> 8);
        result[0] = (byte) (value);
        return result;
    }

    public static byte[] reverseBytes(byte[] bytes) {
        int n = bytes.length;
        for (int i = 0; i < n / 2; i++) {
            byte b = bytes[i];
            bytes[i] = bytes[n - i - 1];
            bytes[n - i - 1] = b;
        }
        return bytes;
    }
}
