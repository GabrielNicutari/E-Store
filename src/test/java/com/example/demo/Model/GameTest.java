package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    //Inserting test data.
    String str = "2015-03-31";
    Date date = Date.valueOf(str);
    private Game game = new Game ("TitleTest","DescriptionTest", date
            ,"DeveloperTest","PublisherTest","EngineTest"
            ,"PriceTest",20.0,"PosterTest"
            ,"CoverTest","TrailerTest","AdTest");

    @Test
    void getId() {
        assertEquals(0, game.getId());
    }

    @Test
    void setId() {
        game.setId(1);
        assertEquals(1, game.getId());
    }

    @Test
    void getTitle() {
        assertEquals("TitleTest", game.getTitle());
    }

    @Test
    void setTitle() {
        game.setTitle("TitleTest");
        assertEquals("TitleTest", game.getTitle());
    }

    @Test
    void getDescription() {
        assertEquals("DescriptionTest", game.getDescription());
    }

    @Test
    void setDescription() {
        game.setDescription("DescriptionTest");
        assertEquals("DescriptionTest", game.getDescription());
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
        assertEquals("DeveloperTest", game.getDeveloper());
    }

    @Test
    void setDeveloper() {
        game.setDeveloper("DeveloperTest");
        assertEquals("DeveloperTest", game.getDeveloper());
    }

    @Test
    void getPublisher() {
        assertEquals("PublisherTest", game.getPublisher());
    }

    @Test
    void setPublisher() {
        game.setPublisher("PublisherTest");
        assertEquals("PublisherTest", game.getPublisher());
    }

    @Test
    void getEngine() {
        assertEquals("EngineTest", game.getEngine());
    }

    @Test
    void setEngine() {
        game.setEngine("EngineTest");
        assertEquals("EngineTest", game.getEngine());
    }

    @Test
    void getPrice() {
        assertEquals("PriceTest", game.getPrice());
    }

    @Test
    void setPrice() {
        game.setPrice("PriceTest");
        assertEquals("PriceTest", game.getPrice());
    }

    @Test
    void getReview() {
        assertEquals(20.0, game.getReview());
    }

    @Test
    void setReview() {
        game.setReview(20.0);
        assertEquals(20.0, game.getReview());
    }

    @Test
    void getPosterUrl() {
        assertEquals("PosterTest", game.getPosterUrl());
    }

    @Test
    void setPosterUrl() {
        game.setPosterUrl("PosterTest");
        assertEquals("PosterTest", game.getPosterUrl());
    }

    @Test
    void getCoverUrl() {
        assertEquals("CoverTest", game.getCoverUrl());
    }

    @Test
    void setCoverUrl() {
        game.setCoverUrl("CoverTest");
        assertEquals("CoverTest", game.getCoverUrl());
    }

    @Test
    void getTrailerUrl() {
        assertEquals("TrailerTest", game.getTrailerUrl());
    }

    @Test
    void setTrailerUrl() {
        game.setTrailerUrl("TrailerTest");
        assertEquals("TrailerTest", game.getTrailerUrl());
    }

    @Test
    void getAdUrl() {
        assertEquals("AdTest", game.getAdUrl());
    }

    @Test
    void setAdUrl() {
        game.setAdUrl("AdTest");
        assertEquals("AdTest", game.getAdUrl());
    }


    @Test
    void testEquals() {
        String str = "2015-03-31";
        Date date = Date.valueOf(str);
        Game newGame = new Game ("TitleTest","DescriptionTest", date
                ,"DeveloperTest","PublisherTest","EngineTest"
                ,"PriceTest",20.0,"PosterTest"
                ,"CoverTest","TrailerTest","AdTest");
        assertTrue(newGame.equals(game));    //this one compares one with values inside
    }

    @Test
    void testNotEquals() {
        assertFalse(new Game().equals(game));
    }

    @Test
    void testHashCode() {
        int result;
        result = game.getId();
        result = 31 * result + game.getTitle().hashCode();
        result = 31 * result + game.getDescription().hashCode();
        result = 31 * result + game.getReleaseDate().hashCode();
        result = 31 * result + game.getDeveloper().hashCode();
        result = 31 * result + game.getPublisher().hashCode();
        result = 31 * result + game.getEngine().hashCode();
        result = 31 * result + game.getPrice().hashCode();
        long temp = Double.doubleToLongBits(game.getReview());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + game.getPosterUrl().hashCode();
        result = 31 * result + game.getCoverUrl().hashCode();
        result = 31 * result + game.getTrailerUrl().hashCode();
        result = 31 * result + game.getAdUrl().hashCode();

        assertEquals(result, game.hashCode());

    }
}