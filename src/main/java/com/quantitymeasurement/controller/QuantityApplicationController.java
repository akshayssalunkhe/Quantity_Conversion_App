package com.quantitymeasurement.controller;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.service.IQuantityConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unitConversion")
public class QuantityApplicationController {

    @Autowired
    IQuantityConversionService conversionService;

    @GetMapping("/quantityConversion")
    public QuantityDTO getConvertedQuantity(@RequestBody QuantityDTO quantityDto) {
        return conversionService.getConversion(quantityDto);
    }

    @PostMapping("/unit/convert")
    public QuantityDTO convertUnitValue(@RequestBody QuantityDTO quantityDTO) {
        return conversionService.convertUnit(quantityDTO);
    }
}
