package de.spyderscript.inverter.misc;

public enum Unit {
    WATT("W"),
    WATT_HOURS("Wh"),
    Ohm("Ohm"),
    PERCENT("%"),
    SECONDS("s"),
    HERTZ("Hz"),
    AMPERE("A"),
    VOLT("V"),
    Var("Var"),
    VOLT_AMPERE("VA"),
    CENTIGRADE("°C"),
    AMPERE_HOURS("Ah"),
    NONE("-");

    private final String identifier;

    private Unit(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
