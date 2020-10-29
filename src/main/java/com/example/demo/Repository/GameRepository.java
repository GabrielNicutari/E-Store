package com.example.demo.Repository;

import com.example.demo.Model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query(value = "SELECT * FROM games g WHERE g.title LIKE CONCAT('%',:key,'%') OR g.developer LIKE CONCAT('%',:key,'%')" +
            "OR g.publisher LIKE CONCAT('%',:key,'%') OR g.engine LIKE CONCAT('%',:key,'%')", nativeQuery = true)
    Page<Game> findAllByKeyword(@Param("key") String key, Pageable pageable);

}
