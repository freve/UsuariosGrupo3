package com.microservicios.usuarios.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UsuarioEntity implements Serializable {

    @Id
    private String documento;

    @NotEmpty
    private String name;

    @NotEmpty
    private String last_name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String institution;

    public UsuarioEntity() {

    }

    public UsuarioEntity(String documento, String name, String last_name, String email, String password, String institution) {
        this.documento = documento;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.institution = institution;
    }

}
