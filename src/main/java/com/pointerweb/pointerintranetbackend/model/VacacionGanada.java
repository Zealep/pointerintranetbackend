package com.pointerweb.pointerintranetbackend.model;

public class VacacionGanada {

    private String Periodo;
    private Double Vacaciones_Ganadas;
    private Double Vacaciones_Gozadas;
    private Double Saldo_Disponible;
    private String idPeriodoPll;

    public VacacionGanada(String periodo, Double vacaciones_Ganadas, Double vacaciones_Gozadas, Double saldo_Disponible, String idPeriodoPll) {
        Periodo = periodo;
        Vacaciones_Ganadas = vacaciones_Ganadas;
        Vacaciones_Gozadas = vacaciones_Gozadas;
        Saldo_Disponible = saldo_Disponible;
        this.idPeriodoPll = idPeriodoPll;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String periodo) {
        Periodo = periodo;
    }

    public Double getVacaciones_Ganadas() {
        return Vacaciones_Ganadas;
    }

    public void setVacaciones_Ganadas(Double vacaciones_Ganadas) {
        Vacaciones_Ganadas = vacaciones_Ganadas;
    }

    public Double getVacaciones_Gozadas() {
        return Vacaciones_Gozadas;
    }

    public void setVacaciones_Gozadas(Double vacaciones_Gozadas) {
        Vacaciones_Gozadas = vacaciones_Gozadas;
    }

    public Double getSaldo_Disponible() {
        return Saldo_Disponible;
    }

    public void setSaldo_Disponible(Double saldo_Disponible) {
        Saldo_Disponible = saldo_Disponible;
    }

    public String getIdPeriodoPll() {
        return idPeriodoPll;
    }

    public void setIdPeriodoPll(String idPeriodoPll) {
        this.idPeriodoPll = idPeriodoPll;
    }
}
