package com.pointerweb.pointerintranetbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointerweb.pointerintranetbackend.model.DatoArchivo;
import com.pointerweb.pointerintranetbackend.service.DatoArchivoService;
import com.pointerweb.pointerintranetbackend.util.Constantes;
import com.pointerweb.pointerintranetbackend.util.RespuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/archivo")
public class DatoArchivoController {

    @Autowired
    DatoArchivoService datoArchivoService;

    @PostMapping(value = "/save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> registrar(@RequestParam(value="file") MultipartFile file, @RequestParam(value="archivo") String archivo,@RequestParam(value="codigo") String codigo) {
        try {
            ObjectMapper obj = new ObjectMapper();
            DatoArchivo img = obj.readValue(archivo,DatoArchivo.class);
            DatoArchivo i = datoArchivoService.save(img,file,codigo);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK", null,""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/getPrincipal/{id}/{proceso}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DatoArchivo>> getPrincipal(@PathVariable(value = "id")String codigoRelacional,@PathVariable(value = "proceso")String idProceso){
        try {
            return new ResponseEntity<List<DatoArchivo>>(datoArchivoService.findByIdCodigoRelacionalAndIdProcesoAndInFotoPrincipal(codigoRelacional,idProceso,Constantes.SI_FOTO_PRINCIPAL),HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getAllAnexos/{id}/{proceso}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DatoArchivo>> getAllAnexos(@PathVariable(value = "id")String codigoRelacional,@PathVariable(value = "proceso")String idProceso){
        try {
            return new ResponseEntity<List<DatoArchivo>>(datoArchivoService.findByIdCodigoRelacionalAndIdProcesoAndInFotoPrincipal(codigoRelacional,idProceso, Constantes.NO_FOTO_PRINCIPAL),HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/saveList", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> registrar(@RequestParam(value="files") MultipartFile[] files, @RequestParam(value="archivo") String archivo,@RequestParam(value="codigo") String codigo) {
        try {
            ObjectMapper obj = new ObjectMapper();
            DatoArchivo[] img = obj.readValue(archivo,DatoArchivo[].class);
            DatoArchivo i = datoArchivoService.saveList(img,files,codigo);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK", null,""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/getFile",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> getFile(@RequestParam(value = "url")String url){
        try {
            return new ResponseEntity<byte[]>(datoArchivoService.getFile(url),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/deleteFile")
    public ResponseEntity<RespuestaApi> deleteFile(@RequestParam(value = "url")String url,@RequestParam(value = "id")String id){
        try {
            datoArchivoService.deleteById(id);
            datoArchivoService.deleteFile(url);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",null,""),HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
