package packMasterMind;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugadaTest {

	@Test
	public void testJugada() {
		Jugada j = null;
		
		assertNull(j);
		
		j = new Jugada();
		
		assertNotNull(j);
	}

	@Test
	public void testAdd() {
		Jugada j =  new Jugada();
		
		assertEquals(0,j.size());
		
		j.add(1);
		
		assertEquals(1,j.size());
	}

	@Test
	public void testSize() {
		Jugada j = new Jugada();
		
		assertEquals(0,j.size());
		
		j.add(1);
		
		assertEquals(1,j.size());
	}

	@Test
	public void testGet() {
		Jugada j = new Jugada();
		
		j.add(2);
		j.add(3);
		j.add(1);
		j.add(4);
		
		assertEquals(1,j.get(2));
		assertEquals(2,j.get(0));
	}

	@Test
	public void testClear() {
		Jugada j = new Jugada();
		
		j.add(1);
		
		assertEquals(1,j.size());
		
		j.clear();
		
		assertEquals(0,j.size());
	}

	@Test
	public void testEqualsObject() {
		
		Jugada jj = new Jugada();
		jj.add(1);
		jj.add(2);
		jj.add(3);
		jj.add(5);
				
		assertFalse( jj.equals(jj) );
		
	}

}
