package com.example.demo.Repository;

import com.example.demo.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
