package com.quantitymeasurement.enums;

public enum SubTypes {
    FEET(1 * 12.0, UnitType.LENGTH), INCH(1.0, UnitType.LENGTH),
    YARD(1 * 36.0, UnitType.LENGTH), CENTIMETER(0.4, UnitType.LENGTH),

    GALLON(1 * 3.785, UnitType.VOLUME), LITRE(1.0, UnitType.VOLUME),
    MILLILITRE(1.0 / 1000.0, UnitType.VOLUME),

    KILOGRAM(1.0, UnitType.WEIGHT), GRAM(1 / 1000.0, UnitType.WEIGHT),
    TONNE(1 * 1000.0, UnitType.WEIGHT),

    FAHRENHEIT((0.5555555555555556), UnitType.TEMPERATURE), CELSIUS((1.8), UnitType.TEMPERATURE);

    public UnitType unitType;
    public double conversionValue;

    SubTypes(double conversionValue, UnitType unitType) {
        this.conversionValue = conversionValue;
        this.unitType = unitType;
    }
}