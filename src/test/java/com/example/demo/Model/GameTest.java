package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    //Inserting test data.
    String str = "2015-03-31";
    Date date = Date.valueOf(str);
    private Game game = new Game (1, "TitleTest","DescriptionTest", date
            ,"DeveloperTest","PublisherTest","EngineTest"
            ,"Pricetest",20.0,"PosterTest"
            ,"CoverTest","TrailerTest","AdTest");

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void setDescription() {
    }

    @Test
    void getReleaseDate() {
        String str = "2015-03-31";
        Date date = Date.valueOf(str);
        assertTrue(date.equals(game.getReleaseDate()));
    }

    @Test
    void setReleaseDate() {
        String str = "2015-03-31";
        Date date = Date.valueOf(str);
        game.setReleaseDate(date);
        assertTrue(date.equals(game.getReleaseDate()));
    }

    @Test
    void getDeveloper() {
    }

    @Test
    void setDeveloper() {
    }

    @Test
    void getPublisher() {
    }

    @Test
    void setPublisher() {
    }

    @Test
    void getEngine() {
    }

    @Test
    void setEngine() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void setPrice() {
    }

    @Test
    void getReview() {
    }

    @Test
    void setReview() {
    }

    @Test
    void getPosterUrl() {
    }

    @Test
    void setPosterUrl() {
    }

    @Test
    void getCoverUrl() {
    }

    @Test
    void setCoverUrl() {
    }

    @Test
    void getTrailerUrl() {
    }

    @Test
    void setTrailerUrl() {
    }

    @Test
    void getAdUrl() {
    }

    @Test
    void setAdUrl() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void getGameHasFieldsById() {
    }

    @Test
    void setGameHasFieldsById() {
    }
}