package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Correo;
import com.example.entities.Departamento;
import com.example.entities.Empleado;
import com.example.entities.Telefono;
import com.example.entities.Empleado.Genero;
import com.example.services.CorreoService;
import com.example.services.DepartamentoService;
import com.example.services.EmpleadoService;
import com.example.services.TelefonoService;

@SpringBootApplication
public class SpringMvcEmpresaApplication implements CommandLineRunner{

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private TelefonoService telefonoService;

	@Autowired
	private CorreoService correoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcEmpresaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		departamentoService.save(Departamento.builder()
		.nombre("RRHH")
		.build());

		departamentoService.save(Departamento.builder()
		.nombre("Marketing")
		.build());		

		empleadoService.save(Empleado.builder()
			.itd(1)
			.nombre("Mara")
			.primerApellido("Romero")
			.segundoApellido("Diaz")
			.fechaAlta(LocalDate.of(2021, Month.SEPTEMBER, 14))
			.genero(Genero.MUJER)
			.departamento(departamentoService.findById(1))
			.build());

			empleadoService.save(Empleado.builder()
			.itd(2)
			.nombre("Mara2")
			.primerApellido("Romero2")
			.segundoApellido("Diaz2")
			.fechaAlta(LocalDate.of(2021, Month.SEPTEMBER, 14))
			.genero(Genero.MUJER)
			.departamento(departamentoService.findById(2))
			.build());
			
			telefonoService.save(Telefono.builder()
			.id(1)
			.numero("12345")
			.empleado(empleadoService.findById(1))
			.build());

			telefonoService.save(Telefono.builder()
			.id(2)
			.numero("67890")
			.empleado(empleadoService.findById(2))
			.build());

			correoService.save(Correo.builder()
			.id(1)
			.email("correo1@correo.com")
			.empleado(empleadoService.findById(1))
			.build());

			correoService.save(Correo.builder()
			.id(2)
			.email("correo2@correo.com")
			.empleado(empleadoService.findById(2))
			.build());


	
	
	
	
	}

}
