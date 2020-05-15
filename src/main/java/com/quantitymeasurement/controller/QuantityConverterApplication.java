package com.quantitymeasurement.controller;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.service.IQuantityConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unitConversion")
public class QuantityConverterApplication {

    @Autowired
    private IQuantityConversionService conversionService;

    @PutMapping("/addConversion")
    public double ConvertedQuantity(@RequestBody QuantityDTO quantityDto) {
        return conversionService.getConversion(quantityDto);
    }
}