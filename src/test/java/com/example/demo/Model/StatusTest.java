package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    Status status = new Status("nameTest");

    @Test
    void getId() {
        assertEquals(0, status.getId());
    }

    @Test
    void setId() {
        status.setId(666);
        assertEquals(666, status.getId());
    }

    @Test
    void getName() {
        assertEquals("nameTest", status.getName());
    }

    @Test
    void setName() {
        status.setName("newName");
        assertEquals("newName", status.getName());
    }

    @Test
    void testEquals() {
        Status newStatus = new Status("nameTest");
        assertTrue(newStatus.equals(status));
    }

    @Test
    void testNotEquals() {
        assertFalse(new Status().equals(status));
    }

    @Test
    void testHashCode() {
        int result = status.getId() * 31 + status.getName().hashCode();
        assertEquals(result, status.hashCode());
    }
}