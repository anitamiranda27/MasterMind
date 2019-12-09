package packMasterMind;

import static org.junit.Assert.*;

import org.junit.Test;

public class PuntuacionTest {

	@Test
	public void testPuntuacion() {
		Puntuacion p = null;
		
		assertNull (p);
		
		p = new Puntuacion("Ana", 100);
		
		assertNotNull(p);
	}
	
}
