package com.ClarityPlusPackage.OrderMService.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;

class OrderDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Order#Order()}
     *   <li>{@link Order#setDateOfDelivery(Date)}
     *   <li>{@link Order#setFirstName(String)}
     *   <li>{@link Order#setLastName(String)}
     *   <li>{@link Order#setOrderID(String)}
     *   <li>{@link Order#setRetailer(String)}
     *   <li>{@link Order#getDateOfDelivery()}
     *   <li>{@link Order#getFirstName()}
     *   <li>{@link Order#getLastName()}
     *   <li>{@link Order#getOrderID()}
     *   <li>{@link Order#getRetailer()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Order actualOrder = new Order();
        Date DateOfDelivery = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualOrder.setDateOfDelivery(DateOfDelivery);
        actualOrder.setFirstName("Jane");
        actualOrder.setLastName("Doe");
        actualOrder.setOrderID("Order ID");
        actualOrder.setRetailer("Retailer");
        Date actualDateOfDelivery = actualOrder.getDateOfDelivery();
        String actualFirstName = actualOrder.getFirstName();
        String actualLastName = actualOrder.getLastName();
        String actualOrderID = actualOrder.getOrderID();
        assertEquals("Doe", actualLastName);
        assertEquals("Jane", actualFirstName);
        assertEquals("Order ID", actualOrderID);
        assertEquals("Retailer", actualOrder.getRetailer());
        assertSame(DateOfDelivery, actualDateOfDelivery);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Order#Order(String, String, String, Date, String)}
     *   <li>{@link Order#setDateOfDelivery(Date)}
     *   <li>{@link Order#setFirstName(String)}
     *   <li>{@link Order#setLastName(String)}
     *   <li>{@link Order#setOrderID(String)}
     *   <li>{@link Order#setRetailer(String)}
     *   <li>{@link Order#getDateOfDelivery()}
     *   <li>{@link Order#getFirstName()}
     *   <li>{@link Order#getLastName()}
     *   <li>{@link Order#getOrderID()}
     *   <li>{@link Order#getRetailer()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Order actualOrder = new Order("Order ID", "Jane", "Doe",
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), "Retailer");
        Date DateOfDelivery = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualOrder.setDateOfDelivery(DateOfDelivery);
        actualOrder.setFirstName("Jane");
        actualOrder.setLastName("Doe");
        actualOrder.setOrderID("Order ID");
        actualOrder.setRetailer("Retailer");
        Date actualDateOfDelivery = actualOrder.getDateOfDelivery();
        String actualFirstName = actualOrder.getFirstName();
        String actualLastName = actualOrder.getLastName();
        String actualOrderID = actualOrder.getOrderID();
        assertEquals("Doe", actualLastName);
        assertEquals("Jane", actualFirstName);
        assertEquals("Order ID", actualOrderID);
        assertEquals("Retailer", actualOrder.getRetailer());
        assertSame(DateOfDelivery, actualDateOfDelivery);
    }
}
