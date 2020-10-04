package com.codurance.srp.output;

import com.codurance.srp.Console;

public class ConsoleOutput implements OutputChannel {
    private final Console console;

    public ConsoleOutput(Console console) {
        this.console = console;
    }


    @Override
    public void printLine(String line) {
        console.printLine(line);
    }
}
