package com.proyecto.miProyecto.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefectoController {
	@RequestMapping("/")
	public ResponseEntity<String> getServiceName(){
		ResponseEntity<String> reponseEntity = new ResponseEntity<String>(HttpStatus.OK);
		return reponseEntity;
	}

}
