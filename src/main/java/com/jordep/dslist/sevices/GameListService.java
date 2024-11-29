package com.jordep.dslist.sevices;

import com.jordep.dslist.dto.GameListDTO;
import com.jordep.dslist.dto.GameMinDTO;
import com.jordep.dslist.entities.GameList;
import com.jordep.dslist.projections.GameMinProjection;
import com.jordep.dslist.repositories.GameListRepository;
import com.jordep.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

//                     1               3               if             else
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;

        int max = sourceIndex < destinationIndex ?  destinationIndex : sourceIndex;

        // interar sobre a lista (modificada) e atualizar a posição no DB
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}

//         EXEMPLO
// [
//        { id: 1, title: "Game A" }, // Índice 0
//        { id: 2, title: "Game B" }, // Índice 1           sourceIndex
//        { id: 3, title: "Game C" }, // Índice 2
//        { id: 4, title: "Game D" }  // Índice 3           destinationIndex
// ]
//     list.remove(sourceIndex);
// [
//        { id: 1, title: "Game A" }, // Índice 0
//        { id: 3, title: "Game C" }, // Índice 1
//        { id: 4, title: "Game D" }  // Índice 2
// ]
//     list.add(destinationIndex, obj);
// [
//        { id: 1, title: "Game A" }, // Índice 0
//        { id: 3, title: "Game C" }, // Índice 1
//        { id: 4, title: "Game D" }  // Índice 2
//        { id: 2, title: "Game B" }, // Índice 3
// ]