package com.retail.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.retail.common.CommonConstants;
import com.retail.model.Bill;
import com.retail.model.BillItem;
import com.retail.model.Product;
import com.retail.model.User;
import com.retail.service.UserDiscountService;
import com.retail.service.impl.RetailServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RetailServiceTest{

    @InjectMocks
    RetailServiceImpl retailService;
    
    User staffUser;
    User affiliateUser;
    User normalUserEligibleForDiscount;
    User normalUserNotEligibleForDiscount;
    
    @Mock
    UserDiscountService affiliateDiscount;
    
    @Mock
    UserDiscountService normalUserDiscount;
    
    @Mock
    private UserDiscountService staffDiscount;
    
    Bill bill;
    
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        
        try {
            staffUser = new User(1, "Mark", CommonConstants.USER_TYPE_STAFF, CommonConstants.sdf.parse("10-08-2016"), "+971551234510", "Mark-1");
            affiliateUser = new User(2, "Bill",  CommonConstants.USER_TYPE_AFFILIATE, CommonConstants.sdf.parse("10-08-2017"), "+971551234513", "Bill-2");
            normalUserNotEligibleForDiscount = new User(3, "Helen",  CommonConstants.USER_TYPE_NORMAL, CommonConstants.sdf.parse("10-07-2018"), "+971551234514", "Helen-3");
            normalUserEligibleForDiscount = new User(4, "Luce",  CommonConstants.USER_TYPE_NORMAL, CommonConstants.sdf.parse("10-07-2016"), "+971551234515", "Luce-4");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        bill = this.prepareSampleproductData();
        
    }
    
    private Bill prepareSampleproductData() {
        Bill bill = new Bill();        

        Product groceryProduct1 = new Product(1, "Milk", "Grocery",10);
        Product groceryProduct2 = new Product(2, "Curd", "Grocery",5);
        Product nonGroceryProduct1 = new Product(3, "LuncBox", "Utility",20);
        
        // Added 2 products of Milk        
        BillItem item1 = new BillItem();
        item1.setProduct(groceryProduct1);
        item1.setQuantity(2);        
        bill.getBillItemMap().put(1, item1);

        // Added 1 products of Curd
        BillItem item2 = new BillItem();
        item2.setProduct(groceryProduct2);
        item2.setQuantity(1);
        bill.getBillItemMap().put(2, item2);

        // Added 1 products of LunchBox
        BillItem item3 = new BillItem();
        item3.setProduct(nonGroceryProduct1);
        item3.setQuantity(1);
        bill.getBillItemMap().put(3, item3);
        return bill;
    }
   
    /*
     * UserType : Staff
     * 2 products of Milk : 10*2 = 20.  No discount as its  grocery : 0
     * 1 product of Curd : 5*1 = 5      No discount as its  grocery  : 0
     * 1 product of LunchBox 20*1 = 20. 30% discount, discounted price  : 14
     * 
     * Expected result is 20 + 5 + 14  = 39
     * 
     */
	@Test
	public void staffDiscountTest() {
	        
	    when(staffDiscount.generateDiscount(null)).thenReturn(0.3);
	    
        bill.setUser(staffUser);                
        bill = retailService.calculateDiscount(bill);
        assertEquals(39,bill.getBillAmount(),0);
	}

    /*
     * UserType : Affilidate 
     * 2 products of Milk : 10*2 = 20.  No discount as its  grocery : 0
     * 1 product of Curd : 5*1 = 5      No discount as its  grocery  : 0
     * 1 product of LunchBox 20*1 = 20. 10% discount, discounted price  : 18
     * 
     * Expected result is 20 + 5 + 18  = 43
     * 
     */
    @Test
    public void affiliateDiscountTest() {
            
        when(affiliateDiscount.generateDiscount(null)).thenReturn(0.1);
        bill.setUser(affiliateUser);                
        bill = retailService.calculateDiscount(bill);
        assertEquals(43,bill.getBillAmount(),0);      
    }

    /*
     * UserType : Normal Registered 2 years back 
     * 2 products of Milk : 10*2 = 20.  No discount as its  grocery : 0
     * 1 product of Curd : 5*1 = 5      No discount as its  grocery  : 0
     * 1 product of LunchBox 20*1 = 20. 5% discount, discounted price  : 19
     * 
     * Expected result is 20 + 5 + 19  = 44
     * 
     */
    @Test
    public void normalUserDiscountTest() {
            
        when(normalUserDiscount.generateDiscount(any(User.class))).thenReturn(0.05);
        bill.setUser(normalUserEligibleForDiscount);                
        bill = retailService.calculateDiscount(bill);
        assertEquals(44,bill.getBillAmount(),0);      
    }

    /*
     * UserType : Normal. Did not completed 2 years. No discount
     * 2 products of Milk : 10*2 = 20.
     * 1 product of Curd : 5*1 = 5    
     * 1 product of LunchBox 20*1 = 20. 
     * 
     * Expected result is 20 + 5 + 20 = 45
     * 
     */
    @Test
    public void normalUserNoDiscountTest() {
            
        when(normalUserDiscount.generateDiscount(any(User.class))).thenReturn(0.0);
        bill.setUser(normalUserNotEligibleForDiscount);                
        bill = retailService.calculateDiscount(bill);
        assertEquals(45.00,bill.getBillAmount(),0);            
    }
}
