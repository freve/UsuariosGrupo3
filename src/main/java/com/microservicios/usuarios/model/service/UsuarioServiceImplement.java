package com.microservicios.usuarios.model.service;

import com.microservicios.usuarios.model.entity.UsuarioEntity;
import com.microservicios.usuarios.model.repository.UsuarioRepository;
import com.microservicios.usuarios.model.service.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<UsuarioEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioEntity> findById(String document) {
        return repository.findById(document);
    }

    @Override
    public UsuarioEntity save(UsuarioEntity user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(String document) {
        repository.deleteById(document);
    }
}
