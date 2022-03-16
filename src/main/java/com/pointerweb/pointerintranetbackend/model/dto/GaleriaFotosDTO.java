package com.pointerweb.pointerintranetbackend.model.dto;

import com.pointerweb.pointerintranetbackend.model.DatoArchivo;

import java.util.List;

public class GaleriaFotosDTO {

    private String year;
    private List<GaleriaPrincipal> principales;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<GaleriaPrincipal> getPrincipales() {
        return principales;
    }

    public void setPrincipales(List<GaleriaPrincipal> principales) {
        this.principales = principales;
    }
}
