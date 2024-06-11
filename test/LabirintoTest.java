package it.uniroma3.diadia.test;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.*;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	Labirinto lab;
	Stanza biblioteca;
	Stanza DS1;

	@Before
	
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		lab = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
	}


	@Test
	
	public void testGetStanzaVincente() {
		assertEquals("N11", lab.getStanzaVincente().getNome());
	}


	@Test
	
	public void testSetStanzaCorrente() {
		lab.setStanzaCorrente(DS1);
		assertEquals(DS1, lab.getStanzaCorrente());
	}
	@Test
	
	public void testGetStanzaCorrente() {
		assertEquals("N10", lab.getStanzaCorrente().getNome());
	}

}
