package com.nm1022.tool.rental.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarUtil {

    public static List<LocalDate> getRentalDates(LocalDate checkoutDate, int numOfRentalDays) {

        List<LocalDate> rentalDates = new ArrayList<>();
        for(int i = 0; i <= numOfRentalDays; i++) {
            LocalDate date = checkoutDate.plusDays(i);
            rentalDates.add(date);
        }

        return rentalDates;
    }
}