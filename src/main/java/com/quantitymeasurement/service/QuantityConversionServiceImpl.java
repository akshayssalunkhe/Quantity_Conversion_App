package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.enums.Unit;
import com.quantitymeasurement.exception.QuantityMeasurementException;
import com.quantitymeasurement.repository.QuantityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.quantitymeasurement.enums.Unit.FAHRENHEIT;

@Service
public class QuantityConversionServiceImpl implements IQuantityConversionService {

    @Autowired
    QuantityRepository quantityRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public QuantityDTO convertUnit(QuantityDTO quantityDTO) {
        if (quantityDTO.getInitialUnit().unitType.equals(quantityDTO.getOutputUnitG().unitType)) {
            double outPutValue = (quantityDTO.getInputValue() * quantityDTO.getInitialUnit().conversionValue)
                    / quantityDTO.getOutputUnitG().conversionValue;
            quantityDTO.setOutputValue(outPutValue);
            return quantityDTO;
        }
        throw new QuantityMeasurementException("Unit type doesn't exists", QuantityMeasurementException.ExceptionType.UNIT_TYPE_DOES_NOT_EXIST);
    }

    @Override
    public QuantityDTO getConversion(QuantityDTO quantityDTO) {
        double outputValue;
        //GETTING BASE UNIT OF CURRENT UNIT TYPE
        Unit baseUnit = quantityDTO.getUnitType().baseUnit;

        //CHECKING INPUT AND REQUIRED OUTPUT UNIT ARE SAME OR NOT
        if (quantityDTO.getInputUnit().equals(quantityDTO.getOutputUnit()))
            outputValue = quantityDTO.getInputValue();

        else if (quantityDTO.getInputUnit().equals(FAHRENHEIT))
            outputValue = (quantityDTO.getInputValue() - 32) * 5 / 9;
        else if (quantityDTO.getInputUnit().equals(Unit.CELCIUS))
            outputValue = (quantityDTO.getInputValue() * 9 / 5) + 32;
        else

            //GET OUTPUT VALUE USING DATABASE
            outputValue = getOutputValue(quantityDTO, baseUnit);
        quantityDTO.setOutputValue(outputValue);
        return quantityDTO;
    }

    private double getOutputValue(QuantityDTO quantityDTO, Unit baseUnit) {
        //CONVERTING INPUT UNIT TO ITS BASE VALUE
        double inputToBaseUnit = quantityRepository.findById(quantityDTO.getInputUnit() + "_TO_"
                + baseUnit).get().getConversionValue();
        //CONVERTING OUTPUT UNIT TO ITS BASE VALUE
        double outputToBaseUnit = quantityRepository.findById(quantityDTO.getOutputUnit() + "_TO_"
                + baseUnit).get().getConversionValue();
        //CONVERTING INPUT VALUE TO OUTPUT VALUE
        return inputToBaseUnit / outputToBaseUnit * quantityDTO.getInputValue();
    }
}