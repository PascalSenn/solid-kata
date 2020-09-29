package com.codurance.srp.formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormat implements Formatter<LocalDate> {
    private final String pattern;
    private final DateTimeFormatter dateFormatter;

    public DateTimeFormat(String pattern) {
        this.pattern = pattern;
        this.dateFormatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public String format(LocalDate value) {
        return dateFormatter.format(value);
    }
}
