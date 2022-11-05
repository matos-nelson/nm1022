package com.nm1022.tool.rental.service;

import com.nm1022.tool.rental.handler.rental.term.RentalTermProcessor;
import com.nm1022.tool.rental.persistence.model.RentalAgreement;
import com.nm1022.tool.rental.persistence.model.Tool;
import com.nm1022.tool.rental.persistence.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CheckoutService {

    private final RentalTermProcessor rentalTermProcessor;
    private final ToolRepository toolRepository;

    @Autowired
    public CheckoutService(RentalTermProcessor rentalTermProcessor, ToolRepository toolRepository) {
        this.rentalTermProcessor = rentalTermProcessor;
        this.toolRepository = toolRepository;
    }

    public RentalAgreement checkout(String toolCode, int numOfRentalDays, byte discountPercent, LocalDate checkoutDate ) {
        Tool tool = toolRepository.findByCode(toolCode);
        int chargeDays = rentalTermProcessor.process(checkoutDate, numOfRentalDays, tool.getRentalCharge().getChargeIndicators());

        return new RentalAgreement
                .RentalAgreementBuilder(tool, numOfRentalDays, checkoutDate, chargeDays, discountPercent)
                .build();
    }
}