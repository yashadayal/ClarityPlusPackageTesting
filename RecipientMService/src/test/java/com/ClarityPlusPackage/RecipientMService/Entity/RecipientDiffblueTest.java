package com.ClarityPlusPackage.RecipientMService.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RecipientDiffblueTest {
    /**
     * Method under test: {@link Recipient#setDefaultValues()}
     */
    @Test
    void testSetDefaultValues() {
        Recipient recipient = new Recipient();
        recipient.setDefaultValues();
        assertFalse(recipient.getReceived());
    }

    /**
     * Method under test: {@link Recipient#setDefaultValues()}
     */
    @Test
    void testSetDefaultValues2() {
        Recipient recipient = new Recipient();
        recipient.setInstituteID("Institute ID");
        recipient.setOTP(1);
        recipient.setOrderID("Order ID");
        recipient.setPersonalEmailID("jane.doe@example.org");
        recipient.setRecipientFirstName("Jane");
        recipient.setRecipientLastName("Doe");
        recipient.setRecipientPhoneNumber("6625550144");
        recipient.setRetailer("Retailer");
        recipient.setReceived(true);
        recipient.setDefaultValues();
        assertEquals("6625550144", recipient.getRecipientPhoneNumber());
        assertEquals("Doe", recipient.getRecipientLastName());
        assertEquals("Institute ID", recipient.getInstituteID());
        assertEquals("Jane", recipient.getRecipientFirstName());
        assertEquals("Order ID", recipient.getOrderID());
        assertEquals("Retailer", recipient.getRetailer());
        assertEquals("jane.doe@example.org", recipient.getPersonalEmailID());
        assertEquals(1, recipient.getOTP());
        assertTrue(recipient.getReceived());
    }
}
