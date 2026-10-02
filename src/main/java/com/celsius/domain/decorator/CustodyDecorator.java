package com.celsius.domain.decorator;

import com.celsius.domain.*;
import java.math.BigDecimal;

public final class CustodyDecorator extends ShipmentDecorator {
    public CustodyDecorator(Shipment wrapped) { super(wrapped); }
    @Override public Quote quote() {
        Quote inner = wrapped.quote();
        return inner.wrap(new QuoteLine("custody", "Cadena de custodia", "CustodyDecorator", "Actas de entrega y sello de integridad", new BigDecimal("18000")),
                "Handoffs documentados y sello de integridad", inner.deliveryHours(), "CustodyDecorator");
    }
}
