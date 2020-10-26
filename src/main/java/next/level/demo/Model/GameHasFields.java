package next.level.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "game_has_fields", schema = "nextlevel", catalog = "")
public class GameHasFields {
    private int id;
    private Games gamesByGameId;
    private Platforms platformsByPlatformId;
    private SysRequirements sysRequirementsBySysRequirementsId;
    private Genres genresByGenreId;
    private Modes modesByModeId;
    private PegiRatings pegiRatingsByPegiRatingId;

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
        int result = id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false)
    public Games getGamesByGameId() {
        return gamesByGameId;
    }

    public void setGamesByGameId(Games gamesByGameId) {
        this.gamesByGameId = gamesByGameId;
    }

    @ManyToOne
    @JoinColumn(name = "platform_id", referencedColumnName = "id", nullable = false)
    public Platforms getPlatformsByPlatformId() {
        return platformsByPlatformId;
    }

    public void setPlatformsByPlatformId(Platforms platformsByPlatformId) {
        this.platformsByPlatformId = platformsByPlatformId;
    }

    @ManyToOne
    @JoinColumn(name = "sys_requirements_id", referencedColumnName = "id", nullable = false)
    public SysRequirements getSysRequirementsBySysRequirementsId() {
        return sysRequirementsBySysRequirementsId;
    }

    public void setSysRequirementsBySysRequirementsId(SysRequirements sysRequirementsBySysRequirementsId) {
        this.sysRequirementsBySysRequirementsId = sysRequirementsBySysRequirementsId;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    public Genres getGenresByGenreId() {
        return genresByGenreId;
    }

    public void setGenresByGenreId(Genres genresByGenreId) {
        this.genresByGenreId = genresByGenreId;
    }

    @ManyToOne
    @JoinColumn(name = "mode_id", referencedColumnName = "id", nullable = false)
    public Modes getModesByModeId() {
        return modesByModeId;
    }

    public void setModesByModeId(Modes modesByModeId) {
        this.modesByModeId = modesByModeId;
    }

    @ManyToOne
    @JoinColumn(name = "pegi_rating_id", referencedColumnName = "id", nullable = false)
    public PegiRatings getPegiRatingsByPegiRatingId() {
        return pegiRatingsByPegiRatingId;
    }

    public void setPegiRatingsByPegiRatingId(PegiRatings pegiRatingsByPegiRatingId) {
        this.pegiRatingsByPegiRatingId = pegiRatingsByPegiRatingId;
    }
}
