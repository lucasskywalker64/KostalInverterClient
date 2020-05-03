package de.spyderscript.inverter.register;

import de.spyderscript.inverter.misc.Format;
import de.spyderscript.inverter.misc.Unit;

public enum InverterAddress {

    MODBUS_ENABLE(0x02, "MODBUS Enable", Unit.NONE, Format.BOOLEAN, 1),
    MODBUS_UNIT_ID(0x04, "MODBUS unit-ID", Unit.NONE, Format.U16, 1),
    INVERTER_ARTICLE_NUMBER(0x06, "Inverter article number", Unit.NONE, Format.STRING, 8),
    INVERTER_SERIAL_NUMBER(0x0E, "Inverter serial number", Unit.NONE, Format.STRING, 8),
    NUMBER_OF_BIDIRECTIONAL_CONVERTER(0x1E, "Number of bidirectional converter", Unit.NONE, Format.U16, 1),
    NUMBER_OF_AC_PHASES(0x20, "Number of AC phases", Unit.NONE, Format.U16, 1),
    NUMBER_OF_PV_STRINGS(0x22, "Number of PV strings", Unit.NONE, Format.U16, 1),
    HARDWARE_VERSION(0x24, "Hardware-Version", Unit.NONE, Format.U16, 2),
    SOFTWARE_VERSION_MAINCONTROLLER(0x26, "Software-Version Maincontroller (MC)", Unit.NONE, Format.STRING, 8),
    SOFTWARE_VERSION_IO_CONTROLLER_(0x2E, "Software-Version IO-Controller (IOC)", Unit.NONE, Format.STRING, 8),
    POWER_ID(0x36, "Power-ID", Unit.NONE, Format.U16, 2),
    INVERTER_STATE(0x38, "Inverter state", Unit.NONE, Format.U16, 2),
    TOTAL_DC_POWER(0x64, "Total DC power", Unit.WATT, Format.FLOAT, 2),
    STATE_OF_ENERGY_MANAGER(0x68, "State of energy manager", Unit.NONE, Format.U32, 2),
    HOME_OWN_CONSUMPTION_FROM_BATTERY(0x6A, "Home own consumption from battery", Unit.WATT, Format.FLOAT, 2),
    HOME_OWN_CONSUMPTION_FROM_GRID(0x6C, "Home own consumption from grid", Unit.WATT, Format.FLOAT, 2),
    TOTAL_HOME_CONSUMPTION_BATTERY(0x6E, "Total home consumption Battery", Unit.WATT_HOURS, Format.FLOAT, 2),
    TOTAL_HOME_CONSUMPTION_GRID(0x70, "Total home consumption Grid", Unit.WATT_HOURS, Format.FLOAT, 2),
    TOTAL_HOME_CONSUMPTION_PV(0x72, "Total home consumption PV", Unit.WATT_HOURS, Format.FLOAT, 2),
    HOME_OWN_CONSUMPTION_FROM_PV(0x74, "Home own consumption from PV", Unit.WATT, Format.FLOAT, 2),
    TOTAL_HOME_CONSUMPTION(0x76, "Total home consumption", Unit.WATT_HOURS, Format.FLOAT, 2),
    ISOLATION_RESISTANCE(0x78, "Isolation resistance", Unit.Ohm, Format.FLOAT, 2),
    POWER_LIMIT_FROM_EVU(0x7A, "Power limit from EVU", Unit.PERCENT, Format.FLOAT, 2),
    TOTAL_HOME_CONSUMPTION_RATE(0x7C, "Total home consumption rate", Unit.PERCENT, Format.FLOAT, 2),
    WORKTIME(0x90, "Worktime", Unit.SECONDS, Format.FLOAT, 2),
    ACTUAL_COS_PHI(0x96, "Actual cos φ", Unit.NONE, Format.FLOAT, 2),
    GRID_FREQUENCY(0x98, "Grid frequency", Unit.HERTZ, Format.FLOAT, 2),
    CURRENT_PHASE_1(0x9A, "Current Phase 1", Unit.AMPERE, Format.FLOAT, 2),
    ACTIVE_POWER_PHASE_1(0x9C, "Active power Phase 1", Unit.WATT, Format.FLOAT, 2),
    VOLTAGE_PHASE_1(0x9E, "Voltage Phase 1", Unit.VOLT, Format.FLOAT, 2),
    CURRENT_PHASE_2(0xA0, "Current Phase 2", Unit.AMPERE, Format.FLOAT, 2),
    ACTIVE_POWER_PHASE_2(0xA2, "Active power Phase 2", Unit.WATT, Format.FLOAT, 2),
    VOLTAGE_PHASE_2(0xA4, "Voltage Phase 2", Unit.VOLT, Format.FLOAT, 2),
    CURRENT_PHASE_3(0xA6, "Current Phase 3", Unit.AMPERE, Format.FLOAT, 2),
    ACTIVE_POWER_PHASE_3(0xA8, "Active power Phase 3", Unit.WATT, Format.FLOAT, 2),
    VOLTAGE_PHASE_3(0xAA, "Voltage Phase 3", Unit.VOLT, Format.FLOAT, 2),
    TOTAL_AC_ACTIVE_POWER(0xAC, "Total AC active power", Unit.WATT, Format.FLOAT, 2),
    TOTAL_AC_REACTIVE_POWER(0xAE, "Total AC reactive power", Unit.Var, Format.FLOAT, 2),
    TOTAL_AC_APPARENT_POWER(0xB2, "Total AC apparent power", Unit.VOLT_AMPERE, Format.FLOAT, 2),
    BATTERY_CHARGE_CURRENT(0xBE, "Battery charge current", Unit.AMPERE, Format.FLOAT, 2),
    NUMBER_OF_BATTERY_CYCLES(0xC2, "Number of battery cycles", Unit.NONE, Format.FLOAT, 2),
    ACTUAL_BATTERY_CHARGE_OR_DISCHARGE_CURRENT(0xC8, "Actual battery charge (-) / discharge (+) current", Unit.AMPERE, Format.FLOAT, 2),
    PSSB_FUSE_STATE5(0xCA, "PSSB fuse state5", Unit.NONE, Format.FLOAT, 2),
    BATTERY_READY_FLAG(0xD0, "Battery ready flag", Unit.NONE, Format.FLOAT, 2),
    ACTUAL_STATE_OF_CHARGE(0xD2, "Act. state of charge", Unit.PERCENT, Format.FLOAT, 2),
    BATTERY_TEMPERATURE(0xD6, "Battery temperature", Unit.CENTIGRADE, Format.FLOAT, 2),
    BATTERY_VOLTAGE(0xD8, "Battery voltage", Unit.VOLT, Format.FLOAT, 2),
    COS_PHI_POWERMETER(0xDA, "Cos φ (powermeter)", Unit.NONE, Format.FLOAT, 2),
    FREQUENCY_POWERMETER(0xDC, "Frequency  (powermeter)", Unit.HERTZ, Format.FLOAT, 2),
    CURRENT_PHASE_1_POWERMETER(0xDE, "Current phase 1 (powermeter)", Unit.AMPERE, Format.FLOAT, 2),
    ACTIVE_POWER_PHASE_1_POWERMETER(0xE0, "Active power phase 1 (powermeter)", Unit.WATT, Format.FLOAT, 2),
    REACTIVE_POWER_PHASE_1_POWERMETER(0xE2, "Reactive power phase 1 (powermeter)", Unit.Var, Format.FLOAT, 2),
    APPARENT_POWER_PHASE_1_POWERMETER(0xE4, "Apparent power phase 1 (powermeter)", Unit.VOLT_AMPERE, Format.FLOAT, 2),
    VOLTAGE_PHASE_1_POWERMETER(0xE6, "Voltage phase 1 (powermeter)", Unit.VOLT, Format.FLOAT, 2),
    CURRENT_PHASE_2_POWERMETER(0xE8, "Current phase 2 (powermeter)", Unit.AMPERE, Format.FLOAT, 2),
    ACTIVE_POWER_PHASE_2_POWERMETER(0xEA, "Active power phase 2 (powermeter)", Unit.WATT, Format.FLOAT, 2),
    REACTIVE_POWER_PHASE_2_POWERMETER(0xEC, "Reactive power phase 2 (powermeter)", Unit.Var, Format.FLOAT, 2),
    APPARENT_POWER_PHASE_2_POWERMETER(0xEE, "Apparent power phase 2 (powermeter)", Unit.VOLT_AMPERE, Format.FLOAT, 2),
    VOLTAGE_PHASE_2_POWERMETER(0xF0, "Voltage phase 2 (powermeter)", Unit.VOLT, Format.FLOAT, 2),
    CURRENT_PHASE_3_POWERMETER(0xF2, "Current phase 3 (powermeter)", Unit.AMPERE, Format.FLOAT, 2),
    ACTIVE_POWER_PHASE_3_POWERMETER(0xF4, "Active power phase 3 (powermeter)", Unit.WATT, Format.FLOAT, 2),
    REACTIVE_POWER_PHASE_3_POWERMETER(0xF6, "Reactive power phase 3 (powermeter)", Unit.Var, Format.FLOAT, 2),
    APPARENT_POWER_PHASE_3_POWERMETER(0xF8, "Apparent power phase 3 (powermeter)", Unit.VOLT_AMPERE, Format.FLOAT, 2),
    VOLTAGE_PHASE_3_POWERMETER(0xFA, "Voltage phase 3 (powermeter)", Unit.VOLT, Format.FLOAT, 2),
    TOTAL_ACTIVE_POWER_POWERMETER(0xFC, "Total active power (powermeter)", Unit.WATT, Format.FLOAT, 2),
    TOTAL_REACTIVE_POWER_POWERMETER(0xFE, "Total reactive power (powermeter)", Unit.Var, Format.FLOAT, 2),
    TOTAL_APPARENT_POWER_POWERMETER(0x100, "Total apparent power (powermeter)", Unit.VOLT_AMPERE, Format.FLOAT, 2),
    CURRENT_DC1(0x102, "Current DC1", Unit.AMPERE, Format.FLOAT, 2),
    POWER_DC1(0x104, "Power DC1", Unit.WATT, Format.FLOAT, 2),
    VOLTAGE_DC1(0x10A, "Voltage DC1", Unit.VOLT, Format.FLOAT, 2),
    CURRENT_DC2(0x10C, "Current DC2", Unit.AMPERE, Format.FLOAT, 2),
    POWER_DC2(0x10E, "Power DC2", Unit.WATT, Format.FLOAT, 2),
    VOLTAGE_DC2(0x114, "Voltage DC2", Unit.VOLT, Format.FLOAT, 2),
    CURRENT_DC3(0x116, "Current DC3", Unit.AMPERE, Format.FLOAT, 2),
    POWER_DC3(0x118, "Power DC3", Unit.WATT, Format.FLOAT, 2),
    VOLTAGE_DC3(0x11E, "Voltage DC3", Unit.VOLT, Format.FLOAT, 2),
    TOTAL_YIELD(0x140, "Total yield", Unit.WATT_HOURS, Format.FLOAT, 2),
    DAILY_YIELD(0x142, "Daily yield", Unit.WATT_HOURS, Format.FLOAT, 2),
    YEARLY_YIELD(0x144, "Yearly yield", Unit.WATT_HOURS, Format.FLOAT, 2),
    MONTHLY_YIELD(0x146, "Monthly yield", Unit.WATT_HOURS, Format.FLOAT, 2),
    INVERTER_NETWORK_NAME(0x180, "Inverter network name", Unit.NONE, Format.STRING, 32),
    IP_ENABLE(0x1A0, "IP enable", Unit.NONE, Format.U16, 1),
    MANUAL_IP_OR_AUTO_IP(0x1A2, "Manual IP / Auto-IP", Unit.NONE, Format.U16, 1),
    IP_ADDRESS(0x1A4, "IP-address", Unit.NONE, Format.STRING, 8),
    IP_SUBNETMASK(0x1AC, "IP-subnetmask", Unit.NONE, Format.STRING, 8),
    IP_GATEWAY(0x1B4, "IP-gateway", Unit.NONE, Format.STRING, 8),
    IP_AUTO_DNS(0x1BC, "IP-auto-DNS", Unit.NONE, Format.U16, 1),
    IP_DNS1(0x1BE, "IP-DNS1", Unit.NONE, Format.STRING, 8),
    IP_DNS2(0x1C6, "IP-DNS2", Unit.NONE, Format.STRING, 8),
    BATTERY_GROSS_CAPACITY(0x200, "Battery gross capacity", Unit.AMPERE_HOURS, Format.U32, 2),
    BATTERY_ACTUAL_SOC(0x202, "Battery actual SOC", Unit.PERCENT, Format.U16, 1),
    FIRMWARE_MAINCONTROLLER(0x203, "Firmware Maincontroller (MC)", Unit.NONE, Format.U32, 2),
    BATTERY_MANUFACTURER(0x205, "Battery Manufacturer", Unit.NONE, Format.STRING, 8),
    BATTERY_MODEL_ID(0x20D, "Battery Model ID", Unit.NONE, Format.U32, 2),
    BATTERY_SERIAL_NUMBER(0x20F, "Battery Serial Number", Unit.NONE, Format.U32, 2),
    WORK_CAPACITY(0x211, "Work Capacity", Unit.WATT_HOURS, Format.U32, 2),
    INVERTER_MAX_POWER(0x213, "Inverter Max Power", Unit.WATT, Format.U16, 1),
    INVERTER_PEAK_GENERATION_POWER_SCALE_FACTOR(0x214, "Inverter Peak Generation Power Scale Factor", Unit.NONE, Format.S16, 1), //TODO: CHECK FORMAT
    INVERTER_MANUFACTURER(0x217, "Inverter Manufacturer", Unit.NONE, Format.STRING, 16),
    INVERTER_MODEL_ID(0x227, "Inverter Model ID", Unit.NONE, Format.STRING, 8),
    INVERTER_SERIAL_NUMBER_2(0x22F, "Inverter Serial Number", Unit.NONE, Format.STRING, 16),
    ACTUAL_INVERTER_GENERATION_POWER(0x23F, "Inverter Generation Power (actual)", Unit.WATT, Format.S16, 1),
    POWER_SCALE_FACTOR(0x240, "Power Scale Factor", Unit.NONE, Format.S16, 1), //TODO: CHECK FORMAT
    GENERATION_ENERGY(0x241, "Generation Energy", Unit.WATT_HOURS, Format.U32, 2),
    ENERGY_SCALE_FACTOR(0x243, "Energy Scale Factor", Unit.NONE, Format.S16, 1), //TODO: CHECK FORMAT
    ACTUAL_BATTERY_CHARGE_OR_DISCHARGE_POWER(0x246, "Actual battery charge/discharge power", Unit.WATT, Format.S16, 1),
    BATTERY_FIRMWARE(0x24A, "Battery Firmware", Unit.NONE, Format.U32, 1),
    BATTERY_TYPE(0x24C, "Battery Type", Unit.NONE, Format.U16, 1),
    PRODUCTNAME(0x300, "Productname", Unit.NONE, Format.STRING, 32),
    POWER_CLASS(0x320, "Power class", Unit.NONE, Format.STRING, 32);

    private final int address;
    private final String description;
    private final Unit unit;
    private final Format format;
    private final int quantity;

    InverterAddress(int address, String description, Unit unit, Format format, int quantity) {
        this.address = address;
        this.description = description;
        this.unit = unit;
        this.format = format;
        this.quantity = quantity;
    }

    public int getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public Unit getUnit() {
        return unit;
    }

    public Format getFormat() {
        return format;
    }

    public int getQuantity() {
        return quantity;
    }
}
