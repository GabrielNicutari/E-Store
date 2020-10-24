package next.level.demo.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pegi_ratings", schema = "nextlevel", catalog = "")
public class PegiRating {
    private int id;
    private String rating;
    private String ratingUrl;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rating")
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "rating_url")
    public String getRatingUrl() {
        return ratingUrl;
    }

    public void setRatingUrl(String ratingUrl) {
        this.ratingUrl = ratingUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PegiRating that = (PegiRating) o;
        return id == that.id &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(ratingUrl, that.ratingUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, ratingUrl);
    }
}
