package packMasterMind;

import static org.junit.Assert.*;

import org.junit.Test;

public class HumanoTest {

	
	@Test
	public void testAñadirIntento() {

		Humano j = new Humano();
		
		Jugada jj = new Jugada();
		jj.add(1);
		jj.add(2);
		jj.add(3);
		jj.add(4);
		j.añadirIntento( jj );
		
		Jugada jj2 = new Jugada();
		jj2.add(1);
		jj2.add(2);
		jj2.add(3);
		jj2.add(4);
		
		assertTrue( j.intentoRepetido( jj2) );
		
	}

	@Test
	public void testIntentoRepetido() {
		
		Humano j = new Humano();
		
		Jugada jj = new Jugada();
		jj.add(1);
		jj.add(2);
		jj.add(3);
		jj.add(4);
		j.añadirIntento( jj );
		
		Jugada jj2 = new Jugada();
		jj2.add(1);
		jj2.add(2);
		jj2.add(3);
		jj2.add(4);
		
		assertTrue( j.intentoRepetido( jj2) );
		
		Jugada jj3 = new Jugada();
		jj3.add(1);
		jj3.add(2);
		jj3.add(3);
		jj3.add(5);
		
		assertFalse( j.intentoRepetido( jj3) );		
	}

	@Test
	public void testGetIntentos() {
		
		Humano h = new Humano();
		
		assertEquals( 0 , h.getIntentos() );
		
		Jugada jj = new Jugada();
		jj.add(1);
		jj.add(2);
		jj.add(3);
		jj.add(4);
		
		h.añadirIntento( jj );
		
		assertEquals( 1 , h.getIntentos() );
		
	}

}
