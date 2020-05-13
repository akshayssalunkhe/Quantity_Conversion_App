package com.quantitymeasurement.controller;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.service.IQuantityConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unitConversion")
public class QuantityConverterApplication {

    @Autowired
    private IQuantityConversionService conversionService;

    @GetMapping("/quantityConversion")
    public double getConvertedQuantity(@RequestBody QuantityDTO quantityDto) {
        return conversionService.getConversion(quantityDto);
    }

    @PostMapping("/addConversion")
    public double addConvertedQuantity(@RequestBody QuantityDTO quantityDto) {
        return conversionService.getConversion(quantityDto);
    }
}

