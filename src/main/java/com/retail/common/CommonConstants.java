package com.retail.common;

import java.text.SimpleDateFormat;

public class CommonConstants {

    public static final String USER_TYPE_STAFF = "STAFF";
    public static final String USER_TYPE_AFFILIATE = "AFFILIATE";
    public static final  String USER_TYPE_NORMAL = "NORMAL";
    public static final int YEARS_OF_USER_RELATION = -2;
    
    public static final double STAFF_DISCOUNT = 0.3;
    public static final double AFFILIATE_DISCOUNT = 0.1;
    public static final double USER_DISCOUNT = 0.05;
    
    public static final String PRODUCT_GROCERY = "Grocery";
    public static final String PRODUCT_UTILITY = "Utility";
    
    public static final  SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
}
