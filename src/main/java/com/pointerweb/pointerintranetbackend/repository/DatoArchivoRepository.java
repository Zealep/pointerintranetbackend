package com.pointerweb.pointerintranetbackend.repository;

import com.pointerweb.pointerintranetbackend.model.DatoArchivo;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatoArchivoRepository extends CrudRepository<DatoArchivo,String> {

    @Procedure(value = "spu_GeneraCorrelativoAnoMes")
    String generatePrimaryKeyDatoArchivo(String tabla,String campo,String empresa);

    DatoArchivo findByIdCodigoRelacionalAndIdProceso(String id,String proceso);

    List<DatoArchivo> findByIdCodigoRelacionalAndIdProcesoAndInFotoPrincipal(String id, String proceso,String principal);

    DatoArchivo findByIdDatoArchivo(String idDatoArchivoPersona);

    DatoArchivo findByIdCodigoRelacional(String IdCodigoRelacional);
}
