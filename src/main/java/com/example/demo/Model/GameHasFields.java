package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "game_has_fields", schema = "nextlevel", catalog = "")
public class GameHasFields {
    private int id;
    private Game gameByGameId;
    private Platform platformByPlatformId;
    private SysRequirement sysRequirementsBySysRequirementId;
    private Genre genreByGenreId;
    private Mode modeByModeId;
    private PegiRating pegiRatingsByPegiRatingId;

    public GameHasFields() {}

    public GameHasFields(int id, Game gameByGameId, Platform platformByPlatformId,
                         SysRequirement sysRequirementsBySysRequirementId,
                         Genre genreByGenreId, Mode modeByModeId, PegiRating pegiRatingsByPegiRatingId) {
        this.id = id;
        this.gameByGameId = gameByGameId;
        this.platformByPlatformId = platformByPlatformId;
        this.sysRequirementsBySysRequirementId = sysRequirementsBySysRequirementId;
        this.genreByGenreId = genreByGenreId;
        this.modeByModeId = modeByModeId;
        this.pegiRatingsByPegiRatingId = pegiRatingsByPegiRatingId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameHasFields that = (GameHasFields) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false)
    public Game getGameByGameId() {
        return null;
    }

    public void setGameByGameId(Game gameByGameId) {
        this.gameByGameId = gameByGameId;
    }

    @ManyToOne
    @JoinColumn(name = "platform_id", referencedColumnName = "id", nullable = false)
    public Platform getPlatformByPlatformId() {
        return platformByPlatformId;
    }

    public void setPlatformByPlatformId(Platform platformByPlatformId) {
        this.platformByPlatformId = platformByPlatformId;
    }

    @ManyToOne
    @JoinColumn(name = "sys_requirements_id", referencedColumnName = "id", nullable = false)
    public SysRequirement getSysRequirementsBySysRequirementId() {
        return sysRequirementsBySysRequirementId;
    }

    public void setSysRequirementsBySysRequirementId(SysRequirement sysRequirementsBySysRequirementId) {
        this.sysRequirementsBySysRequirementId = sysRequirementsBySysRequirementId;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    public Genre getGenreByGenreId() {
        return genreByGenreId;
    }

    public void setGenreByGenreId(Genre genreByGenreId) {
        this.genreByGenreId = genreByGenreId;
    }

    @ManyToOne
    @JoinColumn(name = "mode_id", referencedColumnName = "id", nullable = false)
    public Mode getModeByModeId() {
        return modeByModeId;
    }

    public void setModeByModeId(Mode modeByModeId) {
        this.modeByModeId = modeByModeId;
    }

    @ManyToOne
    @JoinColumn(name = "pegi_rating_id", referencedColumnName = "id", nullable = false)
    public PegiRating getPegiRatingsByPegiRatingId() {
        return pegiRatingsByPegiRatingId;
    }

    public void setPegiRatingsByPegiRatingId(PegiRating pegiRatingsByPegiRatingId) {
        this.pegiRatingsByPegiRatingId = pegiRatingsByPegiRatingId;
    }
}
