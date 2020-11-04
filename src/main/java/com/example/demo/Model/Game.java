package com.example.demo.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "games", schema = "nextlevel", catalog = "")
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
    private Collection<GameHasFields> gameHasFieldsById;
    private Collection<OrderHasGames> orderHasGamesById;

    public Game() {}

    //In order to test GameHasFields fully
    public Game(int id) {
        this.id = id;
    }

    public Game(String title, String description, Date releaseDate, String developer, String publisher, String engine, String price,
                double review, String posterUrl, String coverUrl, String trailerUrl, String adUrl) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.developer = developer;
        this.publisher = publisher;
        this.engine = engine;
        this.price = price;
        this.review = review;
        this.posterUrl = posterUrl;
        this.coverUrl = coverUrl;
        this.trailerUrl = trailerUrl;
        this.adUrl = adUrl;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
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

        if (id != game.id) return false;
        if (Double.compare(game.review, review) != 0) return false;
        if (title != null ? !title.equals(game.title) : game.title != null) return false;
        if (description != null ? !description.equals(game.description) : game.description != null) return false;
        if (releaseDate != null ? !releaseDate.equals(game.releaseDate) : game.releaseDate != null) return false;
        if (developer != null ? !developer.equals(game.developer) : game.developer != null) return false;
        if (publisher != null ? !publisher.equals(game.publisher) : game.publisher != null) return false;
        if (engine != null ? !engine.equals(game.engine) : game.engine != null) return false;
        if (price != null ? !price.equals(game.price) : game.price != null) return false;
        if (posterUrl != null ? !posterUrl.equals(game.posterUrl) : game.posterUrl != null) return false;
        if (coverUrl != null ? !coverUrl.equals(game.coverUrl) : game.coverUrl != null) return false;
        if (trailerUrl != null ? !trailerUrl.equals(game.trailerUrl) : game.trailerUrl != null) return false;
        if (adUrl != null ? !adUrl.equals(game.adUrl) : game.adUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (developer != null ? developer.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        temp = Double.doubleToLongBits(review);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (posterUrl != null ? posterUrl.hashCode() : 0);
        result = 31 * result + (coverUrl != null ? coverUrl.hashCode() : 0);
        result = 31 * result + (trailerUrl != null ? trailerUrl.hashCode() : 0);
        result = 31 * result + (adUrl != null ? adUrl.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "gameByGameId")
    public Collection<GameHasFields> getGameHasFieldsById() {
        return gameHasFieldsById;
    }

    public void setGameHasFieldsById(Collection<GameHasFields> gameHasFieldsById) {
        this.gameHasFieldsById = gameHasFieldsById;
    }

    @OneToMany(mappedBy = "gamesByProductId")
    public Collection<OrderHasGames> getOrderHasGamesById() {
        return orderHasGamesById;
    }

    public void setOrderHasGamesById(Collection<OrderHasGames> orderHasGamesById) {
        this.orderHasGamesById = orderHasGamesById;
    }
}
