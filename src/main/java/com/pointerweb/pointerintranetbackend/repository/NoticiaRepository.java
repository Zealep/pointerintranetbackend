package com.pointerweb.pointerintranetbackend.repository;

import com.pointerweb.pointerintranetbackend.model.Noticia;
import com.pointerweb.pointerintranetbackend.model.Noticia;
import com.pointerweb.pointerintranetbackend.model.dto.GaleriaPrincipal;
import com.pointerweb.pointerintranetbackend.model.dto.NoticiaDTO;
import com.pointerweb.pointerintranetbackend.model.dto.NoticiaPrincipal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends CrudRepository<Noticia,String> {

    @Procedure(value = "spu_GeneraCorrelativoAnoMes")
    String generatePrimaryKeyNoticia(String tabla,String campo,String empresa);

    @Query(value = "select g from Noticia g where g.estado = ?1")
    List<Noticia> findActives(String activos);

    @Query(value = "update Noticia g set g.estado = ?2 where g.idNoticia = ?1")
    @Modifying
    void deleteByIdLogic(String id,String inactivo);

    @Query(value = "select DATE_FORMAT(n.fecha,'%Y') as year,DATE_FORMAT(n.fecha,'%m') as month from rh_in_tz_noticia n",nativeQuery = true)
    List<NoticiaPrincipal> obtenerAñosYMesNoticia();

    @Query(value = "select n.idNoticia,n.titulo,n.detalle,n.fecha,DATE_FORMAT(n.fecha,'%Y') as year,DATE_FORMAT(n.fecha,'%m') as month,DATE_FORMAT(n.fecha,'%M') as mes, f.pathArchivo as imagen from rh_in_tz_noticia n" +
            " inner join rh_in_tz_datos_archivo f on n.idNoticia = f.idCodigoRelacional where DATE_FORMAT(n.fecha,'%Y') = ?1 and f.idProceso = '00031';",nativeQuery = true)
    List<NoticiaDTO> findByYear(String year);

    @Query(value = "select n.idNoticia,n.titulo,n.detalle,n.fecha,DATE_FORMAT(n.fecha,'%Y') as year,DATE_FORMAT(n.fecha,'%m') as month,DATE_FORMAT(n.fecha,'%M') as mes, f.pathArchivo as imagen from rh_in_tz_noticia n" +
            " inner join rh_in_tz_datos_archivo f on n.idNoticia = f.idCodigoRelacional where DATE_FORMAT(n.fecha,'%Y') = ?1 and DATE_FORMAT(n.fecha,'%m') = ?2  and f.idProceso = '00031';",nativeQuery = true)
    List<NoticiaDTO> findByYearAndMonth(String year,String month);


}
