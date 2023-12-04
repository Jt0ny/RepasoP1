package com.uce.edu.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matriculacion.repository.modelo.Propietario;

@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository{

	private static List<Propietario> base= new ArrayList<Propietario>();
	
	@Override
	public Propietario seleccionar(String identificacion) {
		for(Propietario propietario:base) {
			if(propietario.getIdentificacion().equals(identificacion)) {
				Propietario pro= new Propietario();
				pro.setApellido(propietario.getApellido());
				pro.setFechaNacimiento(propietario.getFechaNacimiento());
				pro.setIdentificacion(propietario.getIdentificacion());
				pro.setNombre(propietario.getNombre());
				return pro;
				
			}
			
		}
		return null;
	}

	public Propietario seleccionarEliminar (String identificacion) {
		
		for(Propietario propietario:base) {
			if(propietario.getIdentificacion().equals(identificacion)) {
				return propietario;
			}
		}
		return null;
		
	}
	
	@Override
	public void insertar(Propietario propietario) {
		base.add(propietario);
		
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.borrar(propietario.getIdentificacion());
		this.insertar(propietario);
		
	}

	@Override
	public void borrar(String identificacion) {
		Propietario propietario= this.seleccionarEliminar(identificacion);
		base.remove(propietario);
		
	}

}
