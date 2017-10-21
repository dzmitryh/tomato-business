package com.relay42.tomatobackend.util;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public final class DatesUtil {
    private DatesUtil() {
    }

    public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
        return Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(startDate, endDate))
                .collect(toList());
    }

    public static long toEpochMilli(LocalDate localDate) {
        return localDate.atStartOfDay().atZone(ZoneOffset.UTC)
                .toInstant().toEpochMilli();
    }
}
