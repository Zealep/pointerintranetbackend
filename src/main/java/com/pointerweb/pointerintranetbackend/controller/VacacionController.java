package com.pointerweb.pointerintranetbackend.controller;

import com.pointerweb.pointerintranetbackend.model.Perfil;
import com.pointerweb.pointerintranetbackend.model.VacacionGanada;
import com.pointerweb.pointerintranetbackend.model.VacacionGozada;
import com.pointerweb.pointerintranetbackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacacion")
public class VacacionController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value = "/ganada/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<VacacionGanada>> getAll(@PathVariable(value = "id") String idTrabajador){
        return new ResponseEntity<List<VacacionGanada>>(usuarioRepository.getVacacionesGanadas(idTrabajador), HttpStatus.OK);
    }

    @GetMapping(value = "/gozada/{id}/{periodo}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<VacacionGozada>> getAll(@PathVariable(value = "id") String idTrabajador, @PathVariable(value = "periodo") String periodo){
        return new ResponseEntity<List<VacacionGozada>>(usuarioRepository.getVacacionesGozadas(periodo,idTrabajador), HttpStatus.OK);
    }
}
