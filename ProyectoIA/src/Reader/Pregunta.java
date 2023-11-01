package Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pregunta {
	String rutaFacil = "bancoPreguntas/preguntas_faciles.txt";
	String rutaMedia = "bancoPreguntas/preguntas_intermedias.txt";
	String rutaDificil = "bancoPreguntas/preguntas_dificiles.txt";
	
	public Pregunta() {
		
	}
	public ArrayList<String[]> recuperarPreguntas(String Ruta){
		ArrayList <String[]> preguntas = new ArrayList<String[]>();
		try(BufferedReader bf = new BufferedReader(new FileReader(Ruta))){//Lee los datos
			String s;
			while((s = bf.readLine())!=null) {//Hasta que no haya linea para leer
				String[] datos = s.split("[|]");//Reagrupa los datos con su respectivo separador
				//Crea un usuario con esos datos
				preguntas.add(datos);
				}
			}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return preguntas;
	}
	
	public ArrayList<String[]> preguntasFaciles(){
		return recuperarPreguntas(rutaFacil);
	}
	public ArrayList<String[]> preguntasMedias(){
		return recuperarPreguntas(rutaMedia);
	}
	public ArrayList<String[]> preguntasDificiles(){
		return recuperarPreguntas(rutaDificil);
	}
	
      
         
}
