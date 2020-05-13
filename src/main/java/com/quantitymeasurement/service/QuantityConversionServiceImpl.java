package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.enums.Unit;
import com.quantitymeasurement.repository.QuantityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.quantitymeasurement.enums.Unit.FAHRENHEIT;

@Service
public class QuantityConversionServiceImpl implements IQuantityConversionService {

    @Autowired
    private QuantityRepository quantityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
//    public QuantityDTO getConversion(QuantityDTO quantityDTO) {
    public double getConversion(QuantityDTO quantityDto) {
        double outputValue;
        //GETTING BASE UNIT OF CURRENT UNIT TYPE
        Unit baseUnit = quantityDto.getUnitType().baseUnit;
        //CHECKING INPUT AND REQUIRED OUTPUT UNIT ARE SAME OR NOT
        if (quantityDto.getInputUnit().equals(quantityDto.getOutputUnit()))
            outputValue = quantityDto.getInputValue();
        else if (quantityDto.getInputUnit().equals(FAHRENHEIT))
            outputValue = (quantityDto.getInputValue() - 32) * 5 / 9;
        else if (quantityDto.getInputUnit().equals(Unit.CELSIUS))
            outputValue = (quantityDto.getInputValue() * 9 / 5) + 32;
        else
            //GET OUTPUT VALUE USING DATABASE
            outputValue = getOutputValue(quantityDto);
        return outputValue;
//        quantityDTO.setOutputValue(outputValue);
//        return quantityDTO;
    }

    private double getOutputValue(QuantityDTO quantityDto) {
        //CONVERTING INPUT UNIT TO ITS BASE VALUE
        double inputToBaseUnit = quantityRepository.findById(quantityDto.getInputUnit() + "_TO_" + quantityDto.getUnitType().baseUnit).get().getConversionValue();
        //CONVERTING OUTPUT UNIT TO ITS BASE VALUE
        double outputToBaseUnit = quantityRepository.findById(quantityDto.getOutputUnit() + "_TO_" + quantityDto.getUnitType().baseUnit).get().getConversionValue();
        //CONVERTING INPUT VALUE TO OUTPUT VALUE
        return (inputToBaseUnit / outputToBaseUnit * quantityDto.getInputValue());
    }
}