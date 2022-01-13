package com.pointerweb.pointerintranetbackend.service;

import org.springframework.web.multipart.MultipartFile;

public interface PerfilService {

    byte[] obtenerFoto(String usuario);

    String uploadFoto(MultipartFile file, String idUsuario);

}
