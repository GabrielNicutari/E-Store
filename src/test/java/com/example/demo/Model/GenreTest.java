package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenreTest {

    private Genre genre = new Genre(123, "Horror");

    @Test
    void getId() {
        assertEquals(123,genre.getId());
    }

    @Test
    void setId() {
        genre.setId(500);
        assertEquals(500, genre.getId());
    }

    @Test
    void getName() {
        assertEquals("Horror", genre.getName());
    }

    @Test
    void setName() {
        genre.setName("RPG");
        assertEquals("RPG", genre.getName());
    }

    @Test
    void testEquals() {
        assertNotEquals(new Genre(), genre);    //this one compares one with values inside
        assertEquals(new Genre(), new Genre());
    }

    @Test
    void testHashCode() {
        assertEquals(genre.getId() * 31 + genre.getName().hashCode(), genre.hashCode());
    }
}