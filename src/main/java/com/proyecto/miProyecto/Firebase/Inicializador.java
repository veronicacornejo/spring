package com.proyecto.miProyecto.Firebase;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class Inicializador {
	@PostConstruct
	public void iniciar() {
		try {
		String credencial = "";	
		InputStream serviceAccount = new ByteArrayInputStream(credencial.getBytes());
		//FileInputStream serviceAccount = new FileInputStream("./prueba-vero-firebase-adminsdk-nlpk3-b018575d4d.json");
		FirebaseOptions options = new FirebaseOptions.Builder()
		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		  .setDatabaseUrl("https://prueba-vero.firebaseio.com")
		  .build();
		FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			
		}
		
	}

}
