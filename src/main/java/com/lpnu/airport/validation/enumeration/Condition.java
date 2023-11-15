package com.lpnu.airport.validation.enumeration;

public enum Condition {
    GREATER_THAN(">"),
    LESS_THAN("<"),
    EQUALS_BY_ADDRESS("==");

    private final String condition;

    Condition(final String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
