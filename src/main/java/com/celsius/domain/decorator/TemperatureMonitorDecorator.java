package com.celsius.domain.decorator;

import com.celsius.domain.*;
import java.math.BigDecimal;

public final class TemperatureMonitorDecorator extends ShipmentDecorator {
    public TemperatureMonitorDecorator(Shipment wrapped) { super(wrapped); }
    @Override public Quote quote() {
        Quote inner = wrapped.quote();
        return inner.wrap(new QuoteLine("monitor", "Registro de temperatura", "TemperatureMonitorDecorator", "Registrador de datos por envío", new BigDecimal("12000")),
                "Registro de temperatura durante el trayecto", inner.deliveryHours(), "TemperatureMonitorDecorator");
    }
}
