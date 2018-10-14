package com.retail.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.retail.common.CommonConstants;
import com.retail.model.User;
import com.retail.service.UserDiscountService;

@Service("normalUserDiscount")
public class NormalUserDiscountServiceImpl implements UserDiscountService {

    /*
     * (non-Javadoc)
     * @see com.retail.service.DiscountService#generateDiscount(com.retail.model.User)
     * 
     * provides user specific discount
     */
    @Override
    public double generateDiscount(User user) {    
        
        double discount = 0;
        
        Calendar calendar  = Calendar.getInstance();
        calendar.add(Calendar.YEAR, CommonConstants.YEARS_OF_USER_RELATION);
        calendar.add(Calendar.DATE, -1);
        Date d1 = calendar.getTime();

        if(user.getRegisteredDate().getTime()<d1.getTime()) {
            discount = CommonConstants.USER_DISCOUNT;
        }
        return discount;
    }
    
}
