package com.celsius.application;

import java.math.BigDecimal;
import java.util.List;

public record QuoteRequest(String origin, String destination, BigDecimal weightKg, BigDecimal declaredValue, List<String> services) {}
