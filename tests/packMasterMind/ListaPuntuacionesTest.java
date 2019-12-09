package packMasterMind;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListaPuntuacionesTest {

	@Test
	public void testListaPuntuaciones() {
		ListaPuntuaciones lp = null;
		
		assertNull(lp);
		
		lp = new ListaPuntuaciones();
		
		assertNotNull(lp);
	}

	@Test
	public void testAñadirPuntuacion() {
		ListaPuntuaciones lp = new ListaPuntuaciones();
		
		assertEquals(0,lp.getSize());
		
		lp.añadirPuntuacion("ANA", 100);
		
		assertEquals(1,lp.getSize());
		
	}

}
