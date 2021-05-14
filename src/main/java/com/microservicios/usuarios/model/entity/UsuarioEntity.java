package com.microservicios.usuarios.model.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UsuarioEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String documento;

        private String name;
        private String last_name;
        private String email;
        private String password;
        private String institution;

        public UsuarioEntity(){

        }

    public UsuarioEntity(String documento, String name, String last_name, String email, String password, String institution) {
        this.documento = documento;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.institution = institution;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
