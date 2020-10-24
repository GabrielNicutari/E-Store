package next.level.demo.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "games", schema = "nextlevel", catalog = "")
public class Games {
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
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "developer")
    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Basic
    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "engine")
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "review")
    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        this.review = review;
    }

    @Basic
    @Column(name = "poster_url")
    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @Basic
    @Column(name = "cover_url")
    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Basic
    @Column(name = "trailer_url")
    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    @Basic
    @Column(name = "ad_url")
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
        Games that = (Games) o;
        return id == that.id &&
                Double.compare(that.review, review) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(releaseDate, that.releaseDate) &&
                Objects.equals(developer, that.developer) &&
                Objects.equals(publisher, that.publisher) &&
                Objects.equals(engine, that.engine) &&
                Objects.equals(price, that.price) &&
                Objects.equals(posterUrl, that.posterUrl) &&
                Objects.equals(coverUrl, that.coverUrl) &&
                Objects.equals(trailerUrl, that.trailerUrl) &&
                Objects.equals(adUrl, that.adUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, releaseDate, developer, publisher, engine, price, review, posterUrl, coverUrl, trailerUrl, adUrl);
    }
}
