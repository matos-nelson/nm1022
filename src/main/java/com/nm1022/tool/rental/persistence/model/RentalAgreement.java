package com.nm1022.tool.rental.persistence.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RentalAgreement {
    private Tool tool;
    private short rentalDays;
    private LocalDateTime checkoutDate;
    private LocalDateTime dueDate;
    private float dailyRentalCharge;
    private short totalChargeDays;
    private double preDiscountCharge;
    private byte discountPercent;
    private double discountAmount;
    private double finalCharge;
}