package packMasterMind;

import java.util.ArrayList;

public class Jugada {

	private ArrayList<Integer> jugada;

	public Jugada()
	{
		jugada = new ArrayList<Integer>();
	}
	
	public void add(int n) 
	{
		jugada.add( n );		
	}

	public int size() {
		
		return jugada.size();
	}

	public int get(int i) {
		
		return jugada.get(i);
	}

	public void clear() {
	
		jugada.clear();		
	}
	
	public boolean equals( Object o )
	{
		return jugada.equals(o);
	}
	
	public String toString()
	{
		return jugada.toString();
	}
}
