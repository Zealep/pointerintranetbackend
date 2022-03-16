package com.pointerweb.pointerintranetbackend.model.dto;

import java.util.List;

public class NoticiaDTO {

    private String year;
    private List<NoticiasMesDTO> meses;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<NoticiasMesDTO> getMeses() {
        return meses;
    }

    public void setMeses(List<NoticiasMesDTO> meses) {
        this.meses = meses;
    }
}
