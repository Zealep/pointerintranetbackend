package com.pointerweb.pointerintranetbackend.service;

import com.pointerweb.pointerintranetbackend.model.DatoArchivo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DatoArchivoService {

    DatoArchivo findById(String id);
    List<DatoArchivo> findByIdCodigoRelacionalAndIdProcesoAndInFotoPrincipal(String id,String idProceso,String principal);
    List<DatoArchivo> findAll();
    DatoArchivo save(DatoArchivo d, MultipartFile file,String codigoRelacional);
    DatoArchivo saveList(DatoArchivo[] d, MultipartFile[] files,String codigoRelacional);
    void deleteById(String id);
    void deleteFile(String path);
    void deleteFilesByEntityAndProcess(String id,String proceso);
    byte[] getFile(String identificador);
}
