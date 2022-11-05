package com.nm1022.tool.rental.unit;

import com.nm1022.tool.rental.ToolRentalApplication;
import com.nm1022.tool.rental.enums.Brand;
import com.nm1022.tool.rental.enums.ToolType;
import com.nm1022.tool.rental.persistence.model.RentalAgreement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = { ToolRentalApplication.class })
@RunWith(SpringRunner.class)
public class ToolRentalApplicationTests {

    @Autowired
    ToolRentalApplication toolRentalApplication;

    @Test
    public void executeRequest_WhenGivenRentalDayCountIsInvalid_ShouldThrowException() {
        // Arrange
        String args[] = {"CHNS", "0", "0", "10/25/2022"};
        Exception result = null;

        // Act
        try {
            toolRentalApplication.executeRequest(args);
        } catch (Exception e) {
            result = e;
        }

        // Assert
        assertNotNull(result);
        assertEquals("Rental Days Requested Needs To Be At Least 1 or Greater.", result.getMessage());
    }

    @Test
    public void executeRequest_WhenGivenDiscountIsOutOfRange_ShouldThrowException_Test1() {
        // Arrange
        String args[] = {"JAKR", "5", "101", "09/03/2015"};
        Exception result = null;

        // Act
        try {
            toolRentalApplication.executeRequest(args);
        } catch (Exception e) {
            result = e;
        }

        // Assert
        assertNotNull(result);
        assertEquals("Discount Percent Needs To Be In Range of 0-100.", result.getMessage());
    }

    @Test
    public void Test2() throws Exception {
        // Arrange
        String args[] = {"LADW", "3", "10", "07/02/2020"};

        // Act
        RentalAgreement result = toolRentalApplication.executeRequest(args);

        // Assert
        assertNotNull(result);
        assertEquals("LADW", result.getTool().getCode());
        assertEquals(ToolType.Ladder, result.getTool().getType());
        assertEquals(Brand.Werner, result.getTool().getBrand());
        assertEquals(3, result.getRentalDays());
        assertEquals(LocalDate.of(2020, Month.JULY, 2), result.getCheckoutDate());
        assertEquals(LocalDate.of(2020, Month.JULY, 5), result.getDueDate());
        assertEquals(BigDecimal.valueOf(1.99), result.getDailyRentalCharge());
        assertEquals(2, result.getTotalChargeDays());
        assertEquals(BigDecimal.valueOf(3.98), result.getPreDiscountCharge());
        assertEquals(10, result.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(0.4).setScale(2), result.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(3.58), result.getFinalCharge());
        assertNotNull(result.toString());
        assertEquals(
                "Tool code: LADW\n" +
                "Tool type: Ladder\n" +
                "Tool brand: Werner\n"  +
                "Rental days: 3\n" +
                "Check out date: 07/02/2020\n" +
                "Due date: 07/05/2020\n" +
                "Daily rental charge: $1.99\n" +
                "Charge days: 2\n" +
                "Pre-discount charge: $3.98\n" +
                "Discount percent: 10%\n" +
                "Discount amount: $0.40\n" +
                "Final charge: $3.58\n", result.toString());
    }

    @Test
    public void Test3() throws Exception {
        // Arrange
        String args[] = {"CHNS", "5", "25", "07/02/2015"};

        // Act
        RentalAgreement result = toolRentalApplication.executeRequest(args);

        // Assert
        assertNotNull(result);
        assertEquals("CHNS", result.getTool().getCode());
        assertEquals(ToolType.Chainsaw, result.getTool().getType());
        assertEquals(Brand.Stihl, result.getTool().getBrand());
        assertEquals(5, result.getRentalDays());
        assertEquals(LocalDate.of(2015, Month.JULY, 2), result.getCheckoutDate());
        assertEquals(LocalDate.of(2015, Month.JULY, 7), result.getDueDate());
        assertEquals(BigDecimal.valueOf(1.49), result.getDailyRentalCharge());
        assertEquals(3, result.getTotalChargeDays());
        assertEquals(BigDecimal.valueOf(4.47), result.getPreDiscountCharge());
        assertEquals(25, result.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(1.12).setScale(2), result.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(3.35), result.getFinalCharge());
        assertNotNull(result.toString());
        assertEquals("Tool code: CHNS\n" +
                "Tool type: Chainsaw\n" +
                "Tool brand: Stihl\n"  +
                "Rental days: 5\n" +
                "Check out date: 07/02/2015\n" +
                "Due date: 07/07/2015\n" +
                "Daily rental charge: $1.49\n" +
                "Charge days: 3\n" +
                "Pre-discount charge: $4.47\n" +
                "Discount percent: 25%\n" +
                "Discount amount: $1.12\n" +
                "Final charge: $3.35\n", result.toString());
    }

    @Test
    public void Test4() throws Exception {
        // Arrange
        String args[] = {"JAKD", "6", "0", "09/03/2015"};

        // Act
        RentalAgreement result = toolRentalApplication.executeRequest(args);

        // Assert
        assertNotNull(result);
        assertEquals("JAKD", result.getTool().getCode());
        assertEquals(ToolType.Jackhammer, result.getTool().getType());
        assertEquals(Brand.DeWalt, result.getTool().getBrand());
        assertEquals(6, result.getRentalDays());
        assertEquals(LocalDate.of(2015, Month.SEPTEMBER, 3), result.getCheckoutDate());
        assertEquals(LocalDate.of(2015, Month.SEPTEMBER, 9), result.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), result.getDailyRentalCharge());
        assertEquals(3, result.getTotalChargeDays());
        assertEquals(BigDecimal.valueOf(8.97), result.getPreDiscountCharge());
        assertEquals(0, result.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(0).setScale(2), result.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(8.97), result.getFinalCharge());
        assertNotNull(result.toString());
        assertEquals("Tool code: JAKD\n" +
                "Tool type: Jackhammer\n" +
                "Tool brand: DeWalt\n"  +
                "Rental days: 6\n" +
                "Check out date: 09/03/2015\n" +
                "Due date: 09/09/2015\n" +
                "Daily rental charge: $2.99\n" +
                "Charge days: 3\n" +
                "Pre-discount charge: $8.97\n" +
                "Discount percent: 0%\n" +
                "Discount amount: $0.00\n" +
                "Final charge: $8.97\n", result.toString());
    }

    @Test
    public void Test5() throws Exception {
        // Arrange
        String args[] = {"JAKR", "9", "0", "07/02/2015"};

        // Act
        RentalAgreement result = toolRentalApplication.executeRequest(args);

        // Assert
        assertNotNull(result);
        assertEquals("JAKR", result.getTool().getCode());
        assertEquals(ToolType.Jackhammer, result.getTool().getType());
        assertEquals(Brand.Ridgid, result.getTool().getBrand());
        assertEquals(9, result.getRentalDays());
        assertEquals(LocalDate.of(2015, Month.JULY, 2), result.getCheckoutDate());
        assertEquals(LocalDate.of(2015, Month.JULY, 11), result.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), result.getDailyRentalCharge());
        assertEquals(5, result.getTotalChargeDays());
        assertEquals(BigDecimal.valueOf(14.95), result.getPreDiscountCharge());
        assertEquals(0, result.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(0).setScale(2), result.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(14.95), result.getFinalCharge());
        assertNotNull(result.toString());
        assertEquals("Tool code: JAKR\n" +
                "Tool type: Jackhammer\n" +
                "Tool brand: Ridgid\n"  +
                "Rental days: 9\n" +
                "Check out date: 07/02/2015\n" +
                "Due date: 07/11/2015\n" +
                "Daily rental charge: $2.99\n" +
                "Charge days: 5\n" +
                "Pre-discount charge: $14.95\n" +
                "Discount percent: 0%\n" +
                "Discount amount: $0.00\n" +
                "Final charge: $14.95\n", result.toString());
    }

    @Test
    public void Test6() throws Exception {
        // Arrange
        String args[] = {"JAKR", "4", "50", "07/02/2020"};

        // Act
        RentalAgreement result = toolRentalApplication.executeRequest(args);

        // Assert
        assertNotNull(result);
        assertEquals("JAKR", result.getTool().getCode());
        assertEquals(ToolType.Jackhammer, result.getTool().getType());
        assertEquals(Brand.Ridgid, result.getTool().getBrand());
        assertEquals(4, result.getRentalDays());
        assertEquals(LocalDate.of(2020, Month.JULY, 2), result.getCheckoutDate());
        assertEquals(LocalDate.of(2020, Month.JULY, 6), result.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), result.getDailyRentalCharge());
        assertEquals(1, result.getTotalChargeDays());
        assertEquals(BigDecimal.valueOf(2.99), result.getPreDiscountCharge());
        assertEquals(50, result.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(1.50).setScale(2), result.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(1.49), result.getFinalCharge());
        assertNotNull(result.toString());
        assertEquals("Tool code: JAKR\n" +
                "Tool type: Jackhammer\n" +
                "Tool brand: Ridgid\n"  +
                "Rental days: 4\n" +
                "Check out date: 07/02/2020\n" +
                "Due date: 07/06/2020\n" +
                "Daily rental charge: $2.99\n" +
                "Charge days: 1\n" +
                "Pre-discount charge: $2.99\n" +
                "Discount percent: 50%\n" +
                "Discount amount: $1.50\n" +
                "Final charge: $1.49\n", result.toString());
    }

}