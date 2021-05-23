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
    private IUsuarioService userServ;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(userServ.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable String document){
        Optional<UsuarioEntity> userOpt = userServ.findById(document);
        if (userOpt.isEmpty()) {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userOpt.get());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> crear(@RequestBody UsuarioEntity user){
        UsuarioEntity userBd = userServ.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userBd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody UsuarioEntity user, @PathVariable String document){
        Optional<UsuarioEntity> userOpt = userServ.findById(document);
        if (userOpt.isEmpty()) {
           return ResponseEntity.notFound().build();
        }
        UsuarioEntity userBd = userOpt.get();
        userBd.setName(user.getName());
        userBd.setLast_name(user.getLast_name());
        userBd.setEmail(user.getEmail());
        userBd.setInstitution(user.getInstitution());

        return ResponseEntity.status(HttpStatus.CREATED).body(userServ.save(userBd));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String document){
        userServ.deleteById(document);
        return ResponseEntity.noContent().build();
    }

}
