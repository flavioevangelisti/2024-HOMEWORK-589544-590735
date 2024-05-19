package it.uniroma3.diadia.test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	Borsa b;
	Borsa b2;
	Attrezzo spada;
	Attrezzo scudo;
	Attrezzo ascia;
	ComparatorePerPeso cmp;
	
	@Before
	public void setUp() {
		b = new Borsa();
		b2 = new Borsa();
		spada = new Attrezzo("spada", 5);
		scudo = new Attrezzo("scudo", 11);
		ascia = new Attrezzo("ascia", 5);
		cmp = new ComparatorePerPeso();
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
	
	@Test
	public void testGetContenutoOrdinatoPerPesoDiverso() {
		b.addAttrezzo(scudo);
		b.addAttrezzo(spada);
		List<Attrezzo> ordinata = new ArrayList<>();
		ordinata.add(spada);
		ordinata.add(scudo);
		assertTrue(scorriList(ordinata, b.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoUguale() {
		b.addAttrezzo(spada);
		b.addAttrezzo(ascia);
		List<Attrezzo> ordinata = new ArrayList<>();
		ordinata.add(ascia);
		ordinata.add(spada);
		assertTrue(scorriList(ordinata, b.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoDiverso() {
		b.addAttrezzo(scudo);
		b.addAttrezzo(spada);
		SortedSet<Attrezzo> ordinata = new TreeSet<Attrezzo>(cmp);
		ordinata.add(spada);
		ordinata.add(scudo);
		assertArrayEquals(ordinata.toArray(), b.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	public boolean scorriList(List<Attrezzo> l1, List<Attrezzo> l2) {
		Iterator<Attrezzo> i1 = l1.iterator();
		Iterator<Attrezzo> i2 = l2.iterator();
		while(i1.hasNext() && i2.hasNext()) {
			if(i1.next().equals(i2.next())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean scorriSet(SortedSet<Attrezzo> s1, SortedSet<Attrezzo> s2) {
		Iterator<Attrezzo> i1 = s1.iterator();
		Iterator<Attrezzo> i2 = s2.iterator();
		while(i1.hasNext() && i2.hasNext()) {
			if(i1.next().equals(i2.next())) {
				return true;
			}
		}
		return false;
	}
	
}
