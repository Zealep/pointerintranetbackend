package com.pointerweb.pointerintranetbackend.repository;

import com.pointerweb.pointerintranetbackend.model.Menu;
import com.pointerweb.pointerintranetbackend.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends CrudRepository<Menu,Long> {

    @Query("select u from Menu u where u.idModulo=?1")
    Optional<List<Menu>> findByModulo(String modulo);

}
