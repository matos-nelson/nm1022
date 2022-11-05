package com.nm1022.tool.rental.handler.rental.term;

import com.nm1022.tool.rental.persistence.model.ChargeIndicators;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LaborDayRentalTerm extends RentalTermHandler {
    public LaborDayRentalTerm(RentalTermHandler next) {
        super(next);
    }

    @Override
    public boolean doHandle(List<LocalDate> rentalDates, ChargeIndicators chargeIndicators) {
        if(chargeIndicators.isHolidayCharge()) {
            return false;
        }

        Set<Integer> years = new HashSet<>();
        for(LocalDate localDate : rentalDates) {
            years.add(localDate.getYear());
        }

        years.forEach(year -> {
            LocalDate laborDay =  LocalDate.of(year, Month.SEPTEMBER, 1)
                    .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
            rentalDates.removeIf(rd -> rd.equals(laborDay));
        });

        return false;
    }
}