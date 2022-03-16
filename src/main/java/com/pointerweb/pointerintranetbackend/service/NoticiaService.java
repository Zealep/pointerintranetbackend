package com.pointerweb.pointerintranetbackend.service;


import com.pointerweb.pointerintranetbackend.model.Noticia;
import com.pointerweb.pointerintranetbackend.model.Noticia;
import com.pointerweb.pointerintranetbackend.model.dto.GaleriaPrincipal;
import com.pointerweb.pointerintranetbackend.model.dto.NoticiaDTO;

import java.util.List;

public interface NoticiaService {

    Noticia findById(String id);
    List<Noticia> findAll();
    Noticia save(Noticia d);
    void deleteById(String id);
    List<NoticiaDTO> getAllNoticiasMain();
    void deleteAllById(String id);

}
