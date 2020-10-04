package com.codurance.srp.formatter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DecimalFormatter implements Formatter<Integer> {
    private final String pattern;
    private final DecimalFormat formatter;

    public DecimalFormatter(String pattern) {
        this.pattern = pattern;
        this.formatter = new DecimalFormat(pattern, DecimalFormatSymbols.getInstance(Locale.UK));
    }

    @Override
    public String format(Integer value) {
        return formatter.format(value);
    }
}
