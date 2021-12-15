package com.proyecto.miProyecto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EstudianteNoEncontradoException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7782342560539552693L;

	public EstudianteNoEncontradoException(String mensaje) {
		super(mensaje);
	}

}
