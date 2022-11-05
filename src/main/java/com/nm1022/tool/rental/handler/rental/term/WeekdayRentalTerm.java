package com.nm1022.tool.rental.handler.rental.term;

import com.nm1022.tool.rental.persistence.model.ChargeIndicators;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

class WeekdayRentalTerm extends RentalTermHandler {
    public WeekdayRentalTerm(RentalTermHandler next) {
        super(next);
    }

    @Override
    public boolean doHandle(List<LocalDate> rentalDates, ChargeIndicators chargeIndicators) {

        if(!chargeIndicators.isWeekdayCharge()) {
            rentalDates.removeIf(rd -> rd.getDayOfWeek() != DayOfWeek.SATURDAY &&
                            rd.getDayOfWeek() != DayOfWeek.SUNDAY);
        }

        return false;
    }
}