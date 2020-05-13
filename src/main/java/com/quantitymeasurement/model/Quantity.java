package com.quantitymeasurement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quantityconv")
public class Quantity {
    @Id
    private String conversionId;
    private double conversionValue;

    public String getConversionId() {
        return conversionId;
    }

    public void setConversionId(String conversionId) {
        this.conversionId = conversionId;
    }

    public double getConversionValue() {
        return conversionValue;
    }

    public void setConversionValue(double conversionValue) {
        this.conversionValue = conversionValue;
    }
}