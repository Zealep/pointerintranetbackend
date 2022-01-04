package com.pointerweb.pointerintranetbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "opcionesmenu")
public class Menu implements Serializable {

    @Id
    @Column(name = "opmCod")
    private Long opmCod;

    @Column(name = "opmDes")
    private String opmDes;

    @Column(name = "opmEstado")
    private String opmEstado;

    @Column(name = "idModulo")
    private String idModulo;

    @Column(name = "urlOperacion")
    private String urlOperacion;

    public Long getOpmCod() {
        return opmCod;
    }

    public void setOpmCod(Long opmCod) {
        this.opmCod = opmCod;
    }

    public String getOpmDes() {
        return opmDes;
    }

    public void setOpmDes(String opmDes) {
        this.opmDes = opmDes;
    }

    public String getOpmEstado() {
        return opmEstado;
    }

    public void setOpmEstado(String opmEstado) {
        this.opmEstado = opmEstado;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getUrlOperacion() {
        return urlOperacion;
    }

    public void setUrlOperacion(String urlOperacion) {
        this.urlOperacion = urlOperacion;
    }
}
