package com.microservicios.usuarios.model.service;

import com.microservicios.usuarios.model.entity.UsuarioEntity;

import java.util.Optional;

public interface IUsuarioService {

    Iterable<UsuarioEntity> findAll();

    Optional<UsuarioEntity> findById(String document);

    UsuarioEntity save(UsuarioEntity user);

    void deleteById(String document);

}
