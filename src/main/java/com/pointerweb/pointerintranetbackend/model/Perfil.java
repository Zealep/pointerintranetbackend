package com.pointerweb.pointerintranetbackend.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


public class Perfil {

    private String NombreCompleto;
    private String Cargo;
    private String Empresa;
    private String FechaIngreso;
    private String Correo;
    private String Telefonos;
    private String JefeDirecto;
    private String Cumpleanos;

    public Perfil(String nombreCompleto, String cargo, String empresa, String fechaIngreso, String correo, String telefonos, String jefeDirecto, String cumpleanos) {
        NombreCompleto = nombreCompleto;
        Cargo = cargo;
        Empresa = empresa;
        FechaIngreso = fechaIngreso;
        Correo = correo;
        Telefonos = telefonos;
        JefeDirecto = jefeDirecto;
        Cumpleanos = cumpleanos;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        FechaIngreso = fechaIngreso;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getTelefonos() {
        return Telefonos;
    }

    public void setTelefonos(String telefonos) {
        Telefonos = telefonos;
    }

    public String getJefeDirecto() {
        return JefeDirecto;
    }

    public void setJefeDirecto(String jefeDirecto) {
        JefeDirecto = jefeDirecto;
    }

    public String getCumpleanos() {
        return Cumpleanos;
    }

    public void setCumpleanos(String cumpleanos) {
        Cumpleanos = cumpleanos;
    }
}