package com.retail.service.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.retail.service.test.AffilicateDiscountTest;
import com.retail.service.test.NormalUserDiscountTest;
import com.retail.service.test.RetailServiceTest;
import com.retail.service.test.StaffDiscountTest;

@RunWith(Suite.class)
@SuiteClasses({ AffilicateDiscountTest.class, NormalUserDiscountTest.class, RetailServiceTest.class,
        StaffDiscountTest.class })
public class RetailStoreTestSuite {

}
