package it.uniroma3.diadia.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.Borsa;

public class TestBorsa {

	Borsa b = new Borsa();
	Attrezzo spada;
	Attrezzo scudo;
	
	@Before
	public void setUp() {
		spada = new Attrezzo("spada", 5);
		scudo = new Attrezzo("scudo", 11);
	}

	@Test
	public void testMinoreDiDieci() {
		assertTrue(b.addAttrezzo(spada));

	}
	
	@Test
	public void testMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(scudo));

	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(spada);
		assertEquals(spada, b.getAttrezzo("spada"));

	}
}
