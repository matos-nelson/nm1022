package com.nm1022.tool.rental.enums;

public enum Brand {
    Stihl("Stihl"),
    Werner("Werner"),
    DeWalt("DeWalt"),
    Ridgid("Ridgid");

    public final String value;

    private Brand(String value) {
        this.value = value;
    }
}