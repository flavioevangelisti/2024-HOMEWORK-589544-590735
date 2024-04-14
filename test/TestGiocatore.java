package it.uniroma3.diadia.test;
import it.uniroma3.diadia.giocatore.Giocatore;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGiocatore {
	
	Giocatore g = new Giocatore();
	
	@Test
	
	public void testGetCfuDefault() {
		assertEquals(20, g.getCfu());
	}
	
	@Test
	
	public void testSetCfu() {
		g.setCfu(5);
		assertEquals(5, g.getCfu());
	}

	@Test
	
	public void testGetBorsaDefault() {
		assertNotNull(g.getBorsa());
	}
}
