package com.nm1022.tool.rental.persistence.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class RentalCharge {

    private BigDecimal dailyCharge;
    private ChargeIndicators chargeIndicators;

    private RentalCharge() { };

    public RentalCharge(BigDecimal dailyCharge, ChargeIndicators chargeIndicators) {
        this.dailyCharge = dailyCharge;
        this.chargeIndicators = chargeIndicators;
    }
}