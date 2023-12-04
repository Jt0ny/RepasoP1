package com.uce.edu.matriculacion.repository;

import com.uce.edu.matriculacion.repository.modelo.Matricula;

public interface IMatriculaRepository {

	public Matricula seleccionar (String numMatricula);
	
	public void insertar (Matricula matricula);
	
	public  void actualizar (Matricula matricula );
	
	public void borrar (String numMatricula);
}
