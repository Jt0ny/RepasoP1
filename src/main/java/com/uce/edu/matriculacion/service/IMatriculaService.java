package com.uce.edu.matriculacion.service;

import com.uce.edu.matriculacion.repository.modelo.Matricula;

public interface IMatriculaService {
	
	public Matricula buscar (String numMatricula);
	
	public void matricular (String identificacion, String placa);
	
	public  void actualizar (Matricula matricula );
	
	public void eliminar (String numMatricula);


}
