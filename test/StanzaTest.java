package it.uniroma3.diadia.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaTest {

	Stanza s1 = new Stanza("s1");
	Stanza s2= new Stanza("s2");
	Attrezzo a = new Attrezzo("spada", 11);
	@Test
	
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("est"));
	}
	

	@Test
	
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente("est", s2);
		assertEquals(s2, s1.getStanzaAdiacente("est"));
	}
	
	@Test
	
	public void testAddAttrezzo() {
		
		assertTrue(s1.addAttrezzo(a));
	}
	
}
