package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_BUONO = "Ti sei comportato bene, ti mando in un bel posto!";
	private static final String MESSAGGIO_CATTIVO = "Sei un vero maleducato, ora ti faccio un dispetto!";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if(this.haSalutato) {
			partita.getLabirinto().setStanzaCorrente(this.stanzaMassima(partita));
			msg = MESSAGGIO_BUONO;
		}
		else {
			partita.getLabirinto().setStanzaCorrente(this.stanzaMinima(partita));
			msg = MESSAGGIO_CATTIVO;
		}
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "Grazie per l'attrezzo, AHAHAHAHAH!";
	}
	
	public Stanza stanzaMassima(Partita partita) {
		List<Stanza> stanze = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
		Stanza maxAttrezzi = stanze.get(0);
		for(Stanza s: stanze) {
			if(s.numeroAttrezzi() > maxAttrezzi.numeroAttrezzi())
				maxAttrezzi = s;
		}
		return maxAttrezzi;
	}
	
	public Stanza stanzaMinima(Partita partita) {
		List<Stanza> stanze = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
		Stanza minAttrezzi = stanze.get(0);
		for(Stanza s: stanze) {
			if(s.numeroAttrezzi() < minAttrezzi.numeroAttrezzi())
				minAttrezzi = s;
		}
		return minAttrezzi;
	}

}
