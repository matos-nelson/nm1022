package com.nm1022.tool.rental.persistence.model;

import lombok.Getter;

@Getter
public class ChargeIndicators {
    private boolean weekdayCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;

    private ChargeIndicators() { };

    public ChargeIndicators(boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }
}