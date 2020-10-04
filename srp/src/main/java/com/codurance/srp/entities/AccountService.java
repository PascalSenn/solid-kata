package com.codurance.srp.entities;


import com.codurance.srp.Clock;
import com.codurance.srp.entities.transactions.Transaction;
import com.codurance.srp.entities.transactions.TransactionRepository;
import com.codurance.srp.printer.Printer;

public final class AccountService {

    private TransactionRepository transactionRepository;
    private Clock clock;
    private final Printer<Transaction> printer;

    public AccountService(
            TransactionRepository transactionRepository,
            Clock clock,
            Printer<Transaction> printer) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;

        this.printer = printer;
    }

    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }

    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }

    public void printStatement() {
        printer.print(transactionRepository.all());
    }
}