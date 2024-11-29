package com.jordep.dslist.repositories;

import com.jordep.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
// Query nativa SQL, atualiza a tabela beloging, seta a nova posição = newPosition(parametro), onde list_id = :listId(parametro) e game_id = :gameId(parametro)