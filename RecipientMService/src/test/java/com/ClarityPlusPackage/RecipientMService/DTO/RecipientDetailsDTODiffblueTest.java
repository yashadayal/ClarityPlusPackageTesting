package com.ClarityPlusPackage.RecipientMService.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RecipientDetailsDTODiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link RecipientDetailsDTO}
     *   <li>{@link RecipientDetailsDTO#setInstituteID(String)}
     *   <li>{@link RecipientDetailsDTO#setOrderID(String)}
     *   <li>{@link RecipientDetailsDTO#setPersonalEmailID(String)}
     *   <li>{@link RecipientDetailsDTO#setRecipientFirstName(String)}
     *   <li>{@link RecipientDetailsDTO#setRecipientLastName(String)}
     *   <li>{@link RecipientDetailsDTO#setRecipientPhoneNumber(String)}
     *   <li>{@link RecipientDetailsDTO#setRetailer(String)}
     *   <li>{@link RecipientDetailsDTO#getInstituteID()}
     *   <li>{@link RecipientDetailsDTO#getOrderID()}
     *   <li>{@link RecipientDetailsDTO#getPersonalEmailID()}
     *   <li>{@link RecipientDetailsDTO#getRecipientFirstName()}
     *   <li>{@link RecipientDetailsDTO#getRecipientLastName()}
     *   <li>{@link RecipientDetailsDTO#getRecipientPhoneNumber()}
     *   <li>{@link RecipientDetailsDTO#getRetailer()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RecipientDetailsDTO actualRecipientDetailsDTO = new RecipientDetailsDTO();
        actualRecipientDetailsDTO.setInstituteID("Institute ID");
        actualRecipientDetailsDTO.setOrderID("Order ID");
        actualRecipientDetailsDTO.setPersonalEmailID("jane.doe@example.org");
        actualRecipientDetailsDTO.setRecipientFirstName("Jane");
        actualRecipientDetailsDTO.setRecipientLastName("Doe");
        actualRecipientDetailsDTO.setRecipientPhoneNumber("6625550144");
        actualRecipientDetailsDTO.setRetailer("Retailer");
        String actualInstituteID = actualRecipientDetailsDTO.getInstituteID();
        String actualOrderID = actualRecipientDetailsDTO.getOrderID();
        String actualPersonalEmailID = actualRecipientDetailsDTO.getPersonalEmailID();
        String actualRecipientFirstName = actualRecipientDetailsDTO.getRecipientFirstName();
        String actualRecipientLastName = actualRecipientDetailsDTO.getRecipientLastName();
        String actualRecipientPhoneNumber = actualRecipientDetailsDTO.getRecipientPhoneNumber();
        assertEquals("6625550144", actualRecipientPhoneNumber);
        assertEquals("Doe", actualRecipientLastName);
        assertEquals("Institute ID", actualInstituteID);
        assertEquals("Jane", actualRecipientFirstName);
        assertEquals("Order ID", actualOrderID);
        assertEquals("Retailer", actualRecipientDetailsDTO.getRetailer());
        assertEquals("jane.doe@example.org", actualPersonalEmailID);
    }
}
