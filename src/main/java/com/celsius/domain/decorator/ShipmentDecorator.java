package com.celsius.domain.decorator;

import com.celsius.domain.Shipment;
import java.util.Objects;

/** Decorator: implementa Shipment y mantiene una referencia al componente que envuelve. */
public abstract class ShipmentDecorator implements Shipment {
    protected final Shipment wrapped;
    protected ShipmentDecorator(Shipment wrapped) { this.wrapped = Objects.requireNonNull(wrapped); }
}
