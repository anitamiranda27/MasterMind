package packMasterMind;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputadorTest {

	@Test
	public void testComputador() {
		
		Jugador j =  null;
		
		assertNull(j);
				
		j = new Computador();
		
		assertNotNull( j );				
		
	}
}
