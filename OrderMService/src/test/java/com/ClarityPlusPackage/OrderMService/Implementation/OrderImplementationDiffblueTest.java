package com.ClarityPlusPackage.OrderMService.Implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ClarityPlusPackage.OrderMService.Entity.LoginDetails;
import com.ClarityPlusPackage.OrderMService.Entity.Order;
import com.ClarityPlusPackage.OrderMService.Repository.LoginRepo;
import com.ClarityPlusPackage.OrderMService.Repository.OrderRepo;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
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
class OrderImplementationDiffblueTest {
  @MockBean
  private LoginRepo loginRepo;

  @Autowired
  private OrderImplementation orderImplementation;

  @MockBean
  private OrderRepo orderRepo;

  /**
   * Method under test:
   * {@link OrderImplementation#findOrderByOrderID(List, String)}
   */
  @Test
  void testFindOrderByOrderID() {
    List<String> actualFindOrderByOrderIDResult = orderImplementation.findOrderByOrderID(new ArrayList<>(),
            "Institute ID");
    assertEquals("There is no pending orders for InstituteID Institute ID. If there is any order yet to receive first"
            + " fill the form for corresponding orderID.", actualFindOrderByOrderIDResult.get(0));
    assertEquals(1, actualFindOrderByOrderIDResult.size());
  }

  /**
   * Method under test:  {@link OrderImplementation#findOrderByOrderID(List, String)}
   */
  @Test
  void testFindOrderByOrderID2() {
    when(orderRepo.findOrderByOrderID(Mockito.<String>any())).thenReturn("Order By Order ID");

    ArrayList<String> recipientDetailsList = new ArrayList<>();
    recipientDetailsList.add("Inside Implementation");
    List<String> actualFindOrderByOrderIDResult = orderImplementation.findOrderByOrderID(recipientDetailsList,
            "Institute ID");
    verify(orderRepo).findOrderByOrderID(Mockito.<String>any());
    assertEquals("Inside Implementation", actualFindOrderByOrderIDResult.get(0));
    assertEquals(1, actualFindOrderByOrderIDResult.size());
  }

  /**
   * Method under test:  {@link OrderImplementation#findOrderByOrderID(List, String)}
   */
  @Test
  void testFindOrderByOrderID3() {
    when(orderRepo.findOrderByOrderID(Mockito.<String>any())).thenReturn(null);

    ArrayList<String> recipientDetailsList = new ArrayList<>();
    recipientDetailsList.add("Inside Implementation");
    List<String> actualFindOrderByOrderIDResult = orderImplementation.findOrderByOrderID(recipientDetailsList,
            "Institute ID");
    verify(orderRepo).findOrderByOrderID(Mockito.<String>any());
    assertEquals("The order ID Inside Implementation has not been received in campus yet.\n"
            + " Please try again after order expected delivery date.", actualFindOrderByOrderIDResult.get(0));
    assertEquals(1, actualFindOrderByOrderIDResult.size());
  }

  /**
   * Method under test:  {@link OrderImplementation#findOrderByOrderID(List, String)}
   */
  @Test
  void testFindOrderByOrderID4() {
    when(orderRepo.findOrderByOrderID(Mockito.<String>any())).thenReturn("Order By Order ID");

    ArrayList<String> recipientDetailsList = new ArrayList<>();
    recipientDetailsList.add("Checking orderIDs in recipient are there in order or not");
    recipientDetailsList.add("Inside Implementation");
    List<String> actualFindOrderByOrderIDResult = orderImplementation.findOrderByOrderID(recipientDetailsList,
            "Institute ID");
    verify(orderRepo, atLeast(1)).findOrderByOrderID(Mockito.<String>any());
    assertEquals("Checking orderIDs in recipient are there in order or not", actualFindOrderByOrderIDResult.get(0));
    assertEquals("Inside Implementation", actualFindOrderByOrderIDResult.get(1));
    assertEquals(2, actualFindOrderByOrderIDResult.size());
  }

  /**
   * Method under test:
   * {@link OrderImplementation#findOrderByOrderID(List, String)}
   */
  @Test
  void testFindOrderByOrderID5() {
    ArrayList<String> recipientDetailsList = new ArrayList<>();
    recipientDetailsList.add("Inside Implementation");
    List<String> actualFindOrderByOrderIDResult = orderImplementation.findOrderByOrderID(recipientDetailsList,
            "Institute ID");
    assertEquals("The order ID Inside Implementation has not been received in campus yet.\n"
            + " Please try again after order expected delivery date.", actualFindOrderByOrderIDResult.get(0));
    assertEquals(1, actualFindOrderByOrderIDResult.size());
  }

  /**
   * Method under test:
   * {@link OrderImplementation#findOrderByOrderID(List, String)}
   */
  @Test
  void testFindOrderByOrderID6() {
    ArrayList<String> recipientDetailsList = new ArrayList<>();
    recipientDetailsList.add("U");
    recipientDetailsList.add("Inside Implementation");
    List<String> actualFindOrderByOrderIDResult = orderImplementation.findOrderByOrderID(recipientDetailsList,
            "Institute ID");
    assertEquals("The order ID Inside Implementation has not been received in campus yet.\n"
            + " Please try again after order expected delivery date.", actualFindOrderByOrderIDResult.get(1));
    assertEquals("The order ID U has not been received in campus yet.\n"
            + " Please try again after order expected delivery date.", actualFindOrderByOrderIDResult.get(0));
    assertEquals(2, actualFindOrderByOrderIDResult.size());
  }

  /**
   * Method under test:
   * {@link OrderImplementation#findOrderByOrderID(List, String)}
   */
  @Test
  void testFindOrderByOrderID7() {
    ArrayList<String> recipientDetailsList = new ArrayList<>();
    recipientDetailsList.add("MT2022137");
    List<String> actualFindOrderByOrderIDResult = orderImplementation.findOrderByOrderID(recipientDetailsList,
            "Institute ID");
    assertEquals("The order ID MT2022137 has not been received in campus yet.\n"
            + " Please try again after order expected delivery date.", actualFindOrderByOrderIDResult.get(0));
    assertEquals(1, actualFindOrderByOrderIDResult.size());
  }

  /**
   * Method under test:
   * {@link OrderImplementation#findOrderByOrderID(List, String)}
   */
  @Test
  void testFindOrderByOrderID8() {
    ArrayList<String> recipientDetailsList = new ArrayList<>();
    recipientDetailsList.add("42");
    List<String> actualFindOrderByOrderIDResult = orderImplementation.findOrderByOrderID(recipientDetailsList,
            "Institute ID");
    assertEquals("42", actualFindOrderByOrderIDResult.get(0));
    assertEquals(1, actualFindOrderByOrderIDResult.size());
  }

  /**
   * Method under test:
   * {@link OrderImplementation#findOrderByOrderID(List, String)}
   */
  @Test
  void testFindOrderByOrderID9() {
    ArrayList<String> recipientDetailsList = new ArrayList<>();
    recipientDetailsList.add("No pending orders");
    List<String> actualFindOrderByOrderIDResult = orderImplementation.findOrderByOrderID(recipientDetailsList,
            "Institute ID");
    assertEquals("The order ID No pending orders has not been received in campus yet.\n"
            + " Please try again after order expected delivery date.", actualFindOrderByOrderIDResult.get(0));
    assertEquals(1, actualFindOrderByOrderIDResult.size());
  }

  /**
   * Method under test:
   * {@link OrderImplementation#findOrderByOrderID(List, String)}
   */
  @Test
  void testFindOrderByOrderID10() {
    ArrayList<String> recipientDetailsList = new ArrayList<>();
    recipientDetailsList.add("U");
    recipientDetailsList.add("No pending orders");
    List<String> actualFindOrderByOrderIDResult = orderImplementation.findOrderByOrderID(recipientDetailsList,
            "Institute ID");
    assertEquals("The order ID No pending orders has not been received in campus yet.\n"
            + " Please try again after order expected delivery date.", actualFindOrderByOrderIDResult.get(1));
    assertEquals("The order ID U has not been received in campus yet.\n"
            + " Please try again after order expected delivery date.", actualFindOrderByOrderIDResult.get(0));
    assertEquals(2, actualFindOrderByOrderIDResult.size());
  }

  /**
     * Method under test:
     * {@link OrderImplementation#findOrderByOrderID(List, String)}
     */

  /**
   * Method under test:
   * {@link OrderImplementation#findOrderByOrderID(List, String)}
   */

  /**
   * Method under test: {@link OrderImplementation#saveOrder(Order[])}
   */
  @Test
  void testSaveOrder() {
    Order order = new Order();
    order.setDateOfDelivery(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setFirstName("Jane");
    order.setLastName("Doe");
    order.setOrderID("Order ID");
    order.setRetailer("Retailer");
    when(orderRepo.save(Mockito.<Order>any())).thenReturn(order);

    Order order2 = new Order();
    order2.setDateOfDelivery(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order2.setFirstName("Jane");
    order2.setLastName("Doe");
    order2.setOrderID("Order ID");
    order2.setRetailer("Retailer");
    String actualSaveOrderResult = orderImplementation.saveOrder(new Order[]{order2});
    verify(orderRepo).save(Mockito.<Order>any());
    assertEquals("Orders saved successfully!", actualSaveOrderResult);
  }

  /**
   * Method under test: {@link OrderImplementation#saveOrder(Order[])}
   */
  @Test
  void testSaveOrder2() {
    Order order = new Order();
    order.setDateOfDelivery(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setFirstName("Jane");
    order.setLastName("Doe");
    order.setOrderID("Order ID");
    order.setRetailer("Retailer");
    assertEquals("Orders saved successfully!", orderImplementation.saveOrder(new Order[]{order}));
  }

  /**
   * Method under test: {@link OrderImplementation#saveOrder(Order[])}
   */
  @Test
  void testSaveOrder3() {
    Order.OrderBuilder builderResult = Order.builder();
    Order buildResult = builderResult
            .DateOfDelivery(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .FirstName("Jane")
            .LastName("Doe")
            .OrderID("Order ID")
            .Retailer("Retailer")
            .build();
    buildResult
            .setDateOfDelivery(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    buildResult.setFirstName("Jane");
    buildResult.setLastName("Doe");
    buildResult.setOrderID("Order ID");
    buildResult.setRetailer("Retailer");
    assertEquals("Orders saved successfully!", orderImplementation.saveOrder(new Order[]{buildResult}));
  }

  /**
   * Method under test: {@link OrderImplementation#saveOrder(Order[])}
   */
  @Test
  void testSaveOrder4() {
    //        java.sql.Date DateOfDelivery = mock(java.sql.Date.class);
    //        when(DateOfDelivery.getTime()).thenReturn(10L);

    Order order = new Order();
    //order.setDateOfDelivery(DateOfDelivery);
    order.setFirstName("Jane");
    order.setLastName("Doe");
    order.setOrderID("Order ID");
    order.setRetailer("Retailer");
    String actualSaveOrderResult = orderImplementation.saveOrder(new Order[]{order});
    verify(orderRepo, times(1)).save(any(Order.class));
    //verify(DateOfDelivery, atLeast(1)).getTime();
    assertEquals("Orders saved successfully!", actualSaveOrderResult);
  }

  /**
   * Method under test: {@link OrderImplementation#saveOrder(Order[])}
   */
  @Test
  void testSaveOrder5() {
    //        java.sql.Date DateOfDelivery = mock(java.sql.Date.class);
    //        when(DateOfDelivery.getTime()).thenReturn(10L);

    Order order = new Order();
    //order.setDateOfDelivery(DateOfDelivery);
    order.setFirstName("Jane");
    order.setLastName("Doe");
    order.setOrderID("Order ID");
    order.setRetailer("Retailer");
    String actualSaveOrderResult = orderImplementation.saveOrder(new Order[]{order});
    verify(orderRepo, times(1)).save(any(Order.class));
    //verify(orderRepo, atLeast(1)).getTime();
    assertEquals("Orders saved successfully!", actualSaveOrderResult);
  }

  /**
   * Method under test: {@link OrderImplementation#saveOrder(Order[])}
   */
  @Test
  void testSaveOrder6() {
    java.sql.Date DateOfDelivery = mock(java.sql.Date.class);
    when(DateOfDelivery.getTime()).thenReturn(10L);

    Order order = new Order();
    order.setDateOfDelivery(DateOfDelivery);
    order.setFirstName("Jane");
    order.setLastName("Doe");
    order.setOrderID("Order ID");
    order.setRetailer("Retailer");
    String actualSaveOrderResult = orderImplementation.saveOrder(new Order[]{order});
    verify(DateOfDelivery, atLeast(1)).getTime();
    assertEquals("Orders saved successfully!", actualSaveOrderResult);
  }

  /**
   * Method under test: {@link OrderImplementation#saveOrder(Order[])}
   */
  @Test
  void testSaveOrder7() {
    java.sql.Date DateOfDelivery = mock(java.sql.Date.class);
    when(DateOfDelivery.getTime()).thenReturn(10L);

    Order order = new Order();
    order.setDateOfDelivery(DateOfDelivery);
    order.setFirstName("Jane");
    order.setLastName("Doe");
    order.setOrderID("Order ID");
    order.setRetailer("Retailer");
    String actualSaveOrderResult = orderImplementation.saveOrder(new Order[]{order});
    verify(DateOfDelivery, atLeast(1)).getTime();
    assertEquals("Orders saved successfully!", actualSaveOrderResult);
  }

  @Test
  void testFindOrderByDate() throws ParseException {
    ArrayList<String> stringList = new ArrayList<>();
    when(orderRepo.findOrdersByDate(Mockito.<Date>any())).thenReturn(stringList);
    List<String> actualFindOrderByDateResult = orderImplementation.findOrderByDate("2020-03-01");
    verify(orderRepo).findOrdersByDate(Mockito.<Date>any());
    assertTrue(actualFindOrderByDateResult.isEmpty());
    assertSame(stringList, actualFindOrderByDateResult);
  }

  /**
   * Method under test: {@link OrderImplementation#findOrderByDate(String)}
   */
  @Test
  void testFindOrderByDate2() throws ParseException {
    assertTrue(orderImplementation.findOrderByDate("2020-03-01").isEmpty());
  }

  /**
   * Method under test: {@link OrderImplementation#findOrderByDate(String)}
   */
  @Test
  void testFindOrderByDate3() throws ParseException {
    assertTrue(orderImplementation.findOrderByDate("2020-03-012020-03-01").isEmpty());
  }

  /**
   * Method under test:  {@link OrderImplementation#loginGuard(String, String)}
   */
  @Test
  void testLoginGuard() {
    when(orderRepo.findPasswordByEmailID(Mockito.<String>any())).thenReturn("jane.doe@example.org");
    when(orderRepo.findByEmailID(Mockito.<String>any())).thenReturn("jane.doe@example.org");
    String actualLoginGuardResult = orderImplementation.loginGuard("jane.doe@example.org", "iloveyou");
    verify(orderRepo).findByEmailID(Mockito.<String>any());
    verify(orderRepo).findPasswordByEmailID(Mockito.<String>any());
    assertEquals("Invalid Login", actualLoginGuardResult);
  }

  /**
   * Method under test:  {@link OrderImplementation#loginGuard(String, String)}
   */
  @Test
  void testLoginGuard2() {
    when(orderRepo.findPasswordByEmailID(Mockito.<String>any())).thenReturn("iloveyou");
    when(orderRepo.findByEmailID(Mockito.<String>any())).thenReturn("jane.doe@example.org");
    String actualLoginGuardResult = orderImplementation.loginGuard("jane.doe@example.org", "iloveyou");
    verify(orderRepo).findByEmailID(Mockito.<String>any());
    verify(orderRepo).findPasswordByEmailID(Mockito.<String>any());
    assertEquals("Valid Login", actualLoginGuardResult);
  }

  /**
   * Method under test:  {@link OrderImplementation#loginGuard(String, String)}
   */
  @Test
  void testLoginGuard3() {
    when(orderRepo.findByEmailID(Mockito.<String>any())).thenReturn(null);
    String actualLoginGuardResult = orderImplementation.loginGuard("jane.doe@example.org", "iloveyou");
    verify(orderRepo).findByEmailID(Mockito.<String>any());
    assertEquals("EmailID does not exist. \n Re-check the emailID or contact the admin.", actualLoginGuardResult);
  }

  /**
   * Method under test: {@link OrderImplementation#loginGuard(String, String)}
   */
  @Test
  void testLoginGuard4() {
    assertEquals("EmailID does not exist. \n Re-check the emailID or contact the admin.",
            orderImplementation.loginGuard("jane.doe@example.org", "iloveyou"));
  }

  /**
   * Method under test: {@link OrderImplementation#loginGuard(String, String)}
   */
  @Test
  void testLoginGuard5() {
    assertEquals("EmailID does not exist. \n" + " Re-check the emailID or contact the admin.",
            orderImplementation.loginGuard("guard1@gmail.com", "iloveyou"));
  }

  /**
   * Method under test: {@link OrderImplementation#loginGuard(String, String)}
   */
  @Test
  void testLoginGuard6() {
    assertEquals("Invalid Login", orderImplementation.loginGuard("guard1@gmail.com", "iloveyou"));
  }

  //    @Test
  //    void testLoginGuard7() {
  //        assertEquals("Valid Login", orderImplementation.loginGuard("guard1@gmail.com", "xyz123"));
  //    }
  @Test
  void testLoginGuard7() {
    when(orderRepo.findPasswordByEmailID(Mockito.<String>any())).thenReturn("xyz123");
    when(orderRepo.findByEmailID(Mockito.<String>any())).thenReturn("guard1@gmail.com");
    String actualLoginGuardResult = orderImplementation.loginGuard("guard1@gmail.com", "xyz123");
    verify(orderRepo).findByEmailID(Mockito.<String>any());
    verify(orderRepo).findPasswordByEmailID(Mockito.<String>any());
    assertEquals("Valid Login", actualLoginGuardResult);
  }

  @Test
  void testLoginGuard8() {
    when(orderRepo.findPasswordByEmailID(Mockito.<String>any())).thenReturn("abc123");
    when(orderRepo.findByEmailID(Mockito.<String>any())).thenReturn("guard2@gmail.com");
    String actualLoginGuardResult = orderImplementation.loginGuard("guard2@gmail.com", "abc123");
    verify(orderRepo).findByEmailID(Mockito.<String>any());
    verify(orderRepo).findPasswordByEmailID(Mockito.<String>any());
    assertEquals("Valid Login", actualLoginGuardResult);
  }

  /**
   * Method under test: {@link OrderImplementation#loginGuard(String, String)}
   */
  @Test
  void testLoginGuard9() {
    assertEquals("Invalid Login", orderImplementation.loginGuard("guard2@gmail.com", "iloveyou"));
  }

  /**
   * Method under test: {@link OrderImplementation#loginGuard(String, String)}
   */
  @Test
  void testLoginGuard10() {
    assertEquals("Valid Login", orderImplementation.loginGuard("guard1@gmail.com", "xyz123"));
  }

  /**
   * Method under test: {@link OrderImplementation#loginGuard(String, String)}
   */

  @Test
  void testDataPopulate() {
    LoginDetails loginDetails = new LoginDetails();
    loginDetails.setEmailID("jane.doe@example.org");
    loginDetails.setPassword("iloveyou");
    when(loginRepo.save(Mockito.<LoginDetails>any())).thenReturn(loginDetails);
    String actualDataPopulateResult = orderImplementation.dataPopulate();
    verify(loginRepo, atLeast(1)).save(Mockito.<LoginDetails>any());
    assertEquals("Guard Details Registered!", actualDataPopulateResult);
  }

  /**
   * Method under test: {@link OrderImplementation#dataPopulate()}
   */
  @Test
  void testDataPopulate2() {
    assertEquals("Guard Details Registered!", orderImplementation.dataPopulate());
  }
}
