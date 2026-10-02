package com.celsius.domain;

import java.math.BigDecimal;

public record QuoteLine(String id, String name, String className, String description, BigDecimal amount) {}
