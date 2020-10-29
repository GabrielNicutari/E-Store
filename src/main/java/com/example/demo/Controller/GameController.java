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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> pagination(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "2") int size,
                                                        @RequestParam(defaultValue = "id,desc") String[] sort) {

        //Pagination
        Pageable paging = PageRequest.of(page, size);
        Page<Game> pageTuts = gameRepository.findAll(paging);

        try {
            List<Game> games = pageTuts.getContent();

            if(games.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            Map<String, Object> response = new HashMap<>();
            response.put("tutorials", games);
            response.put("currPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sorting")
    public ResponseEntity<List<Game>> sorting(@RequestParam(defaultValue = "id,desc") String[] sort) {

        List<Order> orders = new ArrayList<>();

        if(sort[0].contains(",")) {
            for (String sortOrder: sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Order(getSortDirection(_sort[1]),_sort[0]));
            }
        } else {
            orders.add(new Order(getSortDirection(sort[1]),sort[0]));
        }

        List<Game> tutorials = gameRepository.findAll(Sort.by(orders));
        try {
            if(tutorials.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(tutorials, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    public ResponseEntity<HttpStatus> deleteGame(@PathVariable("id") int id) {
        gameRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
