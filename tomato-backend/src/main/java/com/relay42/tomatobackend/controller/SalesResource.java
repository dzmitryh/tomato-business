package com.relay42.tomatobackend.controller;

import com.relay42.tomatobackend.domain.Sale;
import com.relay42.tomatobackend.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("sales")
public class SalesResource {
    private final SalesService salesService;

    @Autowired
    public SalesResource(SalesService salesService) {
        this.salesService = salesService;
    }

    @RequestMapping("/data")
    public Collection<Sale> get(@RequestParam(value = "size", required = false, defaultValue = "3") int size) {
        return salesService.getSales(size);
    }
}
