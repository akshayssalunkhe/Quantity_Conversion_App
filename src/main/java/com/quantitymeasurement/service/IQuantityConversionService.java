package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.QuantityDTO;

public interface IQuantityConversionService {
    QuantityDTO getConversion(QuantityDTO quantityDto);

    QuantityDTO convertUnit(QuantityDTO quantityDTO);
}
