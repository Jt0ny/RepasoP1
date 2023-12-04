package com.uce.edu.matriculacion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.matriculacion.repository.IMatriculaRepository;
import com.uce.edu.matriculacion.repository.IPropietarioRepository;
import com.uce.edu.matriculacion.repository.IVehiculoRepository;
import com.uce.edu.matriculacion.repository.modelo.Matricula;
import com.uce.edu.matriculacion.repository.modelo.Propietario;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	

	@Override
	public Matricula buscar(String numMatricula) {
		
		return this.iMatriculaRepository.seleccionar(numMatricula);
	}

	@Override
	public void matricular(String identificacion, String placa) {
		Propietario propietario=this.iPropietarioRepository.seleccionar(identificacion);
		Vehiculo vehiculo=this.iVehiculoRepository.seleccionar(placa);
		
		Matricula matricula= new Matricula();
		matricula.setPropietario(propietario);
		matricula.setVehiculo(vehiculo);
		matricula.setFechaMatricula(LocalDateTime.now());
		
		if(vehiculo.getTipo().equals("manual")) {
			matricula.setValorMatricula(vehiculo.getPrecio().multiply(new BigDecimal(0.1)));
			
			BigDecimal valorLimite= new BigDecimal(3000);
			BigDecimal valorMatricula= matricula.getValorMatricula();
			
			/*if(valorMatricula.compareTo(valorLimite)>0) {
				matricula.getValorMatricula().multiply(new BigDecimal());
			}*/
		}else {
			matricula.setValorMatricula(vehiculo.getPrecio().multiply(new BigDecimal(0.15)));
		}
		
		this.iMatriculaRepository.insertar(matricula);
		System.out.println(matricula);

	}

	@Override
	public void actualizar(Matricula matricula) {
		this.iMatriculaRepository.actualizar(matricula);
		
	}

	@Override
	public void eliminar(String numMatricula) {
		this.iMatriculaRepository.borrar(numMatricula);
		
	}

}
