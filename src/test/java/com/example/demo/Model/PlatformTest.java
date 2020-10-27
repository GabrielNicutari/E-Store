package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatformTest {

    Platform platformTest = new Platform(1,"nameTest");
    @Test
    void getId() {
        assertEquals(1, platformTest.getId());
    }

    @Test
    void setId() {
        platformTest.setId(2);
        assertEquals(2, platformTest.getId());
    }

    @Test
    void getName() {
        assert("nameTest").equals(platformTest.getName());
    }

    @Test
    void setName() {
        platformTest.setName("nameTest2");
        assert("nameTest2").equals(platformTest.getName());
    }

    @Test
    void testEquals() {
        Platform platform = new Platform(1, "nameTest");
        assertTrue(platformTest.equals(platform));
    }

    @Test
    void testEquals2() {
        assertNotEquals(new Platform(), platformTest);
    }

    @Test
    void testHashCode() {
        assertEquals(platformTest.getId() * 31 + platformTest.getName().hashCode(), platformTest.hashCode());
    }
}