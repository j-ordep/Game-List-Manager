package com.jordep.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jordep.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
