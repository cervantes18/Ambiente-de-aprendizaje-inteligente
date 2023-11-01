package MAIN;

import java.util.ArrayList;

import Reader.Pregunta;

public class MainPreguntas {

	public static void main(String[] args) {
		Pregunta p = new Pregunta();
		ArrayList<String[]> facil = p.preguntasFaciles(); 
		for (int i = 0; i<5; i++) {
			System.out.println(facil.get(1)[i]);
		}
	}

}
