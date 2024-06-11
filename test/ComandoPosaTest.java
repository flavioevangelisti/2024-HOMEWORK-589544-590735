package it.uniroma3.diadia.test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.*;


public class ComandoPosaTest {
	
	private Partita partita;
	private Attrezzo attrezzo;
	private IO io;
	private Comando comando;
	Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("martello", 2);
		comando = new ComandoPosa();
		io = new IOConsole(new Scanner(System.in));
		comando.setIo(io);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
	}

	@Test
	public void testAttrezzoPosatoNull() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
	}

}
