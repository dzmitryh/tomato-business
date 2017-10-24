package com.relay42.tomatobackend.service;

import com.relay42.tomatobackend.domain.Provider;
import com.relay42.tomatobackend.domain.Sale;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.util.stream.Collectors.toList;

@Service
public class SalesServiceImpl implements SalesService {
    private static final int TOMATOES_UPPER_BOUND = 2000;
    private static final int PROVIDERS_COUNT = Provider.values().length;

    @Override
    public Collection<Sale> getSales(int size) {
        return IntStream.range(0, size)
                .mapToObj(item -> {
                    List<LocalDate> dates = getDates();
                    return Sale.create(
                            UUID.randomUUID().toString(),
                            new Random().nextInt(TOMATOES_UPPER_BOUND),
                            Provider.values()[new Random().nextInt(PROVIDERS_COUNT)].getStrValue(),
                            toEpochMilli(dates.get(new Random().nextInt(dates.size())))
                    );
                })
                .sorted(Comparator.comparing(sale -> (sale.timestamp())))
                .collect(toList());
    }

    private static List<LocalDate> getDates() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.with(firstDayOfYear());
        return  Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(startDate, now))
                .collect(toList());
    }

    private static long toEpochMilli(LocalDate localDate) {
        return localDate.atStartOfDay().atZone(ZoneOffset.UTC)
                .toInstant().toEpochMilli();
    }
}
