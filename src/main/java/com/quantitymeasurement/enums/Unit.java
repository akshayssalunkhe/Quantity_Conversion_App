package com.quantitymeasurement.enums;

public enum Unit {
    INCH(UnitType.LENGTH), FEET(UnitType.LENGTH), YARD(UnitType.LENGTH), CENTIMETER(UnitType.LENGTH),
    LITRE(UnitType.VOLUME), GALLON(UnitType.VOLUME), MILLILITRE(UnitType.VOLUME),
    KILOGRAMS(UnitType.WEIGHT), GRAMS(UnitType.WEIGHT), TONNE(UnitType.WEIGHT),
    FAHRENHEIT(UnitType.TEMPERATURE), CELSIUS(UnitType.TEMPERATURE);

    public UnitType unitType;

    Unit(UnitType unitType) {
        this.unitType = unitType;
    }
}
