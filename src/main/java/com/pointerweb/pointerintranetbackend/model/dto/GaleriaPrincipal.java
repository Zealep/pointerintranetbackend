package com.pointerweb.pointerintranetbackend.model.dto;

import javax.persistence.Column;
import java.util.Date;

public class GaleriaPrincipal {
    private String idGaleriaFoto;
    private String titulo;
    private Date fecha;
    private String year;
    private String imagenPrincipal;
    private String img;

    public GaleriaPrincipal(String idGaleriaFoto, String titulo, Date fecha, String year, String imagenPrincipal, String img) {
        this.idGaleriaFoto = idGaleriaFoto;
        this.titulo = titulo;
        this.fecha = fecha;
        this.year = year;
        this.imagenPrincipal = imagenPrincipal;
        this.img = img;
    }

    public GaleriaPrincipal(){

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIdGaleriaFoto() {
        return idGaleriaFoto;
    }

    public void setIdGaleriaFoto(String idGaleriaFoto) {
        this.idGaleriaFoto = idGaleriaFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImagenPrincipal() {
        return imagenPrincipal;
    }

    public void setImagenPrincipal(String imagenPrincipal) {
        this.imagenPrincipal = imagenPrincipal;
    }
}
