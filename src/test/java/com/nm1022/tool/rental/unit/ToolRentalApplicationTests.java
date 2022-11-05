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

@ContextConfiguration(classes = {ToolRentalApplication.class})
@RunWith(SpringRunner.class)
public class ToolRentalApplicationTests {

    @Autowired
    ToolRentalApplication toolRentalApplication;

    @Test
    public void executeRequest_WhenGivenRentalDayCountIsInvalid_ShouldThrowException() {
        // Arrange
        String args[] = {"CHNS", "0", "0", "2022-10-25"};
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
        String args[] = {"JAKR", "5", "101", "2015-09-03"};
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
        String args[] = {"LADW", "3", "10", "2020-07-02"};

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
    }

    @Test
    public void Test3() throws Exception {
        // Arrange
        String args[] = {"CHNS", "5", "25", "2015-07-02"};

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
    }

    @Test
    public void Test4() throws Exception {
        // Arrange
        String args[] = {"JAKD", "6", "0", "2015-09-03"};

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
    }

    @Test
    public void Test5() throws Exception {
        // Arrange
        String args[] = {"JAKR", "9", "0", "2015-07-02"};

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
    }
    @Test
    public void Test6() throws Exception {
        // Arrange
        String args[] = {"JAKR", "4", "50", "2020-07-02"};

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
    }

}