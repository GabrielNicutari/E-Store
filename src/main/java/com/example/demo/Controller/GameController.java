package com.example.demo.Controller;

import com.example.demo.Model.Game;
import com.example.demo.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    private Sort.Direction getSortDirection(String direction) {
        if(direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if(direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.DESC;
    }

    @GetMapping("/")
    public ResponseEntity<Map<String,Object>> getPageOfGames(
            @RequestParam(required = false) String key,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort
    ) {

        List<Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            //sort=[field,direction]
            orders.add(new Order(getSortDirection(sort[1]), sort[0]));
        }

        Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

        Page<Game> pageTuts;

        if(key == null) {
            pageTuts = gameRepository.findAll(pagingSort);
        } else {
            pageTuts = gameRepository.findAllByKeyword(key, pagingSort);
        }

        List<Game> games = pageTuts.getContent();

        if (games.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Map<String, Object> response = new HashMap<>();
        response.put("games", games);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteGame(@PathVariable("id") int id) {
        gameRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
