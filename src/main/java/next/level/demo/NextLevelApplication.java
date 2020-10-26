package next.level.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"next.level.demo.Controller", "next.level.demo.Repository"})
public class NextLevelApplication {

    public static void main(String[] args) {
        SpringApplication.run(NextLevelApplication.class, args);
    }
}
