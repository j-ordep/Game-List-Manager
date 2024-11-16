package com.jordep.dslist.dto;

import com.jordep.dslist.entities.Game;

// DTO tem como característica somente dados necessários, imutaveis, geralmente sem lógica de negócios.
// DTO para mostrar somente as informações necessárias.

// GameMinDTO é um DTO para resumir o Game, como se fosse uma capa.

public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

}
