package com.retail.service.impl;

import org.springframework.stereotype.Service;

import com.retail.common.CommonConstants;
import com.retail.model.User;
import com.retail.service.UserDiscountService;

@Service("affiliateDiscount")
public class AffiliateDiscountServiceImpl implements UserDiscountService {

    /*
     * (non-Javadoc)
     * @see com.retail.service.DiscountService#generateDiscount(com.retail.model.User)
     * 
     * provides Affiliate specific discount
     */
    @Override
    public double generateDiscount(User user) {        
        return CommonConstants.AFFILIATE_DISCOUNT;
    }
}
