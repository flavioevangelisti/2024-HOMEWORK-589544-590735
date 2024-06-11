package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	private Partita p;
	Labirinto labirinto;
	Labirinto labirinto2;
	private IO io;

	@Before
	public void setUp() throws Exception {
		io = new IOConsole(new Scanner(System.in));
		s1 = new Stanza("aula 1");
		s2 = new Stanza("aula 2");
		vai = new ComandoVai();
		 labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		p = new Partita(labirinto);
		vai.setIo(io);

	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testVaiNull() {
		p.getLabirinto().setStanzaCorrente(s1);
		vai.esegui(p);
		assertEquals(s1, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneEsistente() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente(Direzione.sud, s2);
		vai.setParametro("sud");
		vai.esegui(p);
		assertEquals(s2, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneInesistente() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente(Direzione.sud, s2);
		vai.setParametro("nord");
		vai.esegui(p);
		assertNotEquals(s2, p.getLabirinto().getStanzaCorrente());
	}

}
