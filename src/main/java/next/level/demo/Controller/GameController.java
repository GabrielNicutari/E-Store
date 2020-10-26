package next.level.demo.Controller;

import next.level.demo.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    public void fetchAll() {
        System.out.println(gameRepository.findAll().toString());
    }
}
