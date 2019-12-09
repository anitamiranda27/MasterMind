package packMasterMind;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Juego 
{
	private Humano h;
	private Computador c;		
	private ListaPuntuaciones p;
	
	private static Juego miJuego;
	
	public Computador getComputador()
	{
		return c;
	}	
	
	private Juego()
	{
		h = new Humano();
		c = new Computador();
		p = new ListaPuntuaciones();
	}
	
	public static Juego getJuego()
	{
		if ( miJuego == null )
		{
			miJuego = new Juego();
		}
		
		return miJuego;
	}
		
	private void jugar1()
	{
		System.out.println("Teclea nombre del jugador: ");
		@SuppressWarnings("resource")
		String nombre = new Scanner( System.in ).nextLine();
				
		c.generarSecreto();
				
		int cont = 0;
		boolean fin = false;
		
		while( cont < 10 && fin == false )
		{
		
			Jugada j = c.leerJugada( cont );
			
			if ( h.intentoRepetido( j ) )
			{
				System.out.println("Ese intento está REPE =D");
				cont--;
			}
			else
			{
				h.añadirIntento( j );
			}
			
			cont++;
			
			fin = c.comprobarJugada( j );
		}				
		
		if ( fin == false )
		{	
			System.out.println("FALLASTE EL NUMERO SECRETO ERA: ");
			c.mostrarSecreto();
		}
		else
		{
			System.out.println("ERES UN MASTERMIND");
		}
		
		int intentos = h.getIntentos();
		int puntos = 0;
		if (intentos == 10){
			puntos = 0;
		}
		else
		{
			puntos = 110 - h.getIntentos() * 10;
		}
				
		p.añadirPuntuacion( nombre , puntos );
	}
	
	
	public void menu()
	{		
		String linea;
		do
		{		
			inicializar();	
			
			System.out.println("--------------------------------------------------------");
			System.out.println("M   M  AAA   SSS  TTTTTT EEEE RRRR  M   M III N   N DDD");
			System.out.println("MM MM A   A S       TT   E    R   R MM MM  I  NN  N D  D"); 
			System.out.println("M M M AAAAA  SSS    TT   EEE  RRRR  M M M  I  N N N D  D"); 
			System.out.println("M   M A   A     S   TT   E    R R   M   M  I  N  NN D  D"); 
			System.out.println("M   M A   A SSSS    TT   EEEE R  RR M   M III N   N DDD");
			System.out.println("--------------------------------------------------------");
			System.out.println("OPCIONES:");
			System.out.println("1. Humano vs Computadora");
			System.out.println("2. Computadora vs Humano");
			System.out.println("3. Puntuaciones de jugadores");
			System.out.println("4. SALIR");
			System.out.print("Opcion: ");
			
			@SuppressWarnings("resource")
			Scanner entrada = new Scanner( System.in );
		
			linea = entrada.nextLine();
			
			if( linea.substring(0,1).equals("1") )
			{
				jugar1();								
			}
			else if( linea.substring(0,1).equals("2") )
			{
				//jugar2();
				System.out.println("Proximamente...");
			}
			else if( linea.substring(0,1).equals("3") )
			{
				p.mostrarPuntuaciones();
			}	
			else
			{
				linea.equals("N");
			}
		
			System.out.println("¿OTRA PARTIDITA? (S/N)");
			
			linea = entrada.nextLine().toUpperCase();
		}
		while( linea.equals("S") );	
	}
	
	private void inicializar()
	{
		c.inicializar();
		h.inicializar();
	}
	
	public static void main ( String args[] ) throws ClassNotFoundException, IOException 
	{		
		//getJuego().cargarPuntuaciones();
		getJuego().menu();
		getJuego().guardarPuntuaciones();
	}

	private void guardarPuntuaciones() throws IOException {
		
		File f = new File("Puntuaciones.dat");
		FileOutputStream fos = new FileOutputStream(f , false );
		ObjectOutputStream oos = new ObjectOutputStream( fos );
		
		oos.writeObject( p );
		
		oos.close();
	}

	private void cargarPuntuaciones() throws IOException, ClassNotFoundException{
		
		File f = new File("Puntuaciones.dat");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		p = (ListaPuntuaciones) ois.readObject();
		
		ois.close();		
	}	
	
	/*private void jugar2()
	{
		h.generarSecreto();
		
		int cont = 0;
		boolean fin = false;
		
		while( cont < 10 && fin == false )
		{
			Jugada j = h.leerJugada( cont );
			
			System.out.println( j );
			
			cont++;
			
			fin = h.comprobarJugada( j );
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}				
		
		if ( fin == false )
		{	
			System.out.println("EL NUMERO SECRETO ERA: ");
			h.mostrarSecreto();
		}
		else
		{
			System.out.println("ERES UNA MAQUINA BIEN PROGRAMADA");
		}
	}
	*/		
}
