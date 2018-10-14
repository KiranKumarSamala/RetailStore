package com.retail.service.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.retail.common.CommonConstants;
import com.retail.model.User;
import com.retail.service.impl.NormalUserDiscountServiceImpl;

@SpringBootTest
public class NormalUserDiscountTest {

    User normalUserEligibleForDiscount;
    User normalUserNotEligibleForDiscount;
    @InjectMocks
    NormalUserDiscountServiceImpl service;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);        
        try {
            normalUserEligibleForDiscount = new User(4, "Luce",  CommonConstants.USER_TYPE_NORMAL, CommonConstants.sdf.parse("10-07-2016"), "+971551234515", "Luce-4");
            normalUserNotEligibleForDiscount = new User(3, "Helen",  CommonConstants.USER_TYPE_NORMAL, CommonConstants.sdf.parse("10-07-2018"), "+971551234514", "Helen-3");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void generateDiscountNotEligibleTest() {
        assertEquals(service.generateDiscount(normalUserNotEligibleForDiscount),0.0,0);
    }

    @Test
    public void generateDiscountEligibleTest() {
        assertEquals(service.generateDiscount(normalUserEligibleForDiscount),0.05,0);
    }
}
