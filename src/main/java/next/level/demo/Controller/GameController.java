package next.level.demo.Controller;

import next.level.demo.Model.GameHasFields;
import next.level.demo.Repository.GameHasFieldsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameHasFieldsRepository gameHasFieldsRepository;

    @GetMapping("")
    public ResponseEntity<List<GameHasFields>> fetchAll() {
        List<GameHasFields> games = gameHasFieldsRepository.findAll();

        if(games.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(games, HttpStatus.OK);
    }
}
