package com.ClarityPlusPackage.OrderMService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class OrderMServiceApplicationDiffblueTest {
    /**
     * Method under test: {@link OrderMServiceApplication#run(String[])}
     */


    @Test
    @Disabled("TODO: Complete this test")
    void testRun() throws InterruptedException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ClarityPlusPackage.OrderMService.Service.OrderService.dataPopulate()" because "this.orderService" is null
        //       at com.ClarityPlusPackage.OrderMService.OrderMServiceApplication.run(OrderMServiceApplication.java:26)
        //   See https://diff.blue/R013 to resolve this issue.

        (new OrderMServiceApplication()).run("Args");
    }
}
