package com.proyecto.miProyecto.Firebase;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.proyecto.miProyecto.EstudianteNoEncontradoException;
import com.proyecto.miProyecto.Modelos.Persona;
@Service
public class FirebaseServicio {
		
	public static Persona recibirDocumento(){
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("Estudiante").document("T2rrymSCp7LU6A4XI2gs");
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		Persona per = null;
		try {
			DocumentSnapshot documento = future.get();
			per = documento.toObject(Persona.class);
			if(per == null) throw new EstudianteNoEncontradoException("No se pudo recibir estudiantes");
		}catch(InterruptedException e) {
			e.printStackTrace();
			throw new EstudianteNoEncontradoException("No se pudo recibir documento");
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EstudianteNoEncontradoException("No se pudo recibir documento");
		}
		return per;
		
	}
	
	public static List<Persona> recibirEstudiantes(){
		List<Persona> lp = new LinkedList <Persona>();
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference estudiantes = dbFirestore.collection("Estudiante");
		com.google.cloud.firestore.Query qr = estudiantes.whereGreaterThan("Edad",0);
		ApiFuture<QuerySnapshot> querySnapshot = qr.get();
		try {
			for(DocumentSnapshot document: querySnapshot.get().getDocuments()) {
				lp.add(document.toObject(Persona.class));
			}
			
		}catch(InterruptedException e) {
			e.printStackTrace();
			throw new EstudianteNoEncontradoException("No se pudo recibir estudiantes");
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EstudianteNoEncontradoException("No se pudo recibir estudiantes");
		}
		return lp;
		
	}
	
	public static List<Persona> recibirEstudiantes(int edadMinima){
		List<Persona> lp = new LinkedList <Persona>();
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference estudiantes = dbFirestore.collection("Estudiante");
		com.google.cloud.firestore.Query qr = estudiantes.whereGreaterThan("Edad",edadMinima);
		ApiFuture<QuerySnapshot> querySnapshot = qr.get();
		try {
			for(DocumentSnapshot document: querySnapshot.get().getDocuments()) {
				lp.add(document.toObject(Persona.class));
			}
			
		}catch(InterruptedException e) {
			e.printStackTrace();
			throw new EstudianteNoEncontradoException("No se pudo recibir estudiantes");
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EstudianteNoEncontradoException("No se pudo recibir estudiantes");
		}
		return lp;		
	}
	
	public static String registrarPersona(Persona p) {
		try {
			Firestore dbFirestore = FirestoreClient.getFirestore();
			DocumentReference docAserAgregado = dbFirestore.collection("Estudiante").document();
			ApiFuture<WriteResult> colleccionFuture = docAserAgregado.set(p);
			return docAserAgregado.getId();						
			//return "Si"
		}catch(Exception e){
			//return "No";
			throw new EstudianteNoEncontradoException("No se pudo recibir estudiantes");
		}
	}	

}
/*Para compilar la aplicacion completa vamos a CMD y nos ubicamos en la carpeta del proyecto:
 * C:\Users\Verito\Documents\workspace-spring-tool-suite-4-4.12.0.RELEASE\miProyecto
 * escribimos
 * >mvnw package [enter]
 * esperamos
 * 
 */