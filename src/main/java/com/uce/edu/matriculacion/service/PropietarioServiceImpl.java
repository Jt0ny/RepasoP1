package com.uce.edu.matriculacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.matriculacion.repository.IPropietarioRepository;
import com.uce.edu.matriculacion.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService {
	
	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public Propietario buscar(String identificacion) {
		
		return this.iPropietarioRepository.seleccionar(identificacion);
	}

	@Override
	public void guardar(Propietario propietario) {
		this.iPropietarioRepository.insertar(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.iPropietarioRepository.actualizar(propietario);
		
	}

	@Override
	public void eliminar(String identificacion) {
		this.iPropietarioRepository.borrar(identificacion);
		
	}

}
