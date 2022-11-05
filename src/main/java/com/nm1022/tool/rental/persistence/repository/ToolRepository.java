package com.nm1022.tool.rental.persistence.repository;

import com.nm1022.tool.rental.enums.Brand;
import com.nm1022.tool.rental.enums.ToolType;
import com.nm1022.tool.rental.persistence.model.ChargeIndicators;
import com.nm1022.tool.rental.persistence.model.RentalCharge;
import com.nm1022.tool.rental.persistence.model.Tool;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ToolRepository {
    private final Tool[] toolsData;

    public ToolRepository() {
        toolsData = new Tool[] {
                new Tool("CHNS", ToolType.Chainsaw, Brand.Stihl,
                        new RentalCharge(BigDecimal.valueOf(1.49),
                                new ChargeIndicators(true, false, true))),
                new Tool("LADW", ToolType.Ladder, Brand.Werner,
                        new RentalCharge(BigDecimal.valueOf(1.99),
                                new ChargeIndicators(true, true, false))),
                new Tool("JAKD", ToolType.Jackhammer, Brand.DeWalt,
                        new RentalCharge(BigDecimal.valueOf(2.99),
                                new ChargeIndicators(true, false, false))),
                new Tool("JAKR", ToolType.Jackhammer, Brand.Ridgid,
                        new RentalCharge(BigDecimal.valueOf(2.99),
                                new ChargeIndicators(true, false, false))),
        };
    }


    public Tool findByCode(String toolCode) {
        for(Tool tool : toolsData) {
            if(tool.getCode().equals(toolCode)) {
                return tool;
            }
        }

        return null;
    }
}