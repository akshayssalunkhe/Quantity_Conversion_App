package com.quantitymeasurement.enums;

public enum UnitType {
    LENGTH(Unit.INCH), VOLUME(Unit.LITRE), WEIGHT(Unit.KILOGRAMS), TEMPERATURE(Unit.CELSIUS);
    public Unit baseUnit;

    UnitType(Unit baseUnit) {
        this.baseUnit = baseUnit;
    }
}
