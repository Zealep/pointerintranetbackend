package com.pointerweb.pointerintranetbackend.service.impl;

import com.pointerweb.pointerintranetbackend.model.Noticia;
import com.pointerweb.pointerintranetbackend.model.Noticia;
import com.pointerweb.pointerintranetbackend.model.dto.*;
import com.pointerweb.pointerintranetbackend.repository.NoticiaRepository;
import com.pointerweb.pointerintranetbackend.repository.jdbc.NoticiaJdbcRepository;
import com.pointerweb.pointerintranetbackend.service.DatoArchivoService;
import com.pointerweb.pointerintranetbackend.service.NoticiaService;
import com.pointerweb.pointerintranetbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("noticiaService")
public class NoticiaServiceImpl implements NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private NoticiaJdbcRepository noticiaJdbcRepository;

    @Autowired
    private DatoArchivoService datoArchivoService;


    @Override
    public Noticia findById(String id) {
        return noticiaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Noticia> findAll() {
        return noticiaRepository.findActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Noticia save(Noticia d) {
        d.setEstado(Constantes.ESTADO_ACTIVO);
        return noticiaRepository.save(d);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        noticiaRepository.deleteByIdLogic(id,Constantes.ESTADO_INACTIVO);
    }

    @Override
    public List<NoticiaDTO> getAllNoticiasMain() {

        List<NoticiaPrincipal> years = noticiaJdbcRepository.getPrincipales();
         List<NoticiaPrincipal> mapYears= years.stream().map(
                x->{
                 x.setImagen(convertToBase64(x.getImagen()));
                 return x;
                }
        ).collect(Collectors.toList());
        List<NoticiaDTO> noticias = new ArrayList<>();

        Map<String, Map<String,List<NoticiaPrincipal>>> result = mapYears.stream().collect(Collectors.groupingBy(NoticiaPrincipal::getYear,Collectors.groupingBy(NoticiaPrincipal::getMonth)));

        for (Map.Entry<String, Map<String,List<NoticiaPrincipal>>> entry : result.entrySet()) {
            NoticiaDTO g = new NoticiaDTO();
            List<NoticiasMesDTO> noticiasMes = new ArrayList<>();
            g.setYear(entry.getKey());

            for (Map.Entry<String,List<NoticiaPrincipal>> e: entry.getValue().entrySet()){
                NoticiasMesDTO noticiasMesDTO = new NoticiasMesDTO();
                noticiasMesDTO.setMonth(e.getKey());
                noticiasMesDTO.setPrincipales(e.getValue());
                noticiasMes.add(noticiasMesDTO);
            }
            g.setMeses(noticiasMes);
            noticias.add(g);
        }


        return noticias;
    }

    @Override
    public void deleteAllById(String id) {
        this.deleteById(id);
        datoArchivoService.deleteById(id);
        datoArchivoService.deleteFilesByEntityAndProcess(id,Constantes.PROCESO_NOTICIA);
    }


    private String convertToBase64(String url){
        return Base64.getEncoder().encodeToString(datoArchivoService.getFile(url));
    }

}
