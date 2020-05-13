package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.QuantityDTO;

public interface IQuantityConversionService {
    double getConversion(QuantityDTO quantityDto);
}