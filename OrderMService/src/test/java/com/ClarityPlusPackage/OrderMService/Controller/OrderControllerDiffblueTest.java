package com.ClarityPlusPackage.OrderMService.Controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ClarityPlusPackage.OrderMService.Entity.Order;
import com.ClarityPlusPackage.OrderMService.Service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.apache.catalina.users.MemoryUserDatabase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = {OrderController.class, RestTemplate.class})
@ExtendWith(SpringExtension.class)
class OrderControllerDiffblueTest {
    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    /**
     * Method under test: {@link OrderController#getEmailOfInstituteID(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEmailOfInstituteID() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.web.client.HttpServerErrorException$InternalServerError: 500 : "{"timestamp":1701023284581,"status":500,"error":"Internal Server Error","path":"/recipient/getEmailID/42/"}"
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:537)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:631)
        //   org.springframework.web.client.HttpServerErrorException$InternalServerError: 500 : "{"timestamp":1701023284581,"status":500,"error":"Internal Server Error","path":"/recipient/getEmailID/42/"}"
        //       at com.ClarityPlusPackage.OrderMService.Controller.OrderController.getEmailOfInstituteID(OrderController.java:40)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:537)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:631)
        //   See https://diff.blue/R013 to resolve this issue.

        (new OrderController()).getEmailOfInstituteID("Institute ID");
    }

    /**
     * Method under test:  {@link OrderController#loginGuard(String, String)}
     */
    @Test
    void testLoginGuard() throws Exception {
        when(orderService.loginGuard(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Login Guard");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/order/login/guard/{emailID}/{password}/", "jane.doe@example.org", "iloveyou");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Login Guard"));
    }

    /**
     * Method under test:  {@link OrderController#getLogsByDate(String)}
     */
    @Test
    void testGetLogsByDate() throws Exception {
        when(orderService.findOrderByDate(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/order/search/logsbydate/{date}/",
                "2020-03-01");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OrderController#getLogsByInstituteID(String)}
     */
    @Test
    void testGetLogsByInstituteID() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/order/search/logsbyID/{InstituteID}/",
                "Institute ID");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OrderController#getLogsByInstituteID(String)}
     */
    @Test
    void testGetLogsByInstituteID2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/order/search/logsbyID/{InstituteID}/",
                "Institute ID");
        requestBuilder.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:  {@link OrderController#getOrderByInstituteID(String)}
     */
    @Test
    void testGetOrderByInstituteID() throws Exception {
        when(orderService.findOrderByOrderID(Mockito.<List<String>>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/order/ordersOfInstituteID/{InstituteID}/", "Institute ID");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OrderController#saveOrder(Order[])}
     */
    @Test
    void testSaveOrder() throws Exception {
        Order order = new Order();
        order.setDateOfDelivery(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        order.setFirstName("Jane");
        order.setLastName("Doe");
        order.setOrderID("Order ID");
        order.setRetailer("Retailer");
        String content = (new ObjectMapper()).writeValueAsString(new Order[]{order});
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/saveorderdata")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link OrderController#saveOrder(Order[])}
     */
    @Test
    void testSaveOrder2() throws Exception {
        java.sql.Date DateOfDelivery = mock(java.sql.Date.class);
        when(DateOfDelivery.getTime()).thenReturn(10L);

        Order order = new Order();
        order.setDateOfDelivery(DateOfDelivery);
        order.setFirstName("Jane");
        order.setLastName("Doe");
        order.setOrderID("Order ID");
        order.setRetailer("Retailer");
        String content = (new ObjectMapper()).writeValueAsString(new Order[]{order});
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/saveorderdata", "Uri Variables")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link OrderController#saveOrder(Order[])}
     */
    @Test
    void testSaveOrder3() throws Exception {
        java.sql.Date DateOfDelivery = mock(java.sql.Date.class);
        when(DateOfDelivery.getTime()).thenReturn(10L);

        Order order = new Order();
        order.setDateOfDelivery(DateOfDelivery);
        order.setFirstName("Jane");
        order.setLastName("Doe");
        order.setOrderID("Order ID");
        order.setRetailer("Retailer");
        String content = (new ObjectMapper()).writeValueAsString(new Order[]{order});
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/saveorderdata", "Uri Variables")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link OrderController#saveOrder(Order[])}
     */
    @Test
    void testSaveOrder4() throws Exception {
        java.sql.Date DateOfDelivery = mock(java.sql.Date.class);
        when(DateOfDelivery.getTime()).thenReturn(10L);

        Order order = new Order();
        order.setDateOfDelivery(DateOfDelivery);
        order.setFirstName("Jane");
        order.setLastName("Doe");
        order.setOrderID("Order ID");
        order.setRetailer("Retailer");
        String content = (new ObjectMapper()).writeValueAsString(new Order[]{order});
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/saveorderdata", "Uri Variables")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link OrderController#saveOrder(Order[])}
     */
    @Test
    void testSaveOrder5() throws Exception {
        java.sql.Date DateOfDelivery = mock(java.sql.Date.class);
        when(DateOfDelivery.getTime()).thenReturn(10L);

        Order order = new Order();
        order.setDateOfDelivery(DateOfDelivery);
        order.setFirstName("Jane");
        order.setLastName("Doe");
        order.setOrderID("Order ID");
        order.setRetailer("Retailer");
        String content = (new ObjectMapper()).writeValueAsString(new Order[]{order});
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/saveorderdata", "Uri Variables")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link OrderController#saveOrder(Order[])}
     */
    @Test
    void testSaveOrder6() throws Exception {
        java.sql.Date DateOfDelivery = mock(java.sql.Date.class);
        when(DateOfDelivery.getTime()).thenReturn(10L);

        Order order = new Order();
        order.setDateOfDelivery(DateOfDelivery);
        order.setFirstName("Jane");
        order.setLastName("Doe");
        order.setOrderID("Order ID");
        order.setRetailer("Retailer");
        String content = (new ObjectMapper()).writeValueAsString(new Order[]{order});
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/saveorderdata", "Uri Variables")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link OrderController#verifyOtp(String, int)}
     */
    @Test
    void testVerifyOtp() throws Exception {
        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/verifyOtp/{InstituteID}/{otp}",
                "Uri Variables", "Uri Variables", "Uri Variables");
        requestBuilder.principal(new UserDatabaseRealm.UserDatabasePrincipal(user, new MemoryUserDatabase()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}
