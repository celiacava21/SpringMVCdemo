package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.entities.Telefono;
import com.example.entities.Estudiante.Genero;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;
import com.example.services.TelefonoService;

@SpringBootApplication
public class SpringMvCdemoApplication implements CommandLineRunner{

	@Autowired
	private FacultadService facultadService;

	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private TelefonoService telefonoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvCdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * Agregar registros de muestra, para Facultad, Estudiante y Teléfono
		 */

		 facultadService.save(
			Facultad.builder().nombre("Informatica").build()
		 );

		 facultadService.save(Facultad.builder().nombre("Biologia").build());


		 estudianteService.save(Estudiante.builder().id(1).nombre("Bawa").primerApellido("raro1")
		 .segundoApellido("raro2").fechaNacimiento(LocalDate.of(1998, Month.APRIL, 9))
		 .fechaAlta(LocalDate.of(1996, Month.FEBRUARY, 12)).genero(Genero.HOMBRE).beca(2500.14)
		 .facultad(facultadService.findbyId(1)).build());

		 estudianteService.save(Estudiante.builder().id(2).nombre("Jewy").primerApellido("Acapulco")
		 .segundoApellido("Shore").fechaNacimiento(LocalDate.of(2001, Month.DECEMBER, 23))
		 .fechaAlta(LocalDate.of(2015, Month.AUGUST, 25)).genero(Genero.OTRO).beca(1000.67)
		 .facultad(facultadService.findbyId(2)).build());

		 telefonoService.save(Telefono.builder().id(1).numero("677698765")
		 .estudiante(estudianteService.findbyId(1)).build());

		 telefonoService.save(Telefono.builder().id(2).numero("677698885")
		 .estudiante(estudianteService.findbyId(2)).build());
	}

}
