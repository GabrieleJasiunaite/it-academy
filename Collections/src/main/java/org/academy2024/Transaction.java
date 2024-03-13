package org.academy2024;

import java.math.BigDecimal;
import java.util.Date;

public record Transaction(
        String accountId,
        Date date,
        BigDecimal amount
) {
}
