package com.relay42.tomatobackend.controller;

import com.relay42.tomatobackend.domain.Sale;
import com.relay42.tomatobackend.domain.Provider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

import static com.relay42.tomatobackend.util.DatesUtil.getDatesBetween;
import static com.relay42.tomatobackend.util.DatesUtil.toEpochMilli;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("sales")
public class SalesResource {
    private static final int TOMATOES_UPPER_BOUND = 2000;
    private static final int CURRENT_YEAR = 2017;
    private static final int PROVIDERS_COUNT = Provider.values().length;

    @RequestMapping("/data")
    public List<Sale> get(@RequestParam(value = "size", required = false, defaultValue = "3") int size) {
        return buildSalesList(size);
    }

    private List<Sale> buildSalesList(int size) {
        return IntStream.range(0, size)
                .mapToObj(item -> {
                    LocalDate startDate = LocalDate.ofYearDay(CURRENT_YEAR, 1);
                    LocalDate endDate = LocalDate.now();
                    List<LocalDate> datesBetween = getDatesBetween(startDate, endDate);
                    return new Sale(
                            UUID.randomUUID().toString(),
                            new Random().nextInt(TOMATOES_UPPER_BOUND),
                            Provider.values()[new Random().nextInt(PROVIDERS_COUNT)].getStrValue(),
                            toEpochMilli(datesBetween.get(new Random().nextInt(datesBetween.size())))
                    );
                })
                .collect(toList());
    }
}
