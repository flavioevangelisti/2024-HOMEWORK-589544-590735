package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

public class IOSimulatorTest {
	
	public List<String> righeDaLeggere;
	public List<String> righeDaLeggere2;
	
	@Before
	public void setUp() throws Exception {
		righeDaLeggere = new ArrayList<>();
		righeDaLeggere2 = new ArrayList<>();
	}
	
	@Test
	public void testPartitaConComandoVai() throws Exception {
		righeDaLeggere.add("vai nord");

		IOSimulator io = Fixture.simulazionePartitaFacile(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Biblioteca", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Hai vinto!", io.nextMessaggio());
		
	}
	
//	@Test
//	public void testPartitaConComandoVaiOvest() throws Exception {
//		righeDaLeggere2.add("vai ovest");
//		righeDaLeggere2.add("fine");
//
//		IOSimulator io = Fixture.simulazionePartitaDifficile(righeDaLeggere2);
//		assertTrue(io.hasNextMessaggio());
//		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
//		assertTrue(io.hasNextMessaggio());
//		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
//	}
//	
//	@Test
//	public void testPartitaConComandoVaiOvestEst() {
//		righeDaLeggere2.add("vai ovest");
//		righeDaLeggere2.add("vai est");
//		righeDaLeggere2.add("fine");
//
//		IOSimulator io = Fixture.simulazionePartitaDifficile(righeDaLeggere2);
//		assertTrue(io.hasNextMessaggio());
//		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
//		assertTrue(io.hasNextMessaggio());
//		assertEquals("Aula N10", io.nextMessaggio());
//		assertTrue(io.hasNextMessaggio());
//		assertEquals("Atrio", io.nextMessaggio());
//		assertTrue(io.hasNextMessaggio());
//		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
//	}
}
