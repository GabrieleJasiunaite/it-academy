package org.academy2024.lab2;

import org.academy2024.Color;
import org.academy2024.LinePrinter;

import java.math.BigDecimal;
import java.util.Date;

public record StatementLine(

        Color color,
        String accountId,
        Date date,
        BigDecimal amount
) {
    public void print(LinePrinter linePrinter) {
        linePrinter.print("Transaction: " + this);
    }
}
