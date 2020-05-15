package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.enums.Unit;
import com.quantitymeasurement.repository.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.quantitymeasurement.enums.Unit.FAHRENHEIT;

@Service
public class QuantityConversionServiceImpl implements IQuantityConversionService {

    @Autowired
    private QuantityRepository quantityRepository;

    @Override
    public double getConversion(QuantityDTO quantityDto) {
        double outputValue;
        final int CONVERSION_FACTORE = 32;
        final double FAHRENHEIT_TO_CELSIUS = (5 / 9);
        final double CELSIUS_TO_FAHRENHEIT = (9 / 5);

        //CHECKING INPUT AND REQUIRED OUTPUT UNIT ARE SAME OR NOT
        if (quantityDto.getInputUnit().equals(quantityDto.getOutputUnit()))
            outputValue = quantityDto.getInputValue();
        else if (quantityDto.getInputUnit().equals(FAHRENHEIT))
            outputValue = (quantityDto.getInputValue() - CONVERSION_FACTORE) * FAHRENHEIT_TO_CELSIUS;
        else if (quantityDto.getInputUnit().equals(Unit.CELSIUS))
            outputValue = (quantityDto.getInputValue() * CELSIUS_TO_FAHRENHEIT) + CONVERSION_FACTORE;
        else
            //GET OUTPUT VALUE USING DATABASE
            outputValue = getOutputValue(quantityDto);
        return outputValue;
    }

    private double getOutputValue(QuantityDTO quantityDto) {
        String connector = "_TO_";
        //CONVERTING INPUT UNIT TO ITS BASE VALUE
        double inputToBaseUnit = quantityRepository.findById(quantityDto.getInputUnit() + connector + quantityDto.getUnitType().baseUnit).get().getConversionValue();

        //CONVERTING OUTPUT UNIT TO ITS BASE VALUE
        double outputToBaseUnit = quantityRepository.findById(quantityDto.getOutputUnit() + connector + quantityDto.getUnitType().baseUnit).get().getConversionValue();

        //CONVERTING INPUT VALUE TO OUTPUT VALUE
        return (inputToBaseUnit / outputToBaseUnit * quantityDto.getInputValue());
    }
}