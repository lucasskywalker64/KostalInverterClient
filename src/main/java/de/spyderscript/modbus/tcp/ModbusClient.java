package de.spyderscript.modbus.tcp;

import de.spyderscript.util.ModbusUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class ModbusClient {
    private static final byte[] TRANSACTION_NUMBER = {1, 0};
    private static final byte[] PROTOCOL_INDICATOR = {0, 0};
    private static final byte[] length = {0, 6};
    private static final byte FUNCTION_CODE = 0x03;

    private Socket socket;
    private final InetSocketAddress inetSocketAddress;
    private final byte unitID;
    private int connectionTimeout = 10000;


    public ModbusClient(InetSocketAddress inetSocketAddress, byte unitID) {
        this.inetSocketAddress = inetSocketAddress;
        this.unitID = unitID;
    }

    public void connect() throws IOException {
        socket = new Socket(inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        socket.setSoTimeout(connectionTimeout);
    }

    public int[] readHoldingRegisters(int address, int quantity) throws ModbusException, IOException {
        checkSocket();
        if (address > 65535 || quantity > 125)
            throw new IllegalArgumentException("Invalid start address or length");

        byte[] sendData = createOutput(ModbusUtils.toBytes(address), ModbusUtils.toBytes(quantity));
        byte[] receiveData = sendAndReceive(sendData);
        if (receiveData[7] == (byte) 0x83) {
            handleExceptionResponse(receiveData[8]);
        }
        int[] response = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            byte[] bytes = new byte[2];
            bytes[0] = receiveData[9 + i * 2];
            bytes[1] = receiveData[9 + i * 2 + 1];
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

            response[i] = byteBuffer.getShort();
        }
        return (response);
    }

    public void disconnect() throws IOException {
        if (socket != null) {
            socket.getInputStream().close();
            socket.getOutputStream().close();

            socket.close();
        }
    }

    private byte[] sendAndReceive(byte[] sendData) throws IOException {
        socket.getOutputStream().write(sendData, 0, sendData.length);

        byte[] receiveData = new byte[128];
        socket.getInputStream().read(receiveData, 0, receiveData.length);
        return receiveData;
    }

    private void handleExceptionResponse(int exceptionCode) throws ModbusException {
        switch (exceptionCode) {
            case 1:
                throw new ModbusException("ILLEGAL FUNCTION");
            case 2:
                throw new ModbusException("ILLEGAL DATA ADDRESS");
            case 3:
                throw new ModbusException("ILLEGAL DATA VALUE");
            case 4:
                throw new ModbusException("SERVER DEVICE FAILURE");
            default:
                throw new ModbusException("Unknown server exception; code: " + exceptionCode);

        }
    }

    private byte[] createOutput(byte[] startAddress, byte[] quantity) {
        return new byte[]
                {
                        TRANSACTION_NUMBER[1],
                        TRANSACTION_NUMBER[0],
                        PROTOCOL_INDICATOR[1],
                        PROTOCOL_INDICATOR[0],
                        length[1],
                        length[0],
                        this.unitID,
                        ModbusClient.FUNCTION_CODE,
                        startAddress[1],
                        startAddress[0],
                        quantity[1],
                        quantity[0]
                };
    }

    public boolean isConnected() {
        return socket != null && socket.isConnected();
    }

    private void checkSocket() throws SocketException {
        if (!isConnected()) {
            throw new SocketException("Socket not initialized");
        }
    }

    public InetSocketAddress getInetSocketAddress() {
        return inetSocketAddress;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

}