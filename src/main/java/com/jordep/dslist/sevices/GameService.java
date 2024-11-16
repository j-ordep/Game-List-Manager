package com.jordep.dslist.sevices;

import java.util.List;

import com.jordep.dslist.dto.GameDTO;
import com.jordep.dslist.dto.GameMinDTO;
import com.jordep.dslist.entities.Game;
import com.jordep.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository; // Service injeta um Repository || Controller -> Service -> Repository

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get(); // .get() pode gerar erro caso o id não exista, para que isso não ocorra poderia fazer um tratamento de exceção utilizando .orElseThrow()
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
