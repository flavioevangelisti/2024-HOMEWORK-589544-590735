package it.uniroma3.diadia.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	Attrezzo zappa;
	Map<Integer, Set<Attrezzo>> expected;
	
	@Before
	public void setUp() {
		b = new Borsa();
		b2 = new Borsa();
		spada = new Attrezzo("spada", 2);
		scudo = new Attrezzo("scudo", 11);
		ascia = new Attrezzo("ascia", 2);
		zappa = new Attrezzo("zappa", 3);
		expected = new HashMap<>();
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
	public void testGetSortedSetOrdinatoPerPeso() {
		List<Attrezzo> lista = new ArrayList<>();
		lista.add(ascia);
		lista.add(spada);
		lista.add(scudo);
		SortedSet<Attrezzo> ordinata = new TreeSet<Attrezzo>(new Comparator<Attrezzo>() {
			@Override
			public int compare (Attrezzo obj1, Attrezzo obj2) {
				if(obj1.getPeso() - obj2.getPeso() == 0) {
					return obj1.getNome().compareTo(obj2.getNome());
				}
				return obj1.getPeso() - obj2.getPeso();
			}
		});	
		ordinata.add(scudo);
		ordinata.add(ascia);
		ordinata.add(spada);
		Iterator<Attrezzo> i1 = lista.iterator();
		Iterator<Attrezzo> i2 = ordinata.iterator();
		while(i1.hasNext() && i2.hasNext()) {
			assertEquals(i1.next(), i2.next());
		}
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		List<Attrezzo> lista = new ArrayList<>();
		lista.add(ascia);
		lista.add(scudo);
		lista.add(spada);
		SortedSet<Attrezzo> ordinata = new TreeSet<Attrezzo>(new Comparator<Attrezzo>() {
			@Override
			public int compare(Attrezzo o1, Attrezzo o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		ordinata.add(scudo);
		ordinata.add(ascia);
		ordinata.add(spada);
		Iterator<Attrezzo> i1 = lista.iterator();
		Iterator<Attrezzo> i2 = ordinata.iterator();
		while(i1.hasNext() && i2.hasNext()) {
			assertEquals(i1.next(), i2.next());
		}
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Set<Attrezzo> s = new HashSet<>();
		s.add(ascia);
		s.add(spada);
		expected.put(2, s);
		expected.put(3, Collections.singleton(zappa));
		b.addAttrezzo(zappa);
		b.addAttrezzo(ascia);
		b.addAttrezzo(spada);
		assertEquals(expected, this.b.getContenutoRaggruppatoPerPeso());
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
	
	public boolean scorriSet(Set<Attrezzo> s1, Set<Attrezzo> s2) {
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
