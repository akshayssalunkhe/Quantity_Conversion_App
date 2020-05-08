package com.quantitymeasurement.dto;

import com.quantitymeasurement.enums.SubTypes;
import com.quantitymeasurement.enums.Unit;
import com.quantitymeasurement.enums.UnitType;

public class QuantityDTO {
    SubTypes initialUnit;

    public SubTypes getOutputUnitG() {
        return outputUnitG;
    }

    public void setOutputUnitG(SubTypes outputUnitG) {
        this.outputUnitG = outputUnitG;
    }

    SubTypes outputUnitG;
    Unit inputUnit;
    Unit outputUnit;
    double inputValue;
    double outputValue;
    UnitType unitType;

    public SubTypes getInitialUnit() {
        return initialUnit;
    }

    public void setInitialValue(SubTypes initialUnit) {
        this.initialUnit = initialUnit;
    }

    SubTypes initialValue;

    public Unit getInputUnit() {
        return inputUnit;
    }

    public void setInputUnit(Unit inputUnit) {
        this.inputUnit = inputUnit;
    }

    public Unit getOutputUnit() {
        return outputUnit;
    }

    public void setOutputUnit(Unit outputUnit) {
        this.outputUnit = outputUnit;
    }

    public double getInputValue() {
        return inputValue;
    }

    public void setInputValue(double inputValue) {
        this.inputValue = inputValue;
    }

    public double getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(double outputValue) {
        this.outputValue = outputValue;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }
}