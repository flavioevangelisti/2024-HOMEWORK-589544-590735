package it.uniroma3.diadia.giocatore;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;	
	private Map<String,Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoAttuale;
	
	public Borsa() {
			this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.pesoAttuale = 0;
		this.attrezzi = new HashMap<>();
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax() || attrezzo==null)
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.pesoAttuale += attrezzo.getPeso();
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		if (this.attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}
	
	public int getPeso() {
		return pesoAttuale;
		}
		public boolean isEmpty() {
			return this.attrezzi == null;
		}
		public boolean hasAttrezzo(String nomeAttrezzo) {
			return this.getAttrezzo(nomeAttrezzo)!=null;
		}
		
		public Attrezzo removeAttrezzo(String nomeAttrezzo) {
			if(nomeAttrezzo!=null && this.attrezzi.containsKey(nomeAttrezzo)) {
				return this.attrezzi.remove(nomeAttrezzo);
			}
			return null;
		}
	
		public List<Attrezzo> getContenutoOrdinatoPerPeso() {
			final List<Attrezzo> ordinata = new ArrayList<>();
			ordinata.addAll(this.attrezzi.values());
			final ComparatorePerPeso cmp = new ComparatorePerPeso();
			Collections.sort(ordinata,cmp);
			
			return ordinata;
		}
		
		public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
			final ComparatorePerPeso cmp = new ComparatorePerPeso();
			final SortedSet<Attrezzo> ordinata = new TreeSet<Attrezzo>(cmp);
			ordinata.addAll(this.attrezzi.values());
			return ordinata;
		}
	
		public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
			final SortedSet<Attrezzo> ordinata = new TreeSet<>(this.attrezzi.values());
			return ordinata;
		}
		
		public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
			final Map<Integer,Set<Attrezzo>> peso2attrezzi = new HashMap<>();
			for (Attrezzo attr: this.attrezzi.values()) {
				if(peso2attrezzi.containsKey(attr.getPeso())) {
					peso2attrezzi.get(attr.getPeso()).add(attr);
				}
				else {
					Set<Attrezzo> s = new TreeSet<>();
					s.add(attr);
					peso2attrezzi.put(attr.getPeso(), s);
				}
			}
			return peso2attrezzi;
		}
		
		public String toString() {
			StringBuilder s = new StringBuilder();
			if (!this.isEmpty()) {
				s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
				s.append(this.attrezzi.values().toString()+" ");
			}
			else
				s.append("Borsa vuota");
			return s.toString();
		}
}

