package com.pointerweb.pointerintranetbackend.service.impl;

import com.pointerweb.pointerintranetbackend.model.GaleriaFoto;
import com.pointerweb.pointerintranetbackend.model.Noticia;
import com.pointerweb.pointerintranetbackend.model.dto.GaleriaFotosDTO;
import com.pointerweb.pointerintranetbackend.model.dto.GaleriaPrincipal;
import com.pointerweb.pointerintranetbackend.repository.DatoArchivoRepository;
import com.pointerweb.pointerintranetbackend.repository.GaleriaFotoRepository;
import com.pointerweb.pointerintranetbackend.repository.NoticiaRepository;
import com.pointerweb.pointerintranetbackend.repository.jdbc.GaleriaJdbcRepository;
import com.pointerweb.pointerintranetbackend.service.DatoArchivoService;
import com.pointerweb.pointerintranetbackend.service.GaleriaFotoService;
import com.pointerweb.pointerintranetbackend.service.NoticiaService;
import com.pointerweb.pointerintranetbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service("galeriaFotoService")
public class GaleriaFotoServiceImpl implements GaleriaFotoService {

    @Autowired
    private GaleriaFotoRepository galeriaFotoRepository;

    @Autowired
    private DatoArchivoRepository datoArchivoRepository;

    @Autowired
    private GaleriaJdbcRepository galeriaJdbcRepository;

    @Autowired
    private DatoArchivoService datoArchivoService;

    @Override
    public GaleriaFoto findById(String id) {
        return galeriaFotoRepository.findById(id).orElse(null);
    }

    @Override
    public List<GaleriaFoto> findAll() {
        return galeriaFotoRepository.findActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public GaleriaFoto save(GaleriaFoto d) {

        if(d.getIdGaleriaFoto()==null) {
            String pk = galeriaFotoRepository.generatePrimaryKeyGaleriaFoto(Constantes.TABLE_GALERIA_FOTO, Constantes.ID_TABLE_GALERIA_FOTO, Constantes.CODIGO_EMPRESA);
            d.setIdGaleriaFoto(pk);
        }
        d.setIdEmpresa(Constantes.CODIGO_EMPRESA);
        d.setEstado(Constantes.ESTADO_ACTIVO);

        return galeriaFotoRepository.save(d);
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        galeriaFotoRepository.deleteByIdLogic(id,Constantes.ESTADO_INACTIVO);
    }

    @Override
    public List<String> getYears() {
        return galeriaFotoRepository.obtenerAñosFotos();
    }

    @Override
    public List<GaleriaPrincipal> findByYear(String year) {
        return galeriaFotoRepository.findByYear(year);
    }

    @Override
    public List<GaleriaFotosDTO> getGaleriaAllMain() {
        try {
            List<GaleriaFotosDTO> listMainGaleria = new ArrayList<>();

            List<GaleriaPrincipal> galeria = galeriaJdbcRepository.getPrincipales();
            Map<String, List<GaleriaPrincipal>> result = galeria.stream().collect(Collectors.groupingBy(GaleriaPrincipal::getYear, Collectors.toList()));
            for (Map.Entry<String, List<GaleriaPrincipal>> entry : result.entrySet()) {
                GaleriaFotosDTO g = new GaleriaFotosDTO();
                g.setYear(entry.getKey());
                g.setPrincipales(entry.getValue());
                listMainGaleria.add(g);
            }

            return obtenerImagen(listMainGaleria);
        }
        catch (Exception e){
            return null;
        }

    }

    @Override
    public void deleteAllById(String id) {
        this.deleteById(id);
        datoArchivoService.deleteById(id);
        datoArchivoService.deleteFilesByEntityAndProcess(id,Constantes.PROCESO_GALERIA);
    }

    private List<GaleriaFotosDTO> obtenerImagen(List<GaleriaFotosDTO> galerias){

        for(int i=0;i<galerias.size();i++){
             for(int j=0;j<galerias.get(i).getPrincipales().size();j++){
                 byte[] img = datoArchivoService.getFile(galerias.get(i).getPrincipales().get(j).getImagenPrincipal());
                 galerias.get(i).getPrincipales().get(j).setImg( Base64.getEncoder().encodeToString(img));
             }
         }

        return galerias;
    }
}
