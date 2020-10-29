package com.example.demo.Controller;

import com.example.demo.Model.Game;
import com.example.demo.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    //inside fetch
    @GetMapping("/s")
    public ResponseEntity<List<Game>> fetchAll2(@RequestParam(required = false) String key) {
        List<Game> games = new ArrayList<>();

        if(key == null) {
            games.addAll(gameRepository.findAll());
        } else {
            games.addAll(gameRepository.findAllByKeyword(key));
        }

        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") int id) {
        gameRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
