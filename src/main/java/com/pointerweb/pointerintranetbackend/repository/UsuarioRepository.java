package com.pointerweb.pointerintranetbackend.repository;

import com.pointerweb.pointerintranetbackend.model.Perfil;
import com.pointerweb.pointerintranetbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {

    @Query(nativeQuery = true)
    Perfil getDatosPerfil(@Param("varTrabajador")String trabajador);

    @Query("select u from Usuario u where u.usuario=?1")
    Optional<Usuario> findByUsername(String username);

    @Query("select u.password from Usuario u where u.usuario=?1")
    String findPassByUsuario(String email);

    @Query("select u.idUsuario from Usuario u where u.usuario=?1")
    String findIdUsuarioByUsername(String usuario);


}
