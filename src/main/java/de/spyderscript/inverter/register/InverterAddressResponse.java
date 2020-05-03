package de.spyderscript.inverter.register;

public class InverterAddressResponse {
    private final InverterAddress address;
    private final Object data;

    public InverterAddressResponse(InverterAddress address, Object data) {
        this.address = address;
        this.data = data;
    }

    public InverterAddress getAddress() {
        return address;
    }

    public Object getData() {
        return data;
    }
}
