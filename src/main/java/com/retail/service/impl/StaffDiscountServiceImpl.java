package com.retail.service.impl;

import org.springframework.stereotype.Service;

import com.retail.common.CommonConstants;
import com.retail.model.User;
import com.retail.service.UserDiscountService;

@Service("staffDiscount")
public class StaffDiscountServiceImpl implements UserDiscountService
{

    /*
     * (non-Javadoc)
     * @see com.retail.service.DiscountService#generateDiscount(com.retail.model.User)
     * 
     * provides Staff specific discount
     */
    @Override
    public double generateDiscount(User user) {     
        return CommonConstants.STAFF_DISCOUNT;
    }
}
