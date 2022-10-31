package com.nm1022.tool.rental.unit;

import com.nm1022.tool.rental.ToolRentalApplication;
import com.nm1022.tool.rental.service.CheckoutService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class ToolRentalApplicationTests {

    @Mock
    CheckoutService checkoutService;

    @InjectMocks
    ToolRentalApplication toolRentalApplication;

    @Test
    public void executeRequests_WhenInvalidRentalDayCountIsInvalid_ShouldThrowException() {
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
}