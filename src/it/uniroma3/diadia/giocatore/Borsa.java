package it.uniroma3.diadia.giocatore;

import java.util.*;

import it.uniroma3.diadia.Configuratore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = Configuratore.getPesoMax();	
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
				this.pesoAttuale = pesoAttuale - this.attrezzi.get(nomeAttrezzo).getPeso();
				return this.attrezzi.remove(nomeAttrezzo);
			}
			return null;
		}
	
		public List<Attrezzo> getContenutoOrdinatoPerPeso() {
			final List<Attrezzo> ordinata = new ArrayList<>();
			ordinata.addAll(this.attrezzi.values());
			Collections.sort(ordinata,new Comparator<Attrezzo>() {
				@Override
				public int compare (Attrezzo obj1, Attrezzo obj2) {
					if(obj1.getPeso() - obj2.getPeso() == 0) {
						return obj1.getNome().compareTo(obj2.getNome());
					}
					return obj1.getPeso() - obj2.getPeso();
				}
			});	
			return ordinata;
		}
		
		public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
			final SortedSet<Attrezzo> ordinata = new TreeSet<Attrezzo>(new Comparator<Attrezzo>() {
				@Override
				public int compare (Attrezzo obj1, Attrezzo obj2) {
					if(obj1.getPeso() - obj2.getPeso() == 0) {
						return obj1.getNome().compareTo(obj2.getNome());
					}
					return obj1.getPeso() - obj2.getPeso();
				}
			});
			ordinata.addAll(this.attrezzi.values());
			return ordinata;
		}
	
		public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
			final SortedSet<Attrezzo> ordinata = new TreeSet<>(new Comparator<Attrezzo>() {
				@Override
				public int compare(Attrezzo o1, Attrezzo o2) {
					return o1.getNome().compareTo(o2.getNome());
				}
			});
					
			ordinata.addAll(this.attrezzi.values());
			return ordinata;
		}
		
		public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
			final Map<Integer,Set<Attrezzo>> peso2attrezzi = new HashMap<>();
			for (Attrezzo attr: this.attrezzi.values()) {
				if(peso2attrezzi.containsKey(attr.getPeso())) {
					peso2attrezzi.get(attr.getPeso()).add(attr);
				}
				else {
					Set<Attrezzo> s = new HashSet<>();
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

