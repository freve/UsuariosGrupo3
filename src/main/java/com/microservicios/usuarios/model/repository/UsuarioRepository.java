package com.microservicios.usuarios.model.repository;

import com.microservicios.usuarios.model.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, String> {


}
