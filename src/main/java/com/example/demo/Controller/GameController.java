package com.example.demo.Controller;

import com.example.demo.Model.Game;
import com.example.demo.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("")
    public ResponseEntity<List<Game>> fetchAll() {
        List<Game> games = gameRepository.findAll();

        if(games.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Game> createGame(@RequestBody Game game){
        try {
//            return new ResponseEntity<>(gameRepository.save(game), HttpStatus.CREATED);

            Game _game = gameRepository.save(new Game(game.getId(), game.getTitle(), game.getDescription(),
                    game.getReleaseDate(), game.getDeveloper(), game.getPublisher(), game.getEngine(),
                    game.getPrice(), game.getReview(), game.getPosterUrl(), game.getCoverUrl(),
                    game.getTrailerUrl(), game.getAdUrl()));

            return new ResponseEntity<>(_game, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable("id") int id, @RequestBody Game game) {
        Optional<Game> gameData = gameRepository.findById(id);

        if (gameData.isPresent()) {
            Game _game = gameData.get();
            _game.setTitle(game.getTitle());
            _game.setDescription(game.getDescription());
            _game.setReleaseDate(game.getReleaseDate());
            _game.setDeveloper(game.getDeveloper());
            _game.setPublisher(game.getPublisher());
            _game.setEngine(game.getEngine());
            _game.setPrice(game.getPrice());
            _game.setReview(game.getReview());
            _game.setPosterUrl(game.getPosterUrl());
            _game.setCoverUrl(game.getCoverUrl());
            _game.setTrailerUrl(game.getTrailerUrl());
            _game.setAdUrl(game.getAdUrl());

            return new ResponseEntity<>(gameRepository.save(_game), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
