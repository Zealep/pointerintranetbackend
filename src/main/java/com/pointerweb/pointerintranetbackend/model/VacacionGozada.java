package com.pointerweb.pointerintranetbackend.model;

import java.util.Date;

public class VacacionGozada {

    private String IdPeriodoPll;
    private Date FechaDesde;
    private Date FechaHasta;
    private Integer Dias;

    public VacacionGozada(String idPeriodoPll, Date fechaDesde, Date fechaHasta, Integer dias) {
        IdPeriodoPll = idPeriodoPll;
        FechaDesde = fechaDesde;
        FechaHasta = fechaHasta;
        Dias = dias;
    }

    public String getIdPeriodoPll() {
        return IdPeriodoPll;
    }

    public void setIdPeriodoPll(String idPeriodoPll) {
        IdPeriodoPll = idPeriodoPll;
    }

    public Date getFechaDesde() {
        return FechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        FechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return FechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        FechaHasta = fechaHasta;
    }

    public Integer getDias() {
        return Dias;
    }

    public void setDias(Integer dias) {
        Dias = dias;
    }
}
