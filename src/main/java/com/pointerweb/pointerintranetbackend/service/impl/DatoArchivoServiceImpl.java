package com.pointerweb.pointerintranetbackend.service.impl;

import com.pointerweb.pointerintranetbackend.model.DatoArchivo;
import com.pointerweb.pointerintranetbackend.repository.DatoArchivoRepository;
import com.pointerweb.pointerintranetbackend.service.DatoArchivoService;
import com.pointerweb.pointerintranetbackend.service.NoticiaService;
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

@Service("datoArchivoService")
public class DatoArchivoServiceImpl implements DatoArchivoService {

    @Value("${url-path-base-attachment}")
    private String URL_PATH_BASE_ATTACHMENT;

    @Autowired
    DatoArchivoRepository datoArchivoRepository;

    @Autowired
    NoticiaService NoticiaService;


    @Override
    public DatoArchivo findById(String id) {
        return datoArchivoRepository.findById(id).orElse(null);
    }

    @Override
    public List<DatoArchivo> findByIdCodigoRelacionalAndIdProcesoAndInFotoPrincipal(String id,String proceso,String principal) {
        return datoArchivoRepository.findByIdCodigoRelacionalAndIdProcesoAndInFotoPrincipal(id,proceso,principal);
    }

    @Override
    public List<DatoArchivo> findAll() {
        return (List<DatoArchivo>) datoArchivoRepository.findAll();
    }

    @Override
    public DatoArchivo save(DatoArchivo d, MultipartFile file,String codigoRelacional) {

        if(d.getIdDatoArchivo()==null) {
            String pk = datoArchivoRepository.generatePrimaryKeyDatoArchivo(Constantes.TABLE_DATO_ARCHIVO_INTRANET, Constantes.ID_TABLE_DATO_ARCHIVO_INTRANET, Constantes.CODIGO_EMPRESA);
            d.setIdDatoArchivo(pk);
        }

        try {
            String url = "/"+ d.getIdProceso() + "/"+codigoRelacional;
            Path path = Paths.get(URL_PATH_BASE_ATTACHMENT+url);
            boolean dirExist = Files.exists(path);
            if (!dirExist) {
                Files.createDirectories(path);
            }
            d.setIdCodigoRelacional(codigoRelacional);
            Path nameImage = Paths.get(file.getOriginalFilename());
            Path targetLocation = path.resolve(nameImage);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            d.setNombreArchivo(file.getOriginalFilename());
            d.setPathArchivo(url+"/"+file.getOriginalFilename());
            d.setTipoArchivo(FilenameUtils.getExtension(file.getOriginalFilename()));
            d.setPesoArchivo(String.valueOf(file.getSize()));
            d.setIdEmpresa(Constantes.CODIGO_EMPRESA);
            datoArchivoRepository.save(d);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return datoArchivoRepository.save(d);
    }

    @Override
    public DatoArchivo saveList(DatoArchivo[] archivos, MultipartFile[] files,String codigoRelacional) {

        for (int i=0;i <files.length;i++) {
           for(int j=0;j<archivos.length;j++){
               if(files[i].getOriginalFilename().equalsIgnoreCase(archivos[j].getNombreArchivo())){
                   this.save(archivos[j],files[i],codigoRelacional);
                   break;
               }
           }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        datoArchivoRepository.deleteById(id);
    }

    @Override
    public void deleteFile(String path) {
        String url = URL_PATH_BASE_ATTACHMENT+path;
        Path p = Paths.get(url);
        try{
            Files.delete(p);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteFilesByEntityAndProcess(String id,String proceso) {
        String url = URL_PATH_BASE_ATTACHMENT+"/"+proceso+"/"+id;
        Path p = Paths.get(url);
        try{
            Files.delete(p);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public byte[] getFile(String url) {
        try {
            String path = URL_PATH_BASE_ATTACHMENT + url;
            return FileUtils.readFileToByteArray(new File(FilenameUtils.separatorsToSystem(path)));
        }catch (IOException i){
            return null;
        }

    }


}
