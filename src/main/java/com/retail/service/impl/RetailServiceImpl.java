package com.retail.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.retail.common.CommonConstants;
import com.retail.model.Bill;
import com.retail.model.User;
import com.retail.service.UserDiscountService;
import com.retail.service.RetailService;

/**
 * @author S426024
 *
 */
/**
 * @author S426024
 *
 */
@Service("retailService")
public class RetailServiceImpl implements RetailService {

    @Autowired
    @Qualifier("staffDiscount")
    UserDiscountService staffDiscount;
    
    @Autowired
    @Qualifier("affiliateDiscount")
    UserDiscountService affiliateDiscount;
    
    @Autowired
    @Qualifier("normalUserDiscount")
    UserDiscountService normalUserDiscount;
        
    /*
     * (non-Javadoc)
     * @see com.retail.service.RetailService#calculateDiscount(com.retail.model.Bill)
     * for every given bill the below method calculates the final bill amount after applying the discount if applicable
     */
     public Bill calculateDiscount(Bill bill) {

         double discountPercentage = discount(bill.getUser());
         
         bill.getBillItemMap().forEach((k,v) -> {
             double price = v.getProduct().getPrice() * v.getQuantity();
             
             double discount = !CommonConstants.PRODUCT_GROCERY.equalsIgnoreCase(v.getProduct().getProductCategory()) ?  (price * discountPercentage) : 0;
             
             v.setDiscount(discount);
             bill.setBillAmount(bill.getBillAmount()+ (price-discount));
         });
         
         return bill;
        
    }


    private double discount(User user) {
        
        double discount = 0;
        switch(user.getUserType()) {
            case CommonConstants.USER_TYPE_STAFF :
                discount = staffDiscount.generateDiscount(null);
                break;
            case CommonConstants.USER_TYPE_AFFILIATE :
                discount = affiliateDiscount.generateDiscount(null);
                break;
            default :
                discount = normalUserDiscount.generateDiscount(user);
                break;
        }
        return discount;
        
    }
}
