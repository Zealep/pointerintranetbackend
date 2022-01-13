package com.pointerweb.pointerintranetbackend.controller;

import com.pointerweb.pointerintranetbackend.model.Perfil;
import com.pointerweb.pointerintranetbackend.repository.UsuarioRepository;
import com.pointerweb.pointerintranetbackend.service.PerfilService;
import com.pointerweb.pointerintranetbackend.util.RespuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilService perfilService;

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Perfil> getAll(@PathVariable(value = "id") String idTrabajador){
        return new ResponseEntity<Perfil>(usuarioRepository.getDatosPerfil(idTrabajador), HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerFoto/{id}",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> obtenerFoto(@PathVariable String id){
        byte[] data = null;
        try {
                data = perfilService.obtenerFoto(id);

            return new ResponseEntity<byte[]>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping(value = "/subirFoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RespuestaApi> subirFoto(@RequestParam("file") MultipartFile file, @RequestParam("idUsuario") String idUsuario){
        try {
            perfilService.uploadFoto(file,idUsuario);
            return new ResponseEntity<RespuestaApi>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<RespuestaApi>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
