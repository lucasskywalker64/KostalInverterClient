package de.spyderscript.inverter.client;

import de.spyderscript.inverter.code.PayloadDecoder;
import de.spyderscript.inverter.register.InverterAddress;
import de.spyderscript.inverter.register.InverterAddressResponse;
import de.spyderscript.modbus.tcp.ModbusClient;
import de.spyderscript.modbus.tcp.ModbusException;

import java.io.IOException;
import java.net.InetSocketAddress;

public class InverterClient {
    private final ModbusClient modbusClient;

    public InverterClient(ModbusClient modbusClient) {
        this.modbusClient = modbusClient;
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InverterClient(InetSocketAddress inetSocketAddress, byte unitID) {
        this.modbusClient = new ModbusClient(inetSocketAddress, unitID);
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        modbusClient.connect();
    }

    public InverterAddressResponse get(InverterAddress address) throws IOException, ModbusException {
        Object data = PayloadDecoder.fromRegisters(modbusClient.readHoldingRegisters(address.getAddress(), address.getQuantity())).decode(address.getFormat());
        return new InverterAddressResponse(address, data);
    }
}
