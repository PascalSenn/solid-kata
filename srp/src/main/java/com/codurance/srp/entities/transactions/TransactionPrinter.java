package com.codurance.srp.entities.transactions;

import com.codurance.srp.formatter.Formatter;
import com.codurance.srp.output.OutputChannel;
import com.codurance.srp.printer.Printer;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

public class TransactionPrinter implements Printer<Transaction> {
    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private final OutputChannel channel;
    private final Formatter<LocalDate> dateFormatter;
    private final Formatter<Integer> decimalFormatter;

    public TransactionPrinter(
            OutputChannel channel,
            Formatter<LocalDate> dateFormatter,
            Formatter<Integer> decimalFormatter) {
        this.channel = channel;
        this.dateFormatter = dateFormatter;
        this.decimalFormatter = decimalFormatter;
    }


    @Override
    public void print(List<Transaction> entities) {
        printHeader();
        printTransactions(entities);
    }

    private void printHeader() {
        printLine(STATEMENT_HEADER);
    }


    private void printTransactions(List<Transaction> transactions) {
        final AtomicInteger balance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction, balance.addAndGet(transaction.amount())))
                .collect(toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(this::printLine);
    }

    private String statementLine(Transaction transaction, int balance) {
        return MessageFormat.format("{0} | {1} | {2}",
                dateFormatter.format(transaction.date()),
                decimalFormatter.format(transaction.amount()),
                decimalFormatter.format(balance));
    }

    private void printLine(String line) {
        channel.printLine(line);
    }
}
