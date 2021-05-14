package com.microservicios.usuarios.model.service;

import com.microservicios.usuarios.model.entity.UsuarioEntity;

import java.util.Optional;

public interface IUsuarioService {

    public Iterable<UsuarioEntity> findAll();

    public Optional<UsuarioEntity> findById(String document);

    public UsuarioEntity save(UsuarioEntity user);

    public void deleteById(String document);

}
