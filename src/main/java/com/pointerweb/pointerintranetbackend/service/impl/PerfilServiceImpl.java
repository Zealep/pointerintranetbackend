package com.pointerweb.pointerintranetbackend.service.impl;

import ch.qos.logback.core.rolling.helper.FileStoreUtil;
import com.pointerweb.pointerintranetbackend.model.DatoArchivo;
import com.pointerweb.pointerintranetbackend.repository.DatoArchivoRepository;
import com.pointerweb.pointerintranetbackend.service.PerfilService;
import com.pointerweb.pointerintranetbackend.util.Constantes;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service("perfilService")
public class PerfilServiceImpl implements PerfilService {

    @Value("${url-path-base-attachment-perfil}")
    private String URL_PATH_IMAGES;

    @Autowired
    private DatoArchivoRepository datoArchivoRepository;


    @Override
    public byte[] obtenerFoto(String usuario) {

        try {

            DatoArchivo d = datoArchivoRepository.findByIdCodigoRelacionalAndIdProceso(usuario,Constantes.PROCESO_MI_PERFIL);
            if(d!=null){
                String path = URL_PATH_IMAGES + d.getPathArchivo();
                return FileUtils.readFileToByteArray(new File(FilenameUtils.separatorsToSystem(path)));
            }
            else{
                return null;
            }
        }catch (IOException i){
            return null;
        }
    }

    @Override
    public String uploadFoto(MultipartFile file, String id) {
        DatoArchivo d = new DatoArchivo();
        DatoArchivo existe = datoArchivoRepository.findByIdCodigoRelacionalAndIdProceso(id,Constantes.PROCESO_MI_PERFIL);

        if(existe!=null){
            d.setIdDatoArchivo(existe.getIdDatoArchivo());
        }

        d.setIdCodigoRelacional(id);
        d.setIdEmpresa(Constantes.CODIGO_EMPRESA);
        d.setIdDocumento(Constantes.FOTOGRAFIA);
        d.setIdProceso(Constantes.PROCESO_MI_PERFIL);

        if (d.getIdDatoArchivo() == null) {
            String pk = datoArchivoRepository.generatePrimaryKeyDatoArchivo(Constantes.TABLE_DATO_ARCHIVO, Constantes.ID_TABLE_DATO_ARCHIVO, Constantes.CODIGO_EMPRESA);
            d.setIdDatoArchivo(pk);
        }


        try {
            String url = "/" + d.getIdCodigoRelacional();
            Path path = Paths.get(URL_PATH_IMAGES + url);
            boolean dirExist = Files.exists(path);
            if (!dirExist) {
                Files.createDirectories(path);
            }
            if(existe!=null){
                FileUtils.cleanDirectory(new File(URL_PATH_IMAGES+url));
            }

            Path nameImage = Paths.get(file.getOriginalFilename());
            Path targetLocation = path.resolve(nameImage);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            d.setNombreArchivo(file.getOriginalFilename());
            d.setPathArchivo(url + "/" + file.getOriginalFilename());
            d.setTipoArchivo(FilenameUtils.getExtension(file.getOriginalFilename()));
            d.setPesoArchivo(String.valueOf(file.getSize()));
            datoArchivoRepository.save(d);
            return "OK";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
