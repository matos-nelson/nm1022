package com.nm1022.tool.rental.persistence.repository;

import com.nm1022.tool.rental.enums.Brand;
import com.nm1022.tool.rental.enums.ToolType;
import com.nm1022.tool.rental.persistence.model.ChargeIndicators;
import com.nm1022.tool.rental.persistence.model.RentalCharge;
import com.nm1022.tool.rental.persistence.model.Tool;
import org.springframework.stereotype.Service;

@Service
public class ToolRepository {
    private Tool[] toolsData;

    public ToolRepository() {
        toolsData = new Tool[] {
                new Tool("CHNS", ToolType.Chainsaw, Brand.Stihl,
                        new RentalCharge(1.49f,
                                new ChargeIndicators(true, false, true))),
                new Tool("LADW", ToolType.Ladder, Brand.Werner,
                        new RentalCharge(1.99f,
                                new ChargeIndicators(true, true, false))),
                new Tool("JAKD", ToolType.Jackhammer, Brand.DeWalt,
                        new RentalCharge(2.99f,
                                new ChargeIndicators(true, false, false))),
                new Tool("JAKR", ToolType.Jackhammer, Brand.Ridgid,
                        new RentalCharge(2.99f,
                                new ChargeIndicators(true, false, false))),
        };
    }


    public Tool findByCode(String toolCode) {
        for(int i = 0; i < toolsData.length; i++) {
            if(toolsData[i].getCode().equals(toolCode)) {
                return toolsData[i];
            }
        }

        return null;
    }
}