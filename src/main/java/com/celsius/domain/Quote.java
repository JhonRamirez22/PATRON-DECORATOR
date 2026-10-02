package com.celsius.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/** Valor inmutable. Cada decorador devuelve una copia enriquecida de la cotización interior. */
public record Quote(BigDecimal total, int deliveryHours, List<QuoteLine> lines, List<String> capabilities, String expression) {
    public Quote {
        total = total.setScale(0, RoundingMode.HALF_UP);
        lines = List.copyOf(lines);
        capabilities = List.copyOf(capabilities);
    }

    public Quote wrap(QuoteLine line, String capability, int hours, String className, String... arguments) {
        var nextLines = new ArrayList<>(lines);
        nextLines.add(line);
        var nextCapabilities = new ArrayList<>(capabilities);
        nextCapabilities.add(capability);
        return new Quote(total.add(line.amount()), hours, nextLines, nextCapabilities,
                "new " + className + "(" + expression + (arguments.length == 0 ? "" : ", " + String.join(", ", arguments)) + ")");
    }
}
