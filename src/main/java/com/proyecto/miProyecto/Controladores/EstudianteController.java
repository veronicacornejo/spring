package com.proyecto.miProyecto.Controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.miProyecto.Firebase.FirebaseServicio;
import com.proyecto.miProyecto.Modelos.Persona;

@RequestMapping("/Estudiante")
@RestController
public class EstudianteController {
	
	@PostMapping("/unregistro")
	public Persona comprobar() {
		return FirebaseServicio.recibirDocumento();
	}
	
	@GetMapping("/todosLosRegistros")
	public List<Persona> getEstudiantes(){
		return FirebaseServicio.recibirEstudiantes();
	}
	
	@GetMapping("/obtenerEstudiantesMayoresA/{edad}")
	public List<Persona> getEstudiantes(@PathVariable String edad){
		return FirebaseServicio.recibirEstudiantes(Integer.parseInt(edad));
	}
	
	@PostMapping("/registrarEstudiante")
	public String crearPersona(@RequestBody Persona p){
		return FirebaseServicio.registrarPersona(p);
	}
	
	@PostMapping("/obtenerMayores")
	public List<Persona> obtenerEstudiantesM(@RequestHeader int edad){
		return FirebaseServicio.recibirEstudiantes(edad);
	}

}
