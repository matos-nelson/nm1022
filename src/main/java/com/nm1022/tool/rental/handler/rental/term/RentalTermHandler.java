package com.nm1022.tool.rental.handler.rental.term;

import com.nm1022.tool.rental.persistence.model.ChargeIndicators;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

abstract class RentalTermHandler {
    private final RentalTermHandler next;

    public RentalTermHandler(RentalTermHandler next) {
        this.next = next;
    }

    public void handle(List<LocalDate> rentalDates, ChargeIndicators chargeIndicators) {

        if(CollectionUtils.isEmpty(rentalDates) || doHandle(rentalDates, chargeIndicators))
            return;

        if(next != null)
            next.handle(rentalDates, chargeIndicators);
    }

    public abstract boolean doHandle(List<LocalDate> rentalDates, ChargeIndicators chargeIndicators);
}