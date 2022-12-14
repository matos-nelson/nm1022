package com.nm1022.tool.rental;

import com.nm1022.tool.rental.persistence.model.RentalAgreement;
import com.nm1022.tool.rental.service.CheckoutService;
import com.nm1022.tool.rental.util.DateFormatterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ToolRentalApplication implements CommandLineRunner {

    private final CheckoutService checkoutService;

    @Autowired
    public ToolRentalApplication(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ToolRentalApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            executeRequest(args);
        } catch (Exception e) { }
    }

    private void validateArgs(String... args) throws Exception {
        try {

            int rentalDayCount = Integer.parseInt(args[1]);
            if(rentalDayCount < 1 ) {
                throw new Exception("Rental Days Requested Needs To Be At Least 1 or Greater.");
            }

            byte discountPercent = Byte.parseByte(args[2]);
            if( discountPercent < 0 || discountPercent > 100) {
                throw new Exception("Discount Percent Needs To Be In Range of 0-100.");
            }

        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public RentalAgreement executeRequest(String...args) throws Exception {
        try {
            validateArgs(args);

            String toolCode = args[0];
            int rentalDayCount = Integer.parseInt(args[1]);
            byte discountPercent = Byte.parseByte(args[2]);
            LocalDate checkoutDate = LocalDate.parse(args[3], DateFormatterUtil.USA_DATE_FORMATTER);

            RentalAgreement rentalAgreement = checkoutService.checkout(toolCode, rentalDayCount, discountPercent, checkoutDate);
            System.out.println(rentalAgreement);

            return rentalAgreement;
        } catch (Exception e) {
            throw e;
        }
    }
}