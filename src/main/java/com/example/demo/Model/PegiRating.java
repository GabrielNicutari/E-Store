package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "pegi_ratings", schema = "nextlevel", catalog = "")
public class PegiRating {
    private int id;
    private String rating;
    private String ratingUrl;

    public PegiRating() {}

    public PegiRating(int id) {
        this.id = id;
    }

    public PegiRating(int id, String rating, String ratingUrl) {
        this.id = id;
        this.rating = rating;
        this.ratingUrl = ratingUrl;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rating", nullable = false, length = 256)
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "rating_url", nullable = false, length = 256)
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

        if (id != that.id) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (ratingUrl != null ? !ratingUrl.equals(that.ratingUrl) : that.ratingUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (ratingUrl != null ? ratingUrl.hashCode() : 0);
        return result;
    }
}
