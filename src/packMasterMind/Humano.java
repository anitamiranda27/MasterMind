package packMasterMind;

import java.util.ArrayList;
import java.util.Scanner;

public class Humano extends Jugador {
	
	private ArrayList<Jugada> intentos;
	
	public Humano()
	{
		super();
		intentos = new ArrayList<Jugada>();
	}

	public void inicializar()
	{
		super.inicializar();
		intentos.clear();
	}	
	
	public void añadirIntento( Jugada pIntento )
	{
		intentos.add( pIntento );
	}
	
	public boolean intentoRepetido( Jugada pIntento )
	{		
		int i = 0;
		boolean enc = false;
		while( i < intentos.size() && !enc )
		{
			String j1 = intentos.get(i).toString();
			String j2 = pIntento.toString();
			
			if ( j1.equals( j2 ) )
			{
				enc = true;
			}
			else
			{
				i++;
			}			
		}
		
		return enc;
	}	
	
	public void generarSecreto()
	{
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner( System.in );
		
		String linea;
		
		do
		{
			do
			{
				System.out.println("Teclea secreto ( tranquil@ la maquina no lo ve ) ");
					
				linea = entrada.nextLine();
				
				if ( comprobarEntrada( linea ) == false )
				{
					System.err.println("INTENTO ERRONEO!!!");
				}
			}
			while( comprobarEntrada( linea ) == false );
			
			if ( hayRepetidos( linea ) )
			{
				System.err.println("NO PUEDES TECLEAR REPETIDOS, TRAMPOSILL@");
			}
		}
		while( hayRepetidos( linea ) == true );
		
		String d;
		int n;
		for ( int i = 0 ; i < linea.length() ; i++ )
		{
			d = linea.substring(i,i+1);
			n = Integer.parseInt( d );
			secreto.add( n );
		}		
	}

	public Jugada leerJugada(int pCont) {
		
		System.out.println("Teclea intento " + (pCont+1) + " : ");
		
		return Juego.getJuego().getComputador().generarJugada();
	}
	
	public int getIntentos() {

		return intentos.size();
	}

}
