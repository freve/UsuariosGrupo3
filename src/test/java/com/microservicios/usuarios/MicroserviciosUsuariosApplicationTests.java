package com.microservicios.usuarios;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MicroserviciosUsuariosApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void pruebaBCrypt(){
        int strength = 10;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode("OnePunchMan30");
        System.out.println(encodedPassword);
    }
}
