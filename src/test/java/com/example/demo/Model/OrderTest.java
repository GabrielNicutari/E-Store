package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    String str = "2020-01-01";
    Date dateTest = Date.valueOf(str);
    private Order order = new Order("commentsTest", dateTest, new Customer(666), new Status(666));

    @Test
    void getId() {
        assertEquals(0, order.getId());
    }

    @Test
    void setId() {
        order.setId(666);
        assertEquals(666, order.getId());
    }

    @Test
    void getComments() {
        assertEquals("commentsTest", order.getComments());
    }

    @Test
    void setComments() {
        order.setComments("newComment");
        assertEquals("newComment", order.getComments());
    }

    @Test
    void getOrderDate() {
        String str = "2020-01-01";
        Date date = Date.valueOf(str);
        assertEquals(date, order.getOrderDate());
    }

    @Test
    void setOrderDate() {
        String str = "2020-06-06";
        Date date = Date.valueOf(str);
        order.setOrderDate(date);
        assertEquals(date, order.getOrderDate());
    }

    @Test
    void testEquals() {
        Order newOrder = new Order("commentsTest", dateTest, new Customer(666), new Status(666));
        assertTrue(newOrder.equals(order));
    }

    @Test
    void testNotEquals() {
        assertFalse(new Order().equals(order));
    }

    @Test
    void testHashCode() {
        int result = order.getId();
        result = result * 31 + order.getComments().hashCode();
        result = result * 31 + order.getOrderDate().hashCode();
        assertEquals(result, order.hashCode());
    }

    @Test
    void getCustomerByCustomerId() {
        assertEquals(new Customer(666), order.getCustomerByCustomerId());
    }

    @Test
    void setCustomerByCustomerId() {
        order.setCustomerByCustomerId(new Customer(999));
        assertEquals(new Customer(999), order.getCustomerByCustomerId());
    }

    @Test
    void getStatusesByStatusId() {
        assertEquals(new Status(666), order.getStatusesByStatusId());
    }

    @Test
    void setStatusesByStatusId() {
        order.setStatusesByStatusId(new Status(999));
        assertEquals(new Status(999), order.getStatusesByStatusId());
    }
}