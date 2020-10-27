package com.example.demo.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "games")
public class Game {
    private int id;
    private String title;
    private String description;
    private Date releaseDate;
    private String developer;
    private String publisher;
    private String engine;
    private String price;
    private double review;
    private String posterUrl;
    private String coverUrl;
    private String trailerUrl;
    private String adUrl;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 256)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "release_date", nullable = false)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "developer", nullable = false, length = 45)
    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Basic
    @Column(name = "publisher", nullable = false, length = 45)
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "engine", nullable = false, length = 45)
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Basic
    @Column(name = "price", nullable = false, length = 45)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "review", nullable = false, precision = 0)
    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        this.review = review;
    }

    @Basic
    @Column(name = "poster_url", nullable = false, length = 45)
    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @Basic
    @Column(name = "cover_url", nullable = false, length = 256)
    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Basic
    @Column(name = "trailer_url", nullable = false, length = 256)
    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    @Basic
    @Column(name = "ad_url", nullable = true, length = 256)
    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id &&
                Double.compare(game.review, review) == 0 &&
                Objects.equals(title, game.title) &&
                Objects.equals(description, game.description) &&
                Objects.equals(releaseDate, game.releaseDate) &&
                Objects.equals(developer, game.developer) &&
                Objects.equals(publisher, game.publisher) &&
                Objects.equals(engine, game.engine) &&
                Objects.equals(price, game.price) &&
                Objects.equals(posterUrl, game.posterUrl) &&
                Objects.equals(coverUrl, game.coverUrl) &&
                Objects.equals(trailerUrl, game.trailerUrl) &&
                Objects.equals(adUrl, game.adUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, releaseDate, developer, publisher, engine, price, review, posterUrl, coverUrl, trailerUrl, adUrl);
    }
}
