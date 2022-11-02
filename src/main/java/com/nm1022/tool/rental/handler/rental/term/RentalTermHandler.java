package com.nm1022.tool.rental.handler.rental.term;

import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

abstract class RentalTermHandler {
    private RentalTermHandler next;

    public RentalTermHandler(RentalTermHandler next) {
        this.next = next;
    }

    public void handle(List<LocalDate> rentalDates) {

        if(CollectionUtils.isEmpty(rentalDates) || doHandle(rentalDates))
            return;

        if(next != null)
            next.handle(rentalDates);
    }

    public abstract boolean doHandle(List<LocalDate> rentalDates);
}