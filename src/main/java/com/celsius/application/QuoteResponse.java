package com.celsius.application;

import com.celsius.domain.Quote;
import com.celsius.domain.ShipmentContext;

public record QuoteResponse(ShipmentContext shipment, Quote base, Quote decorated, String disclaimer) {}
