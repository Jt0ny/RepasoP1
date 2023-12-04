package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.matriculacion.repository.modelo.Matricula;
import com.uce.edu.matriculacion.repository.modelo.Propietario;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;
import com.uce.edu.matriculacion.service.IMatriculaService;
import com.uce.edu.matriculacion.service.IPropietarioService;
import com.uce.edu.matriculacion.service.IVehiculoService;

@SpringBootApplication
public class RepasoP1Application implements CommandLineRunner {
	
	@Autowired 
	private IMatriculaService iMatriculaService;
	@Autowired
	private IPropietarioService iPropietarioService;
	@Autowired
	private IVehiculoService iVehiculoService;
	

	public static void main(String[] args) {
		SpringApplication.run(RepasoP1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Vehiculo vehiculo= new Vehiculo();
		vehiculo.setMarca("KIA");
		vehiculo.setModelo("XYZ");
		vehiculo.setPlaca("PTW420");
		vehiculo.setPrecio(new BigDecimal(5000));
		vehiculo.setTipo("manual");
		this.iVehiculoService.guardar(vehiculo);
		System.out.println(vehiculo);
		
		vehiculo.setMarca("Chevrolet");
		vehiculo.setModelo("123");
		this.iVehiculoService.actualizar(vehiculo);
		
		System.out.println(vehiculo);
		
		Propietario propietario =new Propietario();
		propietario.setApellido("Tipan");
		propietario.setFechaNacimiento(LocalDateTime.now());
		propietario.setIdentificacion("1726787425");
		propietario.setNombre("Anthony");
		this.iPropietarioService.guardar(propietario);
		System.out.println(propietario);
		
		this.iMatriculaService.matricular("1726787425", "PTW420");
		
		
		
		
	
	}

}
