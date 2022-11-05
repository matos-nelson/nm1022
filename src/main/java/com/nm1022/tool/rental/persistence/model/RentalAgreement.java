package com.nm1022.tool.rental.persistence.model;

import com.nm1022.tool.rental.util.CalendarUtil;
import com.nm1022.tool.rental.util.DateFormatterUtil;
import com.nm1022.tool.rental.util.DecimalFormatterUtil;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class RentalAgreement {
    private Tool tool;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private int totalChargeDays;
    private BigDecimal preDiscountCharge;
    private BigDecimal dailyRentalCharge;
    private byte discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal finalCharge;


    @Override
    public String toString() {
        return "Tool code: " + this.tool.getCode() + "\n" +
               "Tool type: " + this.tool.getType().toString() + "\n" +
               "Tool brand: " + this.tool.getBrand().toString() + "\n" +
               "Rental days: " + this.rentalDays + "\n" +
               "Check out date: " + DateFormatterUtil.USA_DATE_FORMATTER.format(this.getCheckoutDate()) + "\n" +
               "Due date: " + DateFormatterUtil.USA_DATE_FORMATTER.format(this.getDueDate()) + "\n" +
               "Daily rental charge: " + DecimalFormatterUtil.US_CURRENCY_FORMATTER.format(this.dailyRentalCharge) + "\n" +
               "Charge days: " + this.totalChargeDays + "\n" +
               "Pre-discount charge: " + DecimalFormatterUtil.US_CURRENCY_FORMATTER.format(this.preDiscountCharge) + "\n" +
               "Discount percent: " + this.discountPercent + "%\n" +
               "Discount amount: " + DecimalFormatterUtil.US_CURRENCY_FORMATTER.format(this.discountAmount) + "\n" +
               "Final charge: " + DecimalFormatterUtil.US_CURRENCY_FORMATTER.format(this.finalCharge) + "\n";
    }

    public static class RentalAgreementBuilder {
        private Tool tool;
        private int rentalDays;
        private LocalDate checkoutDate;
        private int chargeDays;
        private byte discountPercent;

        public RentalAgreementBuilder(Tool tool, int rentalDays, LocalDate checkoutDate, int chargeDays, byte discountPercent) {
            this.tool = tool;
            this.rentalDays = rentalDays;
            this.checkoutDate = checkoutDate;
            this.chargeDays = chargeDays;
            this.discountPercent = discountPercent;
        }

        public RentalAgreement build() {
            RentalAgreement rentalAgreement = new RentalAgreement();

            rentalAgreement.setTool(this.tool);
            rentalAgreement.setRentalDays(this.rentalDays);
            rentalAgreement.setCheckoutDate(this.checkoutDate);

            List<LocalDate> rentalDates = CalendarUtil.getRentalDates(this.checkoutDate, this.rentalDays);
            rentalAgreement.setDueDate(rentalDates.get(rentalDates.size()-1));

            rentalAgreement.setDailyRentalCharge(this.tool.getRentalCharge().getDailyCharge());

            rentalAgreement.setTotalChargeDays(this.chargeDays);

            BigDecimal preDiscountCharge =
                    this.tool.getRentalCharge().getDailyCharge()
                            .multiply(BigDecimal.valueOf(this.chargeDays))
                            .setScale(2, RoundingMode.HALF_UP);

            rentalAgreement.setPreDiscountCharge(preDiscountCharge);
            rentalAgreement.setDiscountPercent(this.discountPercent);

            BigDecimal discountAmount = preDiscountCharge.multiply(BigDecimal.valueOf((this.discountPercent / 100.0)))
                    .setScale(2, RoundingMode.HALF_UP);
            rentalAgreement.setDiscountAmount(discountAmount);

            rentalAgreement.setFinalCharge(preDiscountCharge.subtract(discountAmount));
            return rentalAgreement;
        }
    }
}