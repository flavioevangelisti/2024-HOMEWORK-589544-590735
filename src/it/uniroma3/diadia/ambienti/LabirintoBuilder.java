package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Map<String, Stanza> stanze;
	private Stanza ultima;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
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
	
	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, String direzione) {
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
	
	public LabirintoBuilder addStanzaMagica(String stanzaMagica) {
		Stanza magica = new StanzaMagica(stanzaMagica);
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
	
	public LabirintoBuilder addStanzaBloccata(String stanzaBloccata, String direzione, String attrezzoParticolare) {
		Stanza bloccata = new StanzaBloccata(stanzaBloccata, direzione, attrezzoParticolare);
		stanze.put(bloccata.getNome(), bloccata);
		ultima = bloccata;
		return this;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
}
