package com.jordep.dslist.controllers;

import java.util.List;

import com.jordep.dslist.dto.GameMinDTO;
import com.jordep.dslist.entities.Game;
import com.jordep.dslist.sevices.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService; // Controller injeta um Service || Controller -> Service -> Repository

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
