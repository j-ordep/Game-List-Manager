package com.jordep.dslist.sevices;

import com.jordep.dslist.dto.GameListDTO;
import com.jordep.dslist.dto.GameMinDTO;
import com.jordep.dslist.entities.GameList;
import com.jordep.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }


}
