package org.academy2024.lab1;

import org.academy2024.Color;
import org.academy2024.DataHelper;
import org.academy2024.LinePrinter;
import org.academy2024.Transaction;
import java.util.List;


public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    private void exercise_1_1_simplyPrintTransactions() {

        transactions.forEach(t -> LinePrinter.print(Color.GREEN, t.toString()));
        LinePrinter.resetColor();
    }

    private void exercise_1_2_printTransactionsSorted() {

        //TODO: Sort transactions here
        //transactions.sort(????);

        // transactions.sort((Comparator.comparing(Transaction::amount)));
        // to swap the order we switch o2 with o1
        transactions.sort((o1, o2) -> o1.amount().compareTo(o2.amount()));
        transactions.sort((o1, o2) -> o1.date().compareTo(o2.date()));

        transactions.forEach(t -> LinePrinter.print(Color.GREEN, t.toString()));
        LinePrinter.resetColor();
    }


    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.exercise_1_1_simplyPrintTransactions();
        lab.exercise_1_2_printTransactionsSorted();
    }
}
