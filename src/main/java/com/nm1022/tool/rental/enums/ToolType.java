package com.nm1022.tool.rental.enums;

public enum ToolType {
    Chainsaw("Chainsaw"),
    Ladder("Ladder"),
    Jackhammer("Jackhammer");

    public final String value;

    private ToolType(String value) {
        this.value = value;
    }
}