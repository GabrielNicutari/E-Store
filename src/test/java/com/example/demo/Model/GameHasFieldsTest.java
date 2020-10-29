package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameHasFieldsTest {

    private GameHasFields gameHasFields = new GameHasFields(20, new Game(10), new Platform(10), new SysRequirement(10),
            new Genre(10), new Mode(10), new PegiRating(10));

    @Test
    void getId() {
        assertEquals(20, gameHasFields.getId());
    }

    @Test
    void setId() {
        gameHasFields.setId(35);
        assertEquals(35, gameHasFields.getId());
    }

    @Test
    void testEquals() {
        assertEquals(new GameHasFields(), new GameHasFields());
        assertNotEquals(new GameHasFields(), gameHasFields);    //this one compares one with values inside
    }

    @Test
    void testHashCode() {
        assertEquals(gameHasFields.getId(), gameHasFields.hashCode());
    }

    @Test
    void getGameByGameId() {
        assertEquals(new Game(10),gameHasFields.getGameByGameId());
    }

    @Test
    void setGameByGameId() {
        gameHasFields.setGameByGameId(new Game(25));
        assertEquals(new Game(25), gameHasFields.getGameByGameId());
    }

    @Test
    void getPlatformByPlatformId() {
        assertEquals(new Platform(10), gameHasFields.getPlatformByPlatformId());
    }

    @Test
    void setPlatformByPlatformId() {
        gameHasFields.setPlatformByPlatformId(new Platform(50));
        assertEquals(new Platform(50), gameHasFields.getPlatformByPlatformId());
    }

    @Test
    void getSysRequirementsBySysRequirementId() {
        assertEquals(new SysRequirement(10), gameHasFields.getSysRequirementsBySysRequirementId());
    }

    @Test
    void setSysRequirementsBySysRequirementId() {
        gameHasFields.setSysRequirementsBySysRequirementId(new SysRequirement(50));
        assertEquals(new SysRequirement(50), gameHasFields.getSysRequirementsBySysRequirementId());
    }

    @Test
    void getGenreByGenreId() {
        assertEquals(new Genre(10), gameHasFields.getGenreByGenreId());
    }

    @Test
    void setGenreByGenreId() {
        gameHasFields.setGenreByGenreId(new Genre(50));
        assertEquals(new Genre(50), gameHasFields.getGenreByGenreId());
    }

    @Test
    void getModeByModeId() {
        assertEquals(new Mode(10), gameHasFields.getModeByModeId());
    }

    @Test
    void setModeByModeId() {
        gameHasFields.setModeByModeId(new Mode(50));
        assertEquals(new Mode(50), gameHasFields.getModeByModeId());
    }

    @Test
    void getPegiRatingsByPegiRatingId() {
        assertEquals(new PegiRating(10), gameHasFields.getPegiRatingsByPegiRatingId());
    }

    @Test
    void setPegiRatingsByPegiRatingId() {
        gameHasFields.setPegiRatingsByPegiRatingId(new PegiRating(50));
        assertEquals(new PegiRating(50), gameHasFields.getPegiRatingsByPegiRatingId());
    }
}