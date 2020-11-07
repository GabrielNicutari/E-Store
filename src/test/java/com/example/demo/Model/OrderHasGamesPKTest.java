package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderHasGamesPKTest {

    OrderHasGamesPK orderHasGamesPK = new OrderHasGamesPK(666,666);

    @Test
    void getOrderId() {
        assertEquals(666, orderHasGamesPK.getOrderId());
    }

    @Test
    void setOrderId() {
        orderHasGamesPK.setOrderId(999);
        assertEquals(999, orderHasGamesPK.getOrderId());
    }

    @Test
    void getProductId() {
        assertEquals(666, orderHasGamesPK.getProductId());
    }

    @Test
    void setProductId() {
        orderHasGamesPK.setProductId(999);
        assertEquals(999, orderHasGamesPK.getProductId());
    }

    @Test
    void testEquals() {
        OrderHasGamesPK newOrderHasGamesPK = new OrderHasGamesPK(666,666);
        assertTrue(newOrderHasGamesPK.equals(orderHasGamesPK));
    }

    @Test
    void testHashCode() {
        int result = orderHasGamesPK.getOrderId();
        result = result * 31 + orderHasGamesPK.getProductId();
        assertEquals(result, orderHasGamesPK.hashCode());
    }
}