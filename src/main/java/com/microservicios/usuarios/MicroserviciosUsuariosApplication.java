package com.microservicios.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.repository.CrudRepository;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.microservicios.usuarios.models.entity"})
public class MicroserviciosUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosUsuariosApplication.class, args);
    }
}
