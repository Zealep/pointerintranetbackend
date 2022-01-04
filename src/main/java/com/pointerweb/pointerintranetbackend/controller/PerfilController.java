package com.pointerweb.pointerintranetbackend.controller;

import com.pointerweb.pointerintranetbackend.model.Perfil;
import com.pointerweb.pointerintranetbackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Perfil> getAll(@PathVariable(value = "id") String idTrabajador){
        return new ResponseEntity<Perfil>(usuarioRepository.getDatosPerfil(idTrabajador), HttpStatus.OK);
    }
}
