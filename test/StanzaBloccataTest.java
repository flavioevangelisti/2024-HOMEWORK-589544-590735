package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaBloccataTest {

	private StanzaBloccata sb;
	private Stanza s;
	private Attrezzo a;
	
	@Before
	public void setUp() throws Exception {
		sb = new StanzaBloccata("StanzaBloccata", "ovest", "grimaldello");
		s = new Stanza("Stanzetta");
		a = new Attrezzo("grimaldello", 1);
		sb.impostaStanzaAdiacente("ovest", s);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(sb, sb.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(s, sb.getStanzaAdiacente("ovest"));
		
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(), sb.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String e = "Questa stanza è bloccata nella direzione ovest"+"\nPer sbloccarla prendi e posa qui grimaldello";
		assertEquals(e, sb.getDescrizione());
		
	}
}
