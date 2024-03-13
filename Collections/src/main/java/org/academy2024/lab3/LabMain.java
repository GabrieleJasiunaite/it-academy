package org.academy2024.lab3;

import org.academy2024.Color;
import org.academy2024.DataHelper;
import org.academy2024.LinePrinter;
import org.academy2024.Transaction;
import org.academy2024.lab2.StatementLine;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    private void exercise_3_1_printTopTransactions() {

        List<Transaction> transactions = DataHelper.loadTransactions();
        int howManyBiggestAmounts = 4;

        //TODO: Find the biggest transactions

        Set<Transaction> biggestTransactions = transactions.stream()
                .sorted(((o1, o2) -> o2.amount().compareTo(o1.amount())))
                .limit(howManyBiggestAmounts)
                .collect(Collectors.toSet());

        transactions.forEach(s -> LinePrinter.print(biggestTransactions.contains(s) ? Color.GREEN : Color.RED, s.toString()));
    }

    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.exercise_3_1_printTopTransactions();

    }
}
