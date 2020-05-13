package com.quantitymeasurement.dto;

import com.quantitymeasurement.enums.Unit;
import com.quantitymeasurement.enums.UnitType;

public class QuantityDTO {

    private Unit inputUnit;
    private Unit outputUnit;
    private double inputValue;
    private UnitType unitType;

    public QuantityDTO(Unit inputUnit, Unit outputUnit, double inputValue, UnitType unitType) {
        this.inputUnit = inputUnit;
        this.outputUnit = outputUnit;
        this.inputValue = inputValue;
        this.unitType = unitType;
    }

    public void setInputUnit(Unit inputUnit) {
        this.inputUnit = inputUnit;
    }

    public void setOutputUnit(Unit outputUnit) {
        this.outputUnit = outputUnit;
    }

    public void setInputValue(double inputValue) {
        this.inputValue = inputValue;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public Unit getInputUnit() {
        return inputUnit;
    }

    public Unit getOutputUnit() {
        return outputUnit;
    }

    public double getInputValue() {
        return inputValue;
    }

    public UnitType getUnitType() {
        return unitType;
    }
}