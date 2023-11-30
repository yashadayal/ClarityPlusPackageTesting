package com.ClarityPlusPackage.RecipientMService.Controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.ClarityPlusPackage.RecipientMService.DTO.RecipientDetailsDTO;
import com.ClarityPlusPackage.RecipientMService.Service.RecipientDetailsService;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RecipientDetailsController.class})
@ExtendWith(SpringExtension.class)
class RecipientDetailsControllerDiffblueTest {
    @Autowired
    private RecipientDetailsController recipientDetailsController;

    @MockBean
    private RecipientDetailsService recipientDetailsService;

    /**
     * Method under test:  {@link RecipientDetailsController#searchByInstituteID(String)}
     */
    @Test
    void testSearchByInstituteID() throws Exception {
        when(recipientDetailsService.searchByInstituteID(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recipient/search/{instituteID}/",
                "Institute ID");
        MockMvcBuilders.standaloneSetup(recipientDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:  {@link RecipientDetailsController#searchLogsByInstituteID(String)}
     */
    @Test
    void testSearchLogsByInstituteID() throws Exception {
        when(recipientDetailsService.searchLogsByInstituteID(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recipient/search/logs/{instituteID}/",
                "Institute ID");
        MockMvcBuilders.standaloneSetup(recipientDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link RecipientDetailsController#saveData(RecipientDetailsDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveData() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: java.lang.NullPointerException: Cannot invoke "com.fasterxml.jackson.databind.JsonNode.asText()" because the return value of "com.fasterxml.jackson.databind.JsonNode.get(String)" is null
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:563)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:631)
        //   java.lang.NullPointerException: Cannot invoke "com.fasterxml.jackson.databind.JsonNode.asText()" because the return value of "com.fasterxml.jackson.databind.JsonNode.get(String)" is null
        //       at com.ClarityPlusPackage.RecipientMService.Config.CustomRecipientDeserializer.deserialize(CustomRecipientDeserializer.java:20)
        //       at com.ClarityPlusPackage.RecipientMService.Config.CustomRecipientDeserializer.deserialize(CustomRecipientDeserializer.java:12)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
        //       at com.fasterxml.jackson.databind.ObjectReader._bindAndClose(ObjectReader.java:2105)
        //       at com.fasterxml.jackson.databind.ObjectReader.readValue(ObjectReader.java:1481)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:563)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:631)
        //   See https://diff.blue/R013 to resolve this issue.

        RecipientDetailsController recipientDetailsController = new RecipientDetailsController();

        RecipientDetailsDTO recipientDetailsDTO = new RecipientDetailsDTO();
        recipientDetailsDTO.setInstituteID("Institute ID");
        recipientDetailsDTO.setOrderID("Order ID");
        recipientDetailsDTO.setPersonalEmailID("jane.doe@example.org");
        recipientDetailsDTO.setRecipientFirstName("Jane");
        recipientDetailsDTO.setRecipientLastName("Doe");
        recipientDetailsDTO.setRecipientPhoneNumber("6625550144");
        recipientDetailsDTO.setRetailer("Retailer");
        recipientDetailsController.saveData(recipientDetailsDTO);
    }

    /**
     * Method under test:  {@link RecipientDetailsController#getEmailIDByInstituteID(String)}
     */
    @Test
    void testGetEmailIDByInstituteID() throws Exception {
        when(recipientDetailsService.getEmailIDByInstituteID(Mockito.<String>any())).thenReturn("jane.doe@example.org");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recipient/getEmailID/{InstituteID}/",
                "Institute ID");
        MockMvcBuilders.standaloneSetup(recipientDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("jane.doe@example.org"));
    }

    /**
     * Method under test:  {@link RecipientDetailsController#checkOtp(int, String)}
     */
    @Test
    void testCheckOtp() throws Exception {
        when(recipientDetailsService.checkOtp(anyInt(), Mockito.<String>any())).thenReturn("Check Otp");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/recipient/checkotp/{InstituteID}/{otp}", "Institute ID", 1);
        MockMvcBuilders.standaloneSetup(recipientDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Check Otp"));
    }

    /**
     * Method under test:  {@link RecipientDetailsController#loginRecipient(String, String)}
     */
    @Test
    void testLoginRecipient() throws Exception {
        when(recipientDetailsService.loginRecipient(Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn("Login Recipient");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/recipient/login/recipient/{emailID}/{password}/", "jane.doe@example.org", "iloveyou");
        MockMvcBuilders.standaloneSetup(recipientDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Login Recipient"));
    }
}
