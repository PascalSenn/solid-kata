package com.codurance.srp.printer;

import java.util.List;

public interface Printer<T> {
    void print(List<T> entities);
}
