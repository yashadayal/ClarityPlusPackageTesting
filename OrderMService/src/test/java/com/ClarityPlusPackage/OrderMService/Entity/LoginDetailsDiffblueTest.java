package com.ClarityPlusPackage.OrderMService.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LoginDetailsDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginDetails#LoginDetails()}
     *   <li>{@link LoginDetails#setEmailID(String)}
     *   <li>{@link LoginDetails#setPassword(String)}
     *   <li>{@link LoginDetails#getEmailID()}
     *   <li>{@link LoginDetails#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor() {
        LoginDetails actualLoginDetails = new LoginDetails();
        actualLoginDetails.setEmailID("jane.doe@example.org");
        actualLoginDetails.setPassword("iloveyou");
        String actualEmailID = actualLoginDetails.getEmailID();
        assertEquals("iloveyou", actualLoginDetails.getPassword());
        assertEquals("jane.doe@example.org", actualEmailID);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginDetails#LoginDetails(String, String)}
     *   <li>{@link LoginDetails#setEmailID(String)}
     *   <li>{@link LoginDetails#setPassword(String)}
     *   <li>{@link LoginDetails#getEmailID()}
     *   <li>{@link LoginDetails#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LoginDetails actualLoginDetails = new LoginDetails("jane.doe@example.org", "iloveyou");
        actualLoginDetails.setEmailID("jane.doe@example.org");
        actualLoginDetails.setPassword("iloveyou");
        String actualEmailID = actualLoginDetails.getEmailID();
        assertEquals("iloveyou", actualLoginDetails.getPassword());
        assertEquals("jane.doe@example.org", actualEmailID);
    }
}
