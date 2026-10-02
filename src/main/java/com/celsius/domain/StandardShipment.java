package com.celsius.domain;

import java.math.BigDecimal;
import java.util.List;

/** Concrete Component: transporte interurbano base; las tarifas son datos del simulador. */
public final class StandardShipment implements Shipment {
    private final ShipmentContext context;
    public StandardShipment(ShipmentContext context) { this.context = context; }

    @Override public Quote quote() {
        boolean coastal = context.origin().equals("Barranquilla") || context.destination().equals("Barranquilla");
        BigDecimal routeFee = new BigDecimal(coastal ? "42000" : "28000");
        BigDecimal amount = routeFee.add(context.weightKg().multiply(new BigDecimal("4200"))).setScale(0, java.math.RoundingMode.HALF_UP);
        return new Quote(amount, coastal ? 72 : 48,
                List.of(new QuoteLine("base", "Transporte interurbano", "StandardShipment", "Tarifa de ruta + $4.200 por kg", amount)),
                List.of("Transporte entre ciudades"), "new StandardShipment(context)");
    }
}
