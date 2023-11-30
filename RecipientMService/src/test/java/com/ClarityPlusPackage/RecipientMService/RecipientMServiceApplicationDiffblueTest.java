package com.ClarityPlusPackage.RecipientMService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class RecipientMServiceApplicationDiffblueTest {
    /**
     * Method under test: {@link RecipientMServiceApplication#run(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRun() throws InterruptedException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ClarityPlusPackage.RecipientMService.Service.RecipientDetailsService.dataPopulate()" because "this.recipientDetailsService" is null
        //       at com.ClarityPlusPackage.RecipientMService.RecipientMServiceApplication.run(RecipientMServiceApplication.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        (new RecipientMServiceApplication()).run("Args");
    }
}
