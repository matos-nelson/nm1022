package com.nm1022.tool.rental.handler.rental.term;

import com.nm1022.tool.rental.persistence.model.ChargeIndicators;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class IndependenceDayRentalTerm extends RentalTermHandler {
    public IndependenceDayRentalTerm(RentalTermHandler next) {
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
            LocalDate independenceDay =  LocalDate.of(year, Month.JULY, 4);
            if (independenceDay.getDayOfWeek() == DayOfWeek.SATURDAY) {
                rentalDates.removeIf(rd -> rd.equals(independenceDay.minusDays(1)));
            } else if (independenceDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
                rentalDates.removeIf(rd -> rd.equals(independenceDay.plusDays(1)));
            } else {
                rentalDates.removeIf(rd -> rd.equals(independenceDay));
            }
        });

        return false;
    }
}