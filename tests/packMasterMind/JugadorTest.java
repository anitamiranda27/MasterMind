package packMasterMind;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugadorTest {

	@Test
	public void testJugador() {

		Jugador j = null;
		
		assertNull( j );
		
		j = new Humano();
		
		assertNotNull( j );
						
		Jugador j2 = null;
		
		assertNull( j2 );
		
		j2 = new Computador();
		
		assertNotNull( j2 );
	}

	@Test
	public void testMostrarSecreto() {
		
		Jugador j1 = new Humano();
		Jugador j2 = new Computador();
		
		assertEquals(0, j1.secreto.size() );
		assertEquals(0, j2.secreto.size() );
		
		try
		{
			j1.mostrarSecreto();
			j2.mostrarSecreto();
		}
		catch(NullPointerException e )
		{
			fail("No deberia ejecutarse esto");
		}
	}

	@Test
	public void testComprobarJugada() {
		
		Jugador j1 = new Humano();
		
		j1.secreto.add(1);
		j1.secreto.add(2);
		j1.secreto.add(3);
		j1.secreto.add(4);
		
		Jugada jug = new Jugada();
		
		jug.add(1);
		jug.add(2);
		jug.add(3);
		jug.add(4);	
		
		assertEquals( true , j1.comprobarJugada( jug ) );
		
		
		Jugador j2 = new Humano();
		
		j2.secreto.add(1);
		j2.secreto.add(2);
		j2.secreto.add(3);
		j2.secreto.add(5);
		
		Jugada jug2 = new Jugada();
		
		jug2.add(1);
		jug2.add(2);
		jug2.add(3);
		jug2.add(4);	
		
		assertEquals( false , j2.comprobarJugada( jug2 ) );
	}

	@Test
	public void testComprobarEntrada() {
		
		Jugador j = new Humano();
		
		String linea = "1234";
		
		assertTrue(j.comprobarEntrada(linea));
		
		Jugador j2 = new Humano();
		
		String linea2 = "123";
		
		assertFalse( j2.comprobarEntrada(linea2) );
		
		Jugador j3 = new Humano();
		
		String linea3 = "123@";
		
		assertFalse( j3.comprobarEntrada(linea3) );
	}

	@Test
	public void testHayRepetidos() {
		
		Jugador j = new Humano();
		
		String linea = "1234";
		
		assertFalse(j.hayRepetidos(linea));
		
		Jugador j2 = new Humano();
		
		String linea2 = "1231";
		
		assertTrue( j2.hayRepetidos(linea2) );	
		
		Jugador j1 = new Computador();
		
		j1.generarSecreto();
		
		assertEquals( 4, j1.secreto.size() );
		
	}

	@Test
	public void testInicializar() {
				
		Jugador j1 = new Humano();
		
		j1.secreto.add(1);
		j1.secreto.add(2);
		j1.secreto.add(3);
		j1.secreto.add(4);
		
		assertEquals( 4 , j1.secreto.size() );		
		
		j1.inicializar();
		
		assertEquals( 0 , j1.secreto.size() );
	}

	@Test
	public void testGenerarSecreto() {
	
		Jugador j1 = new Computador();
		
		j1.generarSecreto();
		
		assertNotEquals( 0, j1.secreto );
		
	}

}
