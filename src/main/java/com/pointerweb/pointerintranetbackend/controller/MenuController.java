package com.pointerweb.pointerintranetbackend.controller;

import com.pointerweb.pointerintranetbackend.model.Menu;
import com.pointerweb.pointerintranetbackend.repository.MenuRepository;
import com.pointerweb.pointerintranetbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Menu>> getAll(){
        return new ResponseEntity<List<Menu>>(menuRepository.findByModulo(Constantes.ID_MODULO).orElse(null), HttpStatus.OK);
    }


}
