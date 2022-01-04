package com.pointerweb.pointerintranetbackend.model.dto;

public class RptBoleta {

    private String varEmpresa;
    private String varPeriodo;
    private String varTrabajador;
    private String varTipoBoleta;
    private String varTipoPlanilla;
    private String varCentroCosto;
    private String varArea;
    private String varIdEstablecimiento;
    private String subReportDir;

    public RptBoleta(String varEmpresa, String varPeriodo, String varTrabajador, String varTipoBoleta, String varTipoPlanilla, String varCentroCosto, String varArea, String varIdEstablecimiento, String subReportDir) {
        this.varEmpresa = varEmpresa;
        this.varPeriodo = varPeriodo;
        this.varTrabajador = varTrabajador;
        this.varTipoBoleta = varTipoBoleta;
        this.varTipoPlanilla = varTipoPlanilla;
        this.varCentroCosto = varCentroCosto;
        this.varArea = varArea;
        this.varIdEstablecimiento = varIdEstablecimiento;
        this.subReportDir = subReportDir;
    }

    public String getVarEmpresa() {
        return varEmpresa;
    }

    public void setVarEmpresa(String varEmpresa) {
        this.varEmpresa = varEmpresa;
    }

    public String getVarPeriodo() {
        return varPeriodo;
    }

    public void setVarPeriodo(String varPeriodo) {
        this.varPeriodo = varPeriodo;
    }

    public String getVarTrabajador() {
        return varTrabajador;
    }

    public void setVarTrabajador(String varTrabajador) {
        this.varTrabajador = varTrabajador;
    }

    public String getVarTipoBoleta() {
        return varTipoBoleta;
    }

    public void setVarTipoBoleta(String varTipoBoleta) {
        this.varTipoBoleta = varTipoBoleta;
    }

    public String getVarTipoPlanilla() {
        return varTipoPlanilla;
    }

    public void setVarTipoPlanilla(String varTipoPlanilla) {
        this.varTipoPlanilla = varTipoPlanilla;
    }

    public String getVarCentroCosto() {
        return varCentroCosto;
    }

    public void setVarCentroCosto(String varCentroCosto) {
        this.varCentroCosto = varCentroCosto;
    }

    public String getVarArea() {
        return varArea;
    }

    public void setVarArea(String varArea) {
        this.varArea = varArea;
    }

    public String getVarIdEstablecimiento() {
        return varIdEstablecimiento;
    }

    public void setVarIdEstablecimiento(String varIdEstablecimiento) {
        this.varIdEstablecimiento = varIdEstablecimiento;
    }

    public String getSubReportDir() {
        return subReportDir;
    }

    public void setSubReportDir(String subReportDir) {
        this.subReportDir = subReportDir;
    }
}
