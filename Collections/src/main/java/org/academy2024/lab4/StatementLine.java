package org.academy2024.lab4;

import java.math.BigDecimal;
import java.util.Date;

public record StatementLine (
        String name,
        String accountId,
        Date date,
        BigDecimal amount
) {
}
