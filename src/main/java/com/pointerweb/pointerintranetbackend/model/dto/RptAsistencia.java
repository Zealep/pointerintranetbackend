package com.pointerweb.pointerintranetbackend.model.dto;

public class RptAsistencia {

    private String varEmpresa;
    private String varFechaDesde;
    private String varFechaHasta;
    private String varIdArea;
    private String varIdCentroCosto;
    private String varIdTipoPlanilla;
    private String varIdTrabajador;
    private String varSucursal;
    private String varUsuario;


    public RptAsistencia(String varEmpresa, String varFechaDesde, String varFechaHasta, String varIdArea, String varIdCentroCosto, String varIdTipoPlanilla, String varIdTrabajador, String varSucursal, String varUsuario) {

        this.varEmpresa = varEmpresa;
        this.varFechaDesde = varFechaDesde;
        this.varFechaHasta = varFechaHasta;
        this.varIdArea = varIdArea;
        this.varIdCentroCosto = varIdCentroCosto;
        this.varIdTipoPlanilla = varIdTipoPlanilla;
        this.varIdTrabajador = varIdTrabajador;
        this.varSucursal = varSucursal;
        this.varUsuario = varUsuario;
    }

    public String getVarEmpresa() {
        return varEmpresa;
    }

    public void setVarEmpresa(String varEmpresa) {
        this.varEmpresa = varEmpresa;
    }

    public String getVarFechaDesde() {
        return varFechaDesde;
    }

    public void setVarFechaDesde(String varFechaDesde) {
        this.varFechaDesde = varFechaDesde;
    }

    public String getVarFechaHasta() {
        return varFechaHasta;
    }

    public void setVarFechaHasta(String varFechaHasta) {
        this.varFechaHasta = varFechaHasta;
    }

    public String getVarIdArea() {
        return varIdArea;
    }

    public void setVarIdArea(String varIdArea) {
        this.varIdArea = varIdArea;
    }

    public String getVarIdCentroCosto() {
        return varIdCentroCosto;
    }

    public void setVarIdCentroCosto(String varIdCentroCosto) {
        this.varIdCentroCosto = varIdCentroCosto;
    }

    public String getVarIdTipoPlanilla() {
        return varIdTipoPlanilla;
    }

    public void setVarIdTipoPlanilla(String varIdTipoPlanilla) {
        this.varIdTipoPlanilla = varIdTipoPlanilla;
    }

    public String getVarIdTrabajador() {
        return varIdTrabajador;
    }

    public void setVarIdTrabajador(String varIdTrabajador) {
        this.varIdTrabajador = varIdTrabajador;
    }

    public String getVarSucursal() {
        return varSucursal;
    }

    public void setVarSucursal(String varSucursal) {
        this.varSucursal = varSucursal;
    }

    public String getVarUsuario() {
        return varUsuario;
    }

    public void setVarUsuario(String varUsuario) {
        this.varUsuario = varUsuario;
    }
}
