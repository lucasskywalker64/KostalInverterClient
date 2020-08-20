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
    }

    public InverterClient(InetSocketAddress inetSocketAddress, byte unitID) {
        this.modbusClient = new ModbusClient(inetSocketAddress, unitID);
    }

    public boolean isConnected() {
        return modbusClient.isConnected();
    }

    public void connect() throws IOException {
        modbusClient.connect();
    }

    public void disconnect() throws IOException {
        modbusClient.disconnect();
    }

    public void close() throws IOException {
        this.disconnect();
    }

    public InverterAddressResponse read(InverterAddress address) throws IOException, ModbusException {
        if(!modbusClient.isConnected()) throw new IllegalStateException("Modbus client is not connected.");
        Object data = PayloadDecoder.fromRegisters(modbusClient.readHoldingRegisters(address.getAddress(), address.getQuantity())).decode(address.getFormat());
        return new InverterAddressResponse(address, data);
    }
}
