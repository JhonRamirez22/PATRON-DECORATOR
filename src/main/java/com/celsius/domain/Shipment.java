package com.celsius.domain;

/** Component: tanto el envío base como todos sus wrappers comparten este contrato. */
public interface Shipment {
    Quote quote();
}
