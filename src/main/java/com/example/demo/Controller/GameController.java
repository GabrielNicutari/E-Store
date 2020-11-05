package com.example.demo.Controller;

import com.example.demo.Model.Game;
import com.example.demo.Model.GameHasFields;
import com.example.demo.Repository.GameHasFieldsRepository;
import com.example.demo.Repository.GameRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GameHasFieldsRepository gameHasFieldsRepository;

    private Sort.Direction getSortDirection(String direction) {
        if(direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if(direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.DESC;
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Map<String,Object>> getPageOfGames(
            @RequestParam(required = false) String key,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort
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
            Game _game = gameRepository.save(game);

            Collection<GameHasFields> gameHasFieldsCollection = _game.getGameHasFieldsById();
            for(GameHasFields gameHasFields : gameHasFieldsCollection) {

                gameHasFields.setGameByGameId(new Game(game.getId()));

                gameHasFieldsRepository.save(gameHasFields);

            }
            return new ResponseEntity<>(_game, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable("id") int id, @RequestBody Game game) {
        Game _game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found game with id" + id));

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

            return new ResponseEntity<>(gameRepository.save(game), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteGame(@PathVariable("id") int id) {
        gameRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
