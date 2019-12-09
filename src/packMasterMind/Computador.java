package packMasterMind;

import java.util.ArrayList;
import java.util.Scanner;

public class Computador extends Jugador
{
	private ArrayList<Integer> posibles;
	
	private Jugada jugadaAnterior;
	
	public void inicializar()
	{
		super.inicializar();
		jugadaAnterior.clear();	
	}
	
	public Computador()
	{
		super();

		jugadaAnterior = new Jugada();
		
		posibles = new ArrayList<Integer>();
		
		
		for( int i = 0 ; i <= 9 ; i++ )
			posibles.add( i );
	}
		
	public void generarSecreto()
	{		
		int numero;
		
		do
		{
			numero = (int) (Math.random()*10);			
			
			if ( !secreto.contains( numero ) )
			{
				secreto.add( numero );
			}
		}
		while( secreto.size() != 4 );	
		
	}
	
	
	public Jugada leerJugada(int pCont )
	{
		Jugada intento = new Jugada();
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner( System.in );
		
		String linea;
		
		do
		{
			do
			{
				System.out.println("Teclea intento " + (pCont+1) + " : ");
					
				linea = entrada.nextLine();
				
				if ( comprobarEntrada( linea ) == false )
				{
					System.err.println("INTENTO ERRONEO!!!");
				}
			}
			while( comprobarEntrada( linea ) == false );
			
			if ( hayRepetidos( linea ) )
			{
				System.err.println("NO PUEDES TECLEAR REPETIDOS, TRAMPOS@");
			}
		}
		while( hayRepetidos( linea ) == true );
				
		String d;
		int n;
		for ( int i = 0 ; i < linea.length() ; i++ )
		{
			d = linea.substring(i,i+1);
			n = Integer.parseInt( d );
			intento.add( n );
		}		
		
		return intento;
	}
		
	public Jugada generarJugada() 
	{
		return null;
	}	
}



