package com.retail.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.retail.service.impl.AffiliateDiscountServiceImpl;
import com.retail.service.impl.StaffDiscountServiceImpl;

@SpringBootTest
public class AffilicateDiscountTest {

    @InjectMocks
    AffiliateDiscountServiceImpl service;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void generateDiscountTest() {
        assertEquals(service.generateDiscount(null),0.1,0);
    }

}
