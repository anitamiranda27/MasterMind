package packMasterMind;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaPuntuaciones implements Serializable{
	
	private List<Puntuacion> listaDePuntuaciones;	
	
	public ListaPuntuaciones()
	{
		listaDePuntuaciones = new ArrayList<Puntuacion>();
	}

	private Iterator<Puntuacion> getIterator()
	{
		return listaDePuntuaciones.iterator();
	}
	
	public void mostrarPuntuaciones() 
	{
		Iterator<Puntuacion> it = getIterator();
		
		Puntuacion p;
			
		System.out.println("-------------------");
		System.out.println("| JUGADOR y PUNTOS |");
		System.out.println("-------------------");
		
		while( it.hasNext() )
		{
			p = it.next();
			
			p.visualizar();
		}
		
		System.out.println();
	}

	public void añadirPuntuacion(String nombre, int puntos) {

		listaDePuntuaciones.add( new Puntuacion( nombre , puntos ) );	
	}
	
	protected int getSize()
	{
		return listaDePuntuaciones.size();
	}
}
