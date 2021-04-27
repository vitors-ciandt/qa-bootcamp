package com.ciandt.games;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findAll();

    Game findOneById(Long id);
}
