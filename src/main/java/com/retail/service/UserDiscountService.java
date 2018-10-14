package com.retail.service;

import com.retail.model.User;

public interface UserDiscountService {

    /*
     * provide the implementation for UserDiscount based the user type
     */
    public double generateDiscount(User user);
}
