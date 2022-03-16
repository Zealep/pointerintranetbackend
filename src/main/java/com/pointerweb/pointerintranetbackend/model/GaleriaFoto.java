package com.pointerweb.pointerintranetbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "rh_in_tz_galeria_foto")
public class GaleriaFoto {

    @Id
    @Column(name = "idGaleriaFoto")
    private String idGaleriaFoto;

    @Column(name = "idEmpresa")
    private String idEmpresa;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado")
    private String estado;


    public String getIdGaleriaFoto() {
        return idGaleriaFoto;
    }

    public void setIdGaleriaFoto(String idGaleriaFoto) {
        this.idGaleriaFoto = idGaleriaFoto;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
