package it.uniroma3.diadia.ambienti;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {
	 /**
     * Crea tutte le stanze e le porte di collegamento
     */
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private List<Direzione> direzioni; 
	
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaCorrente = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	
//    public void creaStanze() {
//
//		/* crea gli attrezzi */
//    	Attrezzo lanterna = new Attrezzo("lanterna",3);
//		Attrezzo osso = new Attrezzo("osso",1);
//    	
//		/* crea stanze del labirinto */
//		Stanza atrio = new Stanza("Atrio");
//		Stanza aulaN11 = new Stanza("Aula N11");
//		Stanza aulaN10 = new Stanza("Aula N10");
//		Stanza laboratorio = new Stanza("Laboratorio Campus");
//		Stanza biblioteca = new Stanza("Biblioteca");
//		
//		/* collega le stanze */
//		atrio.impostaStanzaAdiacente("nord", biblioteca);
//		atrio.impostaStanzaAdiacente("est", aulaN11);
//		atrio.impostaStanzaAdiacente("sud", aulaN10);
//		atrio.impostaStanzaAdiacente("ovest", laboratorio);
//		aulaN11.impostaStanzaAdiacente("est", laboratorio);
//		aulaN11.impostaStanzaAdiacente("ovest", atrio);
//		aulaN10.impostaStanzaAdiacente("nord", atrio);
//		aulaN10.impostaStanzaAdiacente("est", aulaN11);
//		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
//		laboratorio.impostaStanzaAdiacente("est", atrio);
//		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
//		biblioteca.impostaStanzaAdiacente("sud", atrio);
//
//        /* pone gli attrezzi nelle stanze */
//		aulaN10.addAttrezzo(lanterna);
//		atrio.addAttrezzo(osso);
//
//		// il gioco comincia nell'atrio
//        this.stanzaCorrente = atrio;  
//		stanzaVincente = biblioteca;
//    }
    
    public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public List<Direzione> getDirezioni() {
		return direzioni;
	}

	public void setDirezioni(List<Direzione> direzioni) {
		this.direzioni = direzioni;
	}
	
	
	
	public static class LabirintoBuilder {
		
		private Labirinto labirinto;
		private Map<String, Stanza> stanze;
		private Stanza ultima;

		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(labirinto);
			this.stanze = new HashMap<String, Stanza>();
		}
		
		public LabirintoBuilder addStanza (String stanza) {
			Stanza s = new Stanza(stanza);
			stanze.put(s.getNome(), s);
			ultima = s;
			return this;
		}
		
		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
			Stanza iniziale = new Stanza(stanzaIniziale);
			labirinto.setStanzaCorrente(iniziale);
			stanze.put(iniziale.getNome(), iniziale);
			ultima = iniziale;
			return this;
		}
		
		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza vincente = new Stanza(stanzaVincente);
			labirinto.setStanzaVincente(vincente);
			stanze.put(vincente.getNome(), vincente);
			ultima = vincente;
			return this;
		}
		
		public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, Direzione direzione) {
			Stanza corrente = stanze.get(stanzaCorrente);
			Stanza adiacente = stanze.get(stanzaAdiacente);
			corrente.impostaStanzaAdiacente(direzione, adiacente);
			return this;
		}
		
		public LabirintoBuilder addAttrezzo(String nome, int peso) {
			Attrezzo a = new Attrezzo(nome, peso);
			ultima.addAttrezzo(a);
			return this;
		}
		
		public LabirintoBuilder addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if(ultima == null) {
				return this;
			}
			this.ultima.setPersonaggio(m);
			return this;
		}
		
		public LabirintoBuilder addCane(String nome, String presentazione) {
			Cane c = new Cane(nome, presentazione);
			if(ultima == null) {
				return this;
			}
			this.ultima.setPersonaggio(c);
			return this;
		}
		
		public LabirintoBuilder addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if(ultima == null) {
				return this;
			}
			this.ultima.setPersonaggio(s);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String stanzaMagica, int soglia) {
			Stanza magica = new StanzaMagica(stanzaMagica, soglia);
			stanze.put(magica.getNome(), magica);
			ultima = magica;
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String stanzaBuia, String attrezzoParticolare) {
			Stanza buia = new StanzaBuia(stanzaBuia, attrezzoParticolare);
			stanze.put(buia.getNome(), buia);
			ultima = buia;
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String stanzaBloccata, Direzione direzione, String attrezzoParticolare) {
			Stanza bloccata = new StanzaBloccata(stanzaBloccata, direzione, attrezzoParticolare);
			stanze.put(bloccata.getNome(), bloccata);
			ultima = bloccata;
			return this;
		}

		public Map<String, Stanza> getStanze() {
			return stanze;
		}

		public void setStanze(Map<String, Stanza> stanze) {
			this.stanze = stanze;
		}
		
		public Labirinto getLabirinto() {
			return this.labirinto;
		}	
	}
	
	
}
