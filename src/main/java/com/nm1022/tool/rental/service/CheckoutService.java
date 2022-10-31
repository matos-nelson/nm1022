package com.nm1022.tool.rental.service;

import com.nm1022.tool.rental.persistence.model.RentalAgreement;
import com.nm1022.tool.rental.util.CalendarUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CheckoutService {
    public RentalAgreement checkout(String toolCode, int numOfRentalDays, byte discountPercent, LocalDate checkoutDate ) {
        return new RentalAgreement();
    }
}