package com.example.demo.Controller;

import com.example.demo.Model.Game;
import com.example.demo.Repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GameIntegrationTest {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    public void init(){
        gameRepository.deleteAll();
    }

    @Test
    public void should_find_no_game_if_repository_is_empty(){
        Iterable<Game> games = gameRepository.findAll();
        assertThat(games).isEmpty();
    }

    @Test
    public void should_store_game(){
        String str = "2015-03-31";
        Date date = Date.valueOf(str);
        Game game = gameRepository.save(new Game("t1", "d1", date, "dev1", "publ1", "eng1", "234.99", 5.0, "posterurl1", "coverurl1", "trailerurl1", "adurl1"));
        assertThat(game).hasFieldOrPropertyWithValue("title", "t1");
        assertThat(game).hasFieldOrPropertyWithValue("description", "d1");
        assertThat(game).hasFieldOrPropertyWithValue("releaseDate", date);
        assertThat(game).hasFieldOrPropertyWithValue("developer", "dev1");
        assertThat(game).hasFieldOrPropertyWithValue("publisher", "publ1");
        assertThat(game).hasFieldOrPropertyWithValue("engine", "eng1");
        assertThat(game).hasFieldOrPropertyWithValue("price", "234.99");
        assertThat(game).hasFieldOrPropertyWithValue("review", 5.0);
        assertThat(game).hasFieldOrPropertyWithValue("posterUrl", "posterurl1");
        assertThat(game).hasFieldOrPropertyWithValue("coverUrl", "coverurl1");
        assertThat(game).hasFieldOrPropertyWithValue("trailerUrl", "trailerurl1");
        assertThat(game).hasFieldOrPropertyWithValue("adUrl", "adurl1");
    }

    @Test
    public void should_find_all_games(){
        String str1 = "2015-03-31";
        Date date1 = Date.valueOf(str1);
        gameRepository.save(new Game("t1", "d1", date1, "dev1",
                "publ1", "eng1", "234.99", 5.0,
                "posterurl1", "coverurl1", "trailerurl1", "adurl1"));

        String str2 = "2015-06-01";
        Date date2 = Date.valueOf(str2);
        gameRepository.save(new Game("t2", "d2", date2, "dev2",
                "publ2", "eng2", "250.99", 8.0, "posterurl2",
                "coverurl2", "trailerurl2", "adurl2"));

        String str3 = "2015-05-02";
        Date date3 = Date.valueOf(str3);
        gameRepository.save(new Game("t3", "d3", date3, "dev3",
                "publ3", "eng3", "234.99", 5.0,
                "posterurl3", "coverurl3", "trailerurl3", "adurl3"));

        Iterable<Game> games = gameRepository.findAll();
        assertThat(games).hasSize(3);
    }

    @Test
    public void should_find_game_by_id() {
        String str1 = "2015-03-31";
        Date date1 = Date.valueOf(str1);
        Game g1 = new Game("t1", "d1", date1, "dev1",
                "publ1", "eng1", "234.99", 5.0,
                "posterurl1", "coverurl1", "trailerurl1", "adurl1");
        entityManager.persist(g1);

        String str2 = "2015-06-01";
        Date date2 = Date.valueOf(str2);
        Game g2 = new Game("t2", "d2", date2, "dev2",
                "publ2", "eng2", "250.99", 8.0, "posterurl2",
                "coverurl2", "trailerurl2", "adurl2");
        entityManager.persist(g2);

        Game foundGame = gameRepository.findById(g2.getId()).get();

        assertThat(foundGame).isEqualTo(g2);
    }

    @Test
    public void should_delete_game_by_id() {
        String str1 = "2015-03-31";
        Date date1 = Date.valueOf(str1);
        Game g1 = new Game("t1", "d1", date1, "dev1",
                "publ1", "eng1", "234.99", 5.0,
                "posterurl1", "coverurl1", "trailerurl1", "adurl1");
        entityManager.persist(g1);

        String str2 = "2015-06-01";
        Date date2 = Date.valueOf(str2);
        Game g2 = new Game("t2", "d2", date2, "dev2",
                "publ2", "eng2", "250.99", 8.0, "posterurl2",
                "coverurl2", "trailerurl2", "adurl2");
        entityManager.persist(g2);

        String str3 = "2015-05-02";
        Date date3 = Date.valueOf(str3);
        Game g3 = new Game("t3", "d3", date3, "dev3",
                "publ3", "eng3", "234.99", 5.0,
                "posterurl3", "coverurl3", "trailerurl3", "adurl3");
        entityManager.persist(g3);

        gameRepository.deleteById(g2.getId());

        Iterable<Game> games = gameRepository.findAll();

        assertThat(games).hasSize(2).contains(g1, g3);
    }

    @Test
    public void should_find_game_by_keyword(){
        String str1 = "2015-03-31";
        Date date1 = Date.valueOf(str1);
        Game g1 = new Game("t11", "d1", date1, "dev11",
                "publ1", "eng11", "234.99", 5.0,
                "posterurl1", "coverurl1", "trailerurl1", "adurl1");
        entityManager.persist(g1);

        String str2 = "2015-06-01";
        Date date2 = Date.valueOf(str2);
        Game g2 = new Game("t12", "d2", date2, "dev2",
                "publ22", "eng2", "250.99", 8.0, "posterurl2",
                "coverurl2", "trailerurl2", "adurl2");
        entityManager.persist(g2);

        String str3 = "2015-05-02";
        Date date3 = Date.valueOf(str3);
        Game g3 = new Game("t3", "d3", date3, "dev13",
                "publ23", "eng3", "234.99", 5.0,
                "posterurl3", "coverurl3", "trailerurl3", "adurl3");
        entityManager.persist(g3);

        Iterable<Game> games1 = gameRepository.findAllByKeyword("t1", PageRequest.of(0, 2));
        Iterable<Game> games2 = gameRepository.findAllByKeyword("dev1", PageRequest.of(0, 2));
        Iterable<Game> games3 = gameRepository.findAllByKeyword("publ2", PageRequest.of(0, 2));
        Iterable<Game> games4 = gameRepository.findAllByKeyword("eng1", PageRequest.of(0, 2));


        assertThat(games1).hasSize(2).contains(g1, g2);
        assertThat(games2).hasSize(2).contains(g1, g3);
        assertThat(games3).hasSize(2).contains(g2, g3);
        assertThat(games4).hasSize(1).contains(g1);
    }
}
