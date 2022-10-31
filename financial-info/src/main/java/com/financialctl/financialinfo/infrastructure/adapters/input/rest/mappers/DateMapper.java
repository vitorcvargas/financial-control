package com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.lang.String.format;

public class DateMapper {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String asString(ZonedDateTime date) {
        return date != null ? getAbsoluteDateString(date) : null;
    }

    private String getAbsoluteDateString(final ZonedDateTime date) {
        return date.format(formatter).split(" ")[0];
    }

    public ZonedDateTime asDate(String date) {
        try {
            final String[] split = date.split("T");
            final String dateString = format("%s 00:00:00", split[0]);
            final String timeZone = split[1];

            return ZonedDateTime.of(LocalDateTime.parse(dateString, formatter), ZoneId.of(timeZone));

        } catch (
                DateTimeParseException e) {
            //TODO throw custom exception
            throw new RuntimeException(e);
        }
    }
}
