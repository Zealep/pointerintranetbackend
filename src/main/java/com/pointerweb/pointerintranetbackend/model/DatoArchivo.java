package com.pointerweb.pointerintranetbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mg_tz_dato_archivo_persona")
public class DatoArchivo {

    @Id
    @Column(name = "idDatoArchivoPersona")
    private String idDatoArchivoPersona;

    @Column(name = "idEmpresa")
    private String idEmpresa;

    @Column(name = "idTipoDocumentoIdentidad")
    private String idTipoDocumentoIdentidad;

    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @Column(name = "idCodigoRelacional")
    private String idCodigoRelacional;

    @Column(name = "idDocumento")
    private String idDocumento;

    @Column(name = "idProceso")
    private String idProceso;

    @Column(name = "nombreArchivo")
    private String nombreArchivo;

    @Column(name = "tipoArchivo")
    private String tipoArchivo;

    @Column(name = "pesoArchivo")
    private String pesoArchivo;

    @Column(name = "pathArchivo")
    private String pathArchivo;


    public String getIdDatoArchivoPersona() {
        return idDatoArchivoPersona;
    }

    public void setIdDatoArchivoPersona(String idDatoArchivoPersona) {
        this.idDatoArchivoPersona = idDatoArchivoPersona;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdTipoDocumentoIdentidad() {
        return idTipoDocumentoIdentidad;
    }

    public void setIdTipoDocumentoIdentidad(String idTipoDocumentoIdentidad) {
        this.idTipoDocumentoIdentidad = idTipoDocumentoIdentidad;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getIdCodigoRelacional() {
        return idCodigoRelacional;
    }

    public void setIdCodigoRelacional(String idCodigoRelacional) {
        this.idCodigoRelacional = idCodigoRelacional;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
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
