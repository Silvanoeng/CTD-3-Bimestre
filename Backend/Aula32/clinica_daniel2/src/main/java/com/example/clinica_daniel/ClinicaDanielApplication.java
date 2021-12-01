package com.example.clinica_daniel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaDanielApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ClinicaDanielApplication.class);

	public static void main(String[] args) {
		LOG.info("Iniciando Api Clinica Daniel.");
		SpringApplication.run(ClinicaDanielApplication.class, args);
		LOG.info("Api Clinica Daniel iniciado com sucesso.");
	}

}
