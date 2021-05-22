package com.microservicios.usuarios.controller;

import com.microservicios.usuarios.model.entity.UsuarioEntity;
import com.microservicios.usuarios.model.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService user_serv;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(user_serv.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable String document){
        Optional<UsuarioEntity> user_opt = user_serv.findById(document);
        if (user_opt.isEmpty()){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user_opt.get());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> crear(@RequestBody UsuarioEntity user){
        UsuarioEntity user_bd = user_serv.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user_bd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody UsuarioEntity user, @PathVariable String document){
        Optional<UsuarioEntity> user_opt = user_serv.findById(document);
        if (user_opt.isEmpty()){
           return ResponseEntity.notFound().build();
        }

        UsuarioEntity user_bd = user_opt.get();
        user_bd.setName(user.getName());
        user_bd.setLast_name(user.getLast_name());
        user_bd.setEmail(user.getEmail());
        user_bd.setInstitution(user.getInstitution());

        return ResponseEntity.status(HttpStatus.CREATED).body(user_serv.save(user_bd));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String document){

        user_serv.deleteById(document);
        return ResponseEntity.noContent().build();

    }

}
