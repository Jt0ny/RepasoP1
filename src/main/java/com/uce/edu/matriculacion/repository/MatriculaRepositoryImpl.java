package com.uce.edu.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matriculacion.repository.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository{
	
	private static List<Matricula> base = new ArrayList<Matricula>();

	@Override
	public Matricula seleccionar(String numMatricula) {
		for(Matricula matricula: base) {
			if (matricula.getNumMatricula().equals(numMatricula)) {
				Matricula matr= new Matricula();
				matr.setFechaMatricula(matricula.getFechaMatricula());
				matr.setNumMatricula(matricula.getNumMatricula());
				matr.setPropietario(matricula.getPropietario());
				matr.setValorMatricula(matricula.getValorMatricula());
				matr.setVehiculo(matricula.getVehiculo());
				return matr;
				
			}
			
		}
		return null;
	}

	public Matricula seleccionarEliminar(String  numMatricula) {
		
		for(Matricula matricula:base) {
			if(matricula.getNumMatricula().equals(numMatricula)) {
				return matricula;
			}
		}
		return null;
	}
	
	@Override
	public void insertar(Matricula matricula) {
		base.add(matricula);
		
	}

	@Override
	public void actualizar(Matricula matricula) {
		this.borrar(matricula.getNumMatricula());
		this.insertar(matricula);
		
	}

	@Override
	public void borrar(String numMatricula) {
		Matricula matricula=this.seleccionarEliminar(numMatricula);
		base.remove(matricula);
		
	}

}
