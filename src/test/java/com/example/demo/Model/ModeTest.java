package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ModeTest {

    //Inserting test data.
    private Mode mode= new Mode(1, "ModeNameTest" );

    @Test
    void getId() {
        int id = 1;
        assertEquals(id, mode.getId());
    }

    @Test
    void getName() {
        String name = "ModeNameTest";
        assertEquals(name, mode.getName());
    }

   @Test
    void setId() {
        int id = 1;
        mode.setId(id);
        assertEquals(id, mode.getId());
    }

    @Test
    void setName() {
        String name = "ModeTestName";
        mode.setName(name);
        assertEquals(name, mode.getName());
    }

    @Test
    void testEquals() {
        assertEquals(new Mode(), new Mode());
        assertNotEquals(new Mode(), mode);
    }

    @Test
    void testHashCode() {
        assertEquals(mode.getId() * 31 + mode.getName().hashCode(), mode.hashCode());
    }
}