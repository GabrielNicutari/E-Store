package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderHasGamesTest {

    OrderHasGames orderHasGames = new OrderHasGames(66, 66, 66, new Order(66), new Game(66));

    @Test
    void getOrderId() {
        assertEquals(66, orderHasGames.getOrderId());
    }

    @Test
    void setOrderId() {
        orderHasGames.setOrderId(99);
        assertEquals(99, orderHasGames.getOrderId());
    }

    @Test
    void getProductId() {
        assertEquals(66, orderHasGames.getProductId());
    }

    @Test
    void setProductId() {
        orderHasGames.setProductId(99);
        assertEquals(99, orderHasGames.getProductId());
    }

    @Test
    void getQuantity() {
        assertEquals(66, orderHasGames.getQuantity());
    }

    @Test
    void setQuantity() {
        orderHasGames.setQuantity(99);
        assertEquals(99, orderHasGames.getQuantity());
    }

    @Test
    void testEquals() {
        OrderHasGames newOrderHasGames = new OrderHasGames(66,66,66, new Order(66), new Game(66));
        assertTrue(newOrderHasGames.equals(orderHasGames));
    }

    @Test
    void testNotEquals() {
        assertFalse(new OrderHasGames().equals(orderHasGames));
    }

    @Test
    void testHashCode() {
        int result = orderHasGames.getOrderId() * 31 + orderHasGames.getProductId();
        result = result * 31 + orderHasGames.getQuantity();
        assertEquals(result, orderHasGames.hashCode());
    }

    @Test
    void getOrdersByOrderId() {
        assertEquals(new Order(66), orderHasGames.getOrdersByOrderId());
    }

    @Test
    void setOrdersByOrderId() {
        orderHasGames.setOrdersByOrderId(new Order(99));
        assertEquals(new Order(99), orderHasGames.getOrdersByOrderId());
    }

    @Test
    void getGamesByProductId() {
        assertEquals(new Game(66), orderHasGames.getGamesByProductId());
    }

    @Test
    void setGamesByProductId() {
        orderHasGames.setGamesByProductId(new Game(99));
        assertEquals(new Game(99), orderHasGames.getGamesByProductId());
    }
}