package com.jordep.dslist.sevices;

import java.util.List;

import com.jordep.dslist.dto.GameMinDTO;
import com.jordep.dslist.entities.Game;
import com.jordep.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository; // Service injeta um Repository || Controller -> Service -> Repository

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
