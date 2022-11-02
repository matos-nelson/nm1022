package com.nm1022.tool.rental.persistence.model;

import lombok.Getter;

@Getter
public class RentalCharge {

    private float dailyCharge;
    private ChargeIndicators chargeIndicators;

    private RentalCharge() { };

    public RentalCharge(float dailyCharge, ChargeIndicators chargeIndicators) {
        this.dailyCharge = dailyCharge;
        this.chargeIndicators = chargeIndicators;
    }
}