package com.nm1022.tool.rental.handler.rental.term;

import com.nm1022.tool.rental.util.CalendarUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalTermProcessor {
    private RentalTermHandler rentalTermHandler;

    public RentalTermProcessor() {
        LaborDayRentalTerm laborDayRentalTerm = new LaborDayRentalTerm(null);
        IndependenceDayRentalTerm independenceDayRentalTerm = new IndependenceDayRentalTerm(laborDayRentalTerm);
        WeekendRentalTerm weekendRentalTerm = new WeekendRentalTerm(independenceDayRentalTerm);
        WeekdayRentalTerm weekdayRentalTerm = new WeekdayRentalTerm(weekendRentalTerm);
        this.rentalTermHandler = weekdayRentalTerm;
    }

    public void process(LocalDate checkoutDate, int numOfRentalDays) {
        List<LocalDate> rentalDates = CalendarUtil.getRentalDates(checkoutDate, numOfRentalDays);
        rentalTermHandler.handle(rentalDates);
    }
}