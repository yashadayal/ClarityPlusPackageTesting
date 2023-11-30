package com.ClarityPlusPackage.RecipientMService.Service.Implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ClarityPlusPackage.RecipientMService.DTO.RecipientDetailsDTO;
import com.ClarityPlusPackage.RecipientMService.Entity.Recipient;
import com.ClarityPlusPackage.RecipientMService.Repository.LoginRepo;
import com.ClarityPlusPackage.RecipientMService.Repository.RecipientDetailsRepo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RecipientDetailsImplDiffblueTest {
  @MockBean
  private EmailConfig emailConfig;

  @MockBean
  private LoginRepo loginRepo;

  @Autowired
  private RecipientDetailsImpl recipientDetailsImpl;

  @MockBean
  private RecipientDetailsRepo recipientDetailsRepo;

  /**
   * Method under test:
   * {@link RecipientDetailsImpl#getEmailIDByInstituteID(String)}
   */
  @Test
  void testGetEmailIDByInstituteID() {
    doNothing().when(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    when(recipientDetailsRepo.findPersonalEmailIDByInstituteID(Mockito.<String>any()))
            .thenReturn("jane.doe@example.org");
    when(recipientDetailsRepo.findRecipientByInstituteID(Mockito.<String>any())).thenReturn(new ArrayList<>());
    String actualEmailIDByInstituteID = recipientDetailsImpl.getEmailIDByInstituteID("Institute ID");
    verify(recipientDetailsRepo).findPersonalEmailIDByInstituteID(Mockito.<String>any());
    verify(recipientDetailsRepo).findRecipientByInstituteID(Mockito.<String>any());
    verify(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    assertEquals("OTP to sent linked emailID successfully!", actualEmailIDByInstituteID);
  }

  /**
   * Method under test:
   * {@link RecipientDetailsImpl#getEmailIDByInstituteID(String)}
   */
  @Test
  void testGetEmailIDByInstituteID2() {
    doNothing().when(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    Recipient recipient = new Recipient();
    recipient.setInstituteID("Inside Implementation");
    recipient.setOTP(100000);
    recipient.setOrderID("Inside Implementation");
    recipient.setPersonalEmailID("jane.doe@example.org");
    recipient.setReceived(true);
    recipient.setRecipientFirstName("Jane");
    recipient.setRecipientLastName("Doe");
    recipient.setRecipientPhoneNumber("6625550144");
    recipient.setRetailer("Inside Implementation");

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient);
    doNothing().when(recipientDetailsRepo).saveByInstituteID(anyInt(), Mockito.<String>any());
    when(recipientDetailsRepo.findPersonalEmailIDByInstituteID(Mockito.<String>any()))
            .thenReturn("jane.doe@example.org");
    when(recipientDetailsRepo.findRecipientByInstituteID(Mockito.<String>any())).thenReturn(recipientList);
    String actualEmailIDByInstituteID = recipientDetailsImpl.getEmailIDByInstituteID("Institute ID");
    verify(recipientDetailsRepo).findPersonalEmailIDByInstituteID(Mockito.<String>any());
    verify(recipientDetailsRepo).findRecipientByInstituteID(Mockito.<String>any());
    verify(recipientDetailsRepo).saveByInstituteID(anyInt(), Mockito.<String>any());
    verify(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    assertEquals("OTP to sent linked emailID successfully!", actualEmailIDByInstituteID);
  }

  /**
   * Method under test:
   * {@link RecipientDetailsImpl#getEmailIDByInstituteID(String)}
   */
  @Test
  void testGetEmailIDByInstituteID3() {
    assertEquals("OTP to sent linked emailID successfully!",
            recipientDetailsImpl.getEmailIDByInstituteID("Institute ID"));
  }

  /**
   * Method under test:
   * {@link RecipientDetailsImpl#getEmailIDByInstituteID(String)}
   */
  @Test
  void testGetEmailIDByInstituteID4() {
    doNothing().when(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    Recipient recipient = new Recipient();
    recipient.setInstituteID("OTP for Delivering package");
    recipient.setOTP(100000);
    recipient.setOrderID("OTP for Delivering package");
    recipient.setPersonalEmailID("jane.doe@example.org");
    recipient.setReceived(true);
    recipient.setRecipientFirstName("Jane");
    recipient.setRecipientLastName("Doe");
    recipient.setRecipientPhoneNumber("6625550144");
    recipient.setRetailer("OTP for Delivering package");

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient);
    doNothing().when(recipientDetailsRepo).saveByInstituteID(anyInt(), Mockito.<String>any());
    when(recipientDetailsRepo.findPersonalEmailIDByInstituteID(Mockito.<String>any()))
            .thenReturn("jane.doe@example.org");
    when(recipientDetailsRepo.findRecipientByInstituteID(Mockito.<String>any())).thenReturn(recipientList);
    String actualEmailIDByInstituteID = recipientDetailsImpl.getEmailIDByInstituteID("Institute ID");
    verify(recipientDetailsRepo).findPersonalEmailIDByInstituteID(Mockito.<String>any());
    verify(recipientDetailsRepo).findRecipientByInstituteID(Mockito.<String>any());
    verify(recipientDetailsRepo).saveByInstituteID(anyInt(), Mockito.<String>any());
    verify(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    assertEquals("OTP to sent linked emailID successfully!", actualEmailIDByInstituteID);
  }

  /**
   * Method under test:
   * {@link RecipientDetailsImpl#getEmailIDByInstituteID(String)}
   */
  @Test
  void testGetEmailIDByInstituteID5() {
    assertEquals("OTP to sent linked emailID successfully!", recipientDetailsImpl.getEmailIDByInstituteID("42"));
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#sendMail(String, String)}
   */
  @Test
  void testSendMail() {
    doNothing().when(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    when(recipientDetailsRepo.findRecipientByInstituteID(Mockito.<String>any())).thenReturn(new ArrayList<>());
    recipientDetailsImpl.sendMail("jane.doe@example.org", "Institute ID");
    verify(recipientDetailsRepo).findRecipientByInstituteID(Mockito.<String>any());
    verify(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#sendMail(String, String)}
   */
  @Test
  void testSendMail2() {
    doNothing().when(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    Recipient recipient = new Recipient();
    recipient.setInstituteID("Inside sendMail");
    recipient.setOTP(100000);
    recipient.setOrderID("Inside sendMail");
    recipient.setPersonalEmailID("jane.doe@example.org");
    recipient.setReceived(true);
    recipient.setRecipientFirstName("Jane");
    recipient.setRecipientLastName("Doe");
    recipient.setRecipientPhoneNumber("6625550144");
    recipient.setRetailer("Inside sendMail");

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient);
    doNothing().when(recipientDetailsRepo).saveByInstituteID(anyInt(), Mockito.<String>any());
    when(recipientDetailsRepo.findRecipientByInstituteID(Mockito.<String>any())).thenReturn(recipientList);
    recipientDetailsImpl.sendMail("jane.doe@example.org", "Institute ID");
    verify(recipientDetailsRepo).findRecipientByInstituteID(Mockito.<String>any());
    verify(recipientDetailsRepo).saveByInstituteID(anyInt(), Mockito.<String>any());
    verify(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#sendMail(String, String)}
   */
  @Test
  void testSendMail3() {
    doNothing().when(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    Recipient recipient = new Recipient();
    recipient.setInstituteID("OTP for Delivering package");
    recipient.setOTP(100000);
    recipient.setOrderID("OTP for Delivering package");
    recipient.setPersonalEmailID("jane.doe@example.org");
    recipient.setReceived(true);
    recipient.setRecipientFirstName("Jane");
    recipient.setRecipientLastName("Doe");
    recipient.setRecipientPhoneNumber("6625550144");
    recipient.setRetailer("OTP for Delivering package");

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient);
    doNothing().when(recipientDetailsRepo).saveByInstituteID(anyInt(), Mockito.<String>any());
    when(recipientDetailsRepo.findRecipientByInstituteID(Mockito.<String>any())).thenReturn(recipientList);
    recipientDetailsImpl.sendMail("jane.doe@example.org", "Institute ID");
    verify(recipientDetailsRepo).findRecipientByInstituteID(Mockito.<String>any());
    verify(recipientDetailsRepo).saveByInstituteID(anyInt(), Mockito.<String>any());
    verify(emailConfig).sendOTPMail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#searchByInstituteID(String)}
   */
  @Test
  void testSearchByInstituteID() {
    assertTrue(recipientDetailsImpl.searchByInstituteID("Institute ID").isEmpty());
    assertTrue(recipientDetailsImpl.searchByInstituteID("select distinct U from").isEmpty());
  }



  /**
   * Method under test:
   * {@link RecipientDetailsImpl#searchLogsByInstituteID(String)}
   */
  //    @Test
  //    void testSearchLogsByInstituteID() {
  //        List<String> actualSearchLogsByInstituteIDResult = recipientDetailsImpl.searchLogsByInstituteID("Institute ID");
  //        System.out.println(actualSearchLogsByInstituteIDResult);
  //        assertEquals("42", actualSearchLogsByInstituteIDResult.get(0));
  //        assertEquals("Jane", actualSearchLogsByInstituteIDResult.get(2));
  //        assertEquals("Doe", actualSearchLogsByInstituteIDResult.get(3));
  //        assertEquals("Retailer", actualSearchLogsByInstituteIDResult.get(4));
  //    }

  /**
   * Method under test:
   * {@link RecipientDetailsImpl#searchLogsByInstituteID(String)}
   */

  /**
   * Method under test: {@link RecipientDetailsImpl#saveData(RecipientDetailsDTO)}
   */
  @Test
  void testSaveData() {
    RecipientDetailsDTO recipientDetailsDTO = new RecipientDetailsDTO();
    recipientDetailsDTO.setInstituteID("Institute ID");
    recipientDetailsDTO.setOrderID("Order ID");
    recipientDetailsDTO.setPersonalEmailID("jane.doe@example.org");
    recipientDetailsDTO.setRecipientFirstName("Jane");
    recipientDetailsDTO.setRecipientLastName("Doe");
    recipientDetailsDTO.setRecipientPhoneNumber("6625550144");
    recipientDetailsDTO.setRetailer("Retailer");
    assertEquals("Order details saved successfully!", recipientDetailsImpl.saveData(recipientDetailsDTO));
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#saveData(RecipientDetailsDTO)}
   */
  @Test
  void testSaveData2() {
    RecipientDetailsDTO recipientDetailsDTO = new RecipientDetailsDTO();
    recipientDetailsDTO.setInstituteID("Inside savedata");
    recipientDetailsDTO.setOrderID("Order ID");
    recipientDetailsDTO.setPersonalEmailID("jane.doe@example.org");
    recipientDetailsDTO.setRecipientFirstName("Jane");
    recipientDetailsDTO.setRecipientLastName("Doe");
    recipientDetailsDTO.setRecipientPhoneNumber("6625550144");
    recipientDetailsDTO.setRetailer("Retailer");
    assertEquals("Order details saved successfully!", recipientDetailsImpl.saveData(recipientDetailsDTO));
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#saveData(RecipientDetailsDTO)}
   */
  @Test
  void testSaveData3() {
    RecipientDetailsDTO recipientDetailsDTO = new RecipientDetailsDTO();
    recipientDetailsDTO.setInstituteID("Saving Recipient Details");
    recipientDetailsDTO.setOrderID("Order ID");
    recipientDetailsDTO.setPersonalEmailID("jane.doe@example.org");
    recipientDetailsDTO.setRecipientFirstName("Jane");
    recipientDetailsDTO.setRecipientLastName("Doe");
    recipientDetailsDTO.setRecipientPhoneNumber("6625550144");
    recipientDetailsDTO.setRetailer("Retailer");
    assertEquals("Order details saved successfully!", recipientDetailsImpl.saveData(recipientDetailsDTO));
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#saveData(RecipientDetailsDTO)}
   */
  @Test
  void testSaveData4() {
    Recipient recipient = new Recipient();
    recipient.setInstituteID("Institute ID");
    recipient.setOTP(1);
    recipient.setOrderID("Order ID");
    recipient.setPersonalEmailID("jane.doe@example.org");
    recipient.setReceived(true);
    recipient.setRecipientFirstName("Jane");
    recipient.setRecipientLastName("Doe");
    recipient.setRecipientPhoneNumber("6625550144");
    recipient.setRetailer("Retailer");
    when(recipientDetailsRepo.save(Mockito.<Recipient>any())).thenReturn(recipient);

    RecipientDetailsDTO recipientDetailsDTO = new RecipientDetailsDTO();
    recipientDetailsDTO.setInstituteID("Institute ID");
    recipientDetailsDTO.setOrderID("Order ID");
    recipientDetailsDTO.setPersonalEmailID("jane.doe@example.org");
    recipientDetailsDTO.setRecipientFirstName("Jane");
    recipientDetailsDTO.setRecipientLastName("Doe");
    recipientDetailsDTO.setRecipientPhoneNumber("6625550144");
    recipientDetailsDTO.setRetailer("Retailer");
    String actualSaveDataResult = recipientDetailsImpl.saveData(recipientDetailsDTO);
    verify(recipientDetailsRepo).save(Mockito.<Recipient>any());
    assertEquals("Order details saved successfully!", actualSaveDataResult);
  }

  /**
   * Method under test:  {@link RecipientDetailsImpl#checkOtp(int, String)}
   */
  @Test
  void testCheckOtp() {
    when(recipientDetailsRepo.findRecipientByInstituteID(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(recipientDetailsRepo.findOtpByInstituteID(Mockito.<String>any())).thenReturn(1);
    String actualCheckOtpResult = recipientDetailsImpl.checkOtp(1, "Institute ID");
    verify(recipientDetailsRepo).findOtpByInstituteID(Mockito.<String>any());
    verify(recipientDetailsRepo).findRecipientByInstituteID(Mockito.<String>any());
    assertEquals("OTP Verified!", actualCheckOtpResult);
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#checkOtp(int, String)}
   */
  @Test
  void testCheckOtp2() {
    Recipient recipient = new Recipient();
    recipient.setInstituteID("OTP Verification Process");
    recipient.setOTP(1);
    recipient.setOrderID("OTP Verification Process");
    recipient.setPersonalEmailID("jane.doe@example.org");
    recipient.setReceived(true);
    recipient.setRecipientFirstName("Jane");
    recipient.setRecipientLastName("Doe");
    recipient.setRecipientPhoneNumber("6625550144");
    recipient.setRetailer("OTP Verification Process");

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient);
    doNothing().when(recipientDetailsRepo).makeAsReceived(Mockito.<String>any());
    when(recipientDetailsRepo.findRecipientByInstituteID(Mockito.<String>any())).thenReturn(recipientList);
    when(recipientDetailsRepo.findOtpByInstituteID(Mockito.<String>any())).thenReturn(1);
    String actualCheckOtpResult = recipientDetailsImpl.checkOtp(1, "Institute ID");
    verify(recipientDetailsRepo).findOtpByInstituteID(Mockito.<String>any());
    verify(recipientDetailsRepo).findRecipientByInstituteID(Mockito.<String>any());
    verify(recipientDetailsRepo).makeAsReceived(Mockito.<String>any());
    assertEquals("OTP Verified!", actualCheckOtpResult);
  }

  /**
   * Method under test:  {@link RecipientDetailsImpl#checkOtp(int, String)}
   */
  @Test
  void testCheckOtp3() {
    when(recipientDetailsRepo.findOtpByInstituteID(Mockito.<String>any())).thenReturn(0);
    String actualCheckOtpResult = recipientDetailsImpl.checkOtp(1, "Institute ID");
    verify(recipientDetailsRepo).findOtpByInstituteID(Mockito.<String>any());
    assertEquals("OTP not verified!", actualCheckOtpResult);
  }

  /**
     * Method under test: {@link RecipientDetailsImpl#checkOtp(int, String)}
     */
  @Test
  void testCheckOtp4() {
    assertEquals("OTP not verified!", recipientDetailsImpl.checkOtp(1, "Institute ID"));
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#checkOtp(int, String)}
   */
  @Test
  void testCheckOtp5() {
    assertEquals("OTP not verified!", recipientDetailsImpl.checkOtp(73862, "Institute ID"));
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#checkOtp(int, String)}
   */
  @Test
  void testCheckOtp6() {
    assertEquals("OTP not verified!", recipientDetailsImpl.checkOtp(1, "42"));
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#checkOtp(int, String)}
   */
  @Test
  void testCheckOtp7() {
    assertEquals("OTP Verified!", recipientDetailsImpl.checkOtp(0, "42"));
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#checkOtp(int, String)}
   */
  @Test
  void testCheckOtp8() {
    assertEquals("OTP not verified!", recipientDetailsImpl.checkOtp(28532, "42"));
  }

  /**
   * Method under test: {@link RecipientDetailsImpl#checkOtp(int, String)}
   */

  /**
   * Method under test:
   * {@link RecipientDetailsImpl#loginRecipient(String, String)}
   */
  @Test
  void testLoginRecipient() {
    assertEquals("EmailID does not exist. \n Re-check the emailID or contact the admin.",
            recipientDetailsImpl.loginRecipient("jane.doe@example.org", "iloveyou"));
    assertEquals("EmailID does not exist. \n" + " Re-check the emailID or contact the admin.",
            recipientDetailsImpl.loginRecipient("aakanksha@gmail.com", "iloveyou"));

  }

  /**
   * Method under test: {@link RecipientDetailsImpl#dataPopulate()}
   */
  @Test
  void testDataPopulate() {
    assertEquals("Recipient Details Registered!", recipientDetailsImpl.dataPopulate());
  }
}
