package packMasterMind;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuegoTest {

	@Test
	public void testGetComputador() {
		Juego miJuego = Juego.getJuego();
		
		Computador c = null;
		
		assertNull(c);
		
		c = miJuego.getComputador();
		
		assertNotNull(c);
	}

	@Test
	public void testGetJuego() {
		Juego miJuego = null;
		
		assertNull(miJuego);
		
		miJuego = Juego.getJuego();
		
		assertNotNull(miJuego);
	}

	
}
