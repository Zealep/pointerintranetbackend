package com.pointerweb.pointerintranetbackend.model.dto;

import java.util.List;

public class NoticiasMesDTO {

    private String month;
    private List<NoticiaPrincipal> principales;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<NoticiaPrincipal> getPrincipales() {
        return principales;
    }

    public void setPrincipales(List<NoticiaPrincipal> principales) {
        this.principales = principales;
    }
}
