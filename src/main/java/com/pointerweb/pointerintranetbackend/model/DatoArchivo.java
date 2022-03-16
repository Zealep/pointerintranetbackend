package com.pointerweb.pointerintranetbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rh_in_tz_datos_archivo")
public class DatoArchivo {

    @Id
    @Column(name = "idDatoArchivo")
    private String idDatoArchivo;

    @Column(name = "idEmpresa")
    private String idEmpresa;

    @Column(name = "idCodigoRelacional")
    private String idCodigoRelacional;

    @Column(name = "idProceso")
    private String idProceso;

    @Column(name = "idDocumento")
    private String idDocumento;

    @Column(name = "nombreArchivo")
    private String nombreArchivo;

    @Column(name = "tipoArchivo")
    private String tipoArchivo;

    @Column(name = "pesoArchivo")
    private String pesoArchivo;

    @Column(name = "pathArchivo")
    private String pathArchivo;

    @Column(name = "inFotoPrincipal")
    private String inFotoPrincipal;

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getInFotoPrincipal() {
        return inFotoPrincipal;
    }

    public void setInFotoPrincipal(String inFotoPrincipal) {
        this.inFotoPrincipal = inFotoPrincipal;
    }

    public String getIdDatoArchivo() {
        return idDatoArchivo;
    }

    public void setIdDatoArchivo(String idDatoArchivo) {
        this.idDatoArchivo = idDatoArchivo;
    }

    public String getIdCodigoRelacional() {
        return idCodigoRelacional;
    }

    public void setIdCodigoRelacional(String idCodigoRelacional) {
        this.idCodigoRelacional = idCodigoRelacional;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getPesoArchivo() {
        return pesoArchivo;
    }

    public void setPesoArchivo(String pesoArchivo) {
        this.pesoArchivo = pesoArchivo;
    }

    public String getPathArchivo() {
        return pathArchivo;
    }

    public void setPathArchivo(String pathArchivo) {
        this.pathArchivo = pathArchivo;
    }
}
