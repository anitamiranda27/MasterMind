package packMasterMind;

import java.io.Serializable;

public class Puntuacion implements Serializable{

	private String nombre;
	private int puntos;
	
	public Puntuacion( String pNombre , int pPuntos )
	{
		nombre = pNombre;
		puntos = pPuntos;
	}
		
	public void visualizar() {
		
		System.out.println( nombre +" : "+ puntos );
	}	
}
