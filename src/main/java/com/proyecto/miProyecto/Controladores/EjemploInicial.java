package com.proyecto.miProyecto.Controladores;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.miProyecto.Modelos.Persona;

@RequestMapping ("/ejemplo")
@RestController
public class EjemploInicial {
	@GetMapping("/get")//http://localhost:8080/ejemplo/get
	public String primerMetodo() {
		return "hola a todos";
	}
	
	@PostMapping("/post")//http://localhost:8080/ejemplo/get
	public String segundoMetodo() {
		return "hola a todos, por post";
	}
	
	@GetMapping("/obtenerArreglo")//http://localhost:8080/ejemplo/get
	public String[] tercerMetodo() {
		String[] cadenas = new String[3];
		cadenas[0] = "un texto";
		cadenas[1] = "otro texto";
		cadenas[2] = "ultimo texto";
		return cadenas;
	}
	
	@GetMapping("/obtenerLista")//http://localhost:8080/ejemplo/get
	public List<Integer> cuartoMetodo() {
		List<Integer> listita =new LinkedList<>();
		listita.add(2);
		listita.add(5);
		listita.add(16);
		return listita;
	}
	
	@GetMapping("/obtenerPersona")//http://localhost:8080/ejemplo/get
	public Persona quintotoMetodo() {
		Persona p = new Persona();
		p.Nombre="Pepe";
		p.Apellido="Perales";
		p.Edad=20;
		return p;
	}
	
	@GetMapping("/obtenerPersonas")//http://localhost:8080/ejemplo/get
	public List<Persona> sextotoMetodo() {
		List<Persona> listita =new LinkedList<>();
		Persona p = new Persona();
		p.Nombre="Susana";
		p.Apellido="Sossa";
		p.Edad=21;
		Persona pp = new Persona();
		pp.Nombre="Maria";
		pp.Apellido="Flores";
		pp.Edad=25;
		Persona ppp = new Persona();
		ppp.Nombre="Susana";
		ppp.Apellido="Gonzales";
		ppp.Edad=27;
		listita.add(p);
		listita.add(pp);
		listita.add(ppp);
		return listita;
	}

}
