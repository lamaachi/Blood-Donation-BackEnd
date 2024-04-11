package org.restapi.minprojetrest;


import org.restapi.minprojetrest.Service.impl.RegionServiceImpl;
import org.restapi.minprojetrest.Service.impl.VilleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication()
public class MiniProjetRestApplication  {
    public static void main(String[] args) {
        SpringApplication.run(MiniProjetRestApplication.class, args);
    }

}
