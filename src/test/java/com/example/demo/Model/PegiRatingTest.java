package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PegiRatingTest {

    //Inserting test data.
    private PegiRating pegiRating = new PegiRating(1, "ratingTest", "urlTest");

    @Test
    void getId() {
        int id = 1;
        assertEquals(id, pegiRating.getId());
    }

    @Test
    void setId() {
        int id = 1;
        pegiRating.setId(id);
        assertEquals(id, pegiRating.getId());
    }

    @Test
    void getRating() {
        String rating = "ratingTest";
        assertTrue(rating.equals(pegiRating.getRating()));
    }

    @Test
    void setRating() {
        String rating = "ratingTest";
        pegiRating.setRating(rating);
        assertTrue(rating.equals(pegiRating.getRating()));
    }

    @Test
    void getRatingUrl() {
        String ratingUrl = "urlTest";
        assertTrue(ratingUrl.equals(pegiRating.getRatingUrl()));
    }

    @Test
    void setRatingUrl() {
        String ratingUrl = "urlTest";
        pegiRating.setRatingUrl(ratingUrl);
        assertTrue(ratingUrl.equals(pegiRating.getRatingUrl()));
    }

    @Test
    void testEquals() {
        assertEquals(new PegiRating(), new PegiRating());
        assertNotEquals(new PegiRating(), pegiRating);
    }

    @Test
    void testHashCode() {
        int result = pegiRating.getId() * 31 + pegiRating.getRating().hashCode();
        result = 31 * result + pegiRating.getRatingUrl().hashCode();
        assertEquals(result, pegiRating.hashCode());
    }
}