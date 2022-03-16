package com.pointerweb.pointerintranetbackend.service;


import com.pointerweb.pointerintranetbackend.model.GaleriaFoto;
import com.pointerweb.pointerintranetbackend.model.Noticia;
import com.pointerweb.pointerintranetbackend.model.dto.GaleriaFotosDTO;
import com.pointerweb.pointerintranetbackend.model.dto.GaleriaPrincipal;

import java.util.List;

public interface GaleriaFotoService {

    GaleriaFoto findById(String id);
    List<GaleriaFoto> findAll();
    GaleriaFoto save(GaleriaFoto d);
    void deleteById(String id);
    List<String> getYears();
    List<GaleriaPrincipal> findByYear(String year);
    List<GaleriaFotosDTO> getGaleriaAllMain();
    void deleteAllById(String id);

}
