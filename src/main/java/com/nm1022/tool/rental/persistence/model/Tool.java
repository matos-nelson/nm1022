package com.nm1022.tool.rental.persistence.model;

import com.nm1022.tool.rental.enums.Brand;
import com.nm1022.tool.rental.enums.ToolType;
import lombok.Getter;

@Getter
public class Tool {
    private String code;
    private ToolType type;
    private Brand brand;
    private RentalCharge rentalCharge;

    private Tool() { };

    public Tool (String code, ToolType type, Brand brand, RentalCharge rentalCharge) {
        this.code = code;
        this.type = type;
        this.brand = brand;
        this.rentalCharge = rentalCharge;
    }
}