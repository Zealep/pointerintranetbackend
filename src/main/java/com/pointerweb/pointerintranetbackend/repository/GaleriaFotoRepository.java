package com.pointerweb.pointerintranetbackend.repository;

import com.pointerweb.pointerintranetbackend.model.GaleriaFoto;
import com.pointerweb.pointerintranetbackend.model.Noticia;
import com.pointerweb.pointerintranetbackend.model.dto.GaleriaPrincipal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GaleriaFotoRepository extends CrudRepository<GaleriaFoto,String> {

    @Procedure(value = "spu_GeneraCorrelativoAnoMes")
    String generatePrimaryKeyGaleriaFoto(String tabla,String campo,String empresa);

    @Query(value = "select g from GaleriaFoto g where g.estado = ?1")
    List<GaleriaFoto> findActives(String activos);

    @Query(value = "update GaleriaFoto g set g.estado = ?2 where g.idGaleriaFoto = ?1")
    @Modifying
    void deleteByIdLogic(String id,String inactivo);

    @Query(value = "select distinct DATE_FORMAT(fecha,'%Y') from rh_in_tz_galeria_foto",nativeQuery = true)
    List<String> obtenerAñosFotos();

    @Query(value = "select g.idNoticia,g.titulo,g.fecha,f.pathArchivo as imagenPrincipal from rh_in_tz_galeria_foto g\n" +
            " inner join rh_in_tz_datos_archivo f on g.idNoticia = f.idCodigoRelacional\n" +
            " where DATE_FORMAT(g.fecha,'%Y') = ?1 and f.inFotoPrincipal = 'S' and f.idProceso = '00030'",nativeQuery = true)
    List<GaleriaPrincipal> findByYear(String year);


}
