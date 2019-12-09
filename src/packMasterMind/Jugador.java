package packMasterMind;

import java.util.ArrayList;

public abstract class Jugador {

	protected ArrayList<Integer> secreto;
		
	public Jugador()
	{
		secreto = new ArrayList<Integer>();
	}
	
	public void mostrarSecreto()
	{
		for(int x : secreto )
			System.out.print( x );
		System.out.println();
	}
	
	public boolean comprobarJugada(Jugada pJugada)
	{
		int cifra;
		int m = 0;
		int h = 0;
		
		for(  int i = 0 ; i < pJugada.size() ; i++  )
		{
			cifra = pJugada.get(i);
			
			int p = secreto.indexOf( cifra );
			
			//Es muerto o herido
			if ( p != -1 )
			{
				//Muerto
				if( p == i )
				{
					m++;
				}
				else
				{
					h++;
				}				
			}			
		}
		
		System.out.println( h +"H " + m + "M" );
		
		if ( m ==4 )
			return true;
		else
			return false;
	}
	
	protected boolean comprobarEntrada( String pLinea )
	{
		if( pLinea.length() != 4 )
		{
			return false;
		}
		else
		{
			String cadctrl = "0123456789";			
			int i = 0;
			boolean parar = false;
			while( i < pLinea.length()  && !parar  )
			{
				String car = pLinea.substring(i,i+1);
				
				if( cadctrl.contains( car ) == false )
				{
					parar = true;
				}
				else
				{
					i++;
				}
			}
			
			return !parar;
		}
	}
	
	protected boolean hayRepetidos( String pLinea )
	{
		int i = 0;
		int j;
		boolean parar = false;
		String di, dj;
		while( i < pLinea.length() - 1 && !parar )
		{
			j = i + 1;
			while( j < pLinea.length() && !parar )
			{
				di = pLinea.substring( i , i+1 ); 
			    dj = pLinea.substring( j , j+1 );
				if( di.equals(dj) )
				{
					parar = true;
				}
				else
				{
					j++;
				}
			}
			
			if (!parar)
				i++;
		}
		
		return parar;
	}

	public void inicializar()
	{
		secreto.clear();		
	}
	
	public abstract void generarSecreto();
	public abstract Jugada leerJugada( int pCont );
}
