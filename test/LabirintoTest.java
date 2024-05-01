package it.uniroma3.diadia.test;
import it.uniroma3.diadia.ambienti.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	Labirinto lab;
	Stanza biblioteca;
	Stanza s;

	@Before
	
	public void setUp() {
		lab = new Labirinto();
		lab.creaStanze();
		biblioteca = new Stanza("Biblioteca");
		s = new Stanza("s");
	}


	@Test
	
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", lab.getStanzaVincente().getNome());
	}


	@Test
	
	public void testSetStanzaCorrente() {
		lab.setStanzaCorrente(s);
		assertEquals(s, lab.getStanzaCorrente());
	}
	@Test
	
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", lab.getStanzaCorrente().getNome());
	}

}
