package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;


public class ComandoVai extends AbstractComando implements Comando {
	private final static String NOME = "vai";
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.getParametro()== null) {
			this.getIo().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		}
		if(this.getParametro()!=null ) {
			try {
				prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
				} catch(IllegalArgumentException e) {
					this.getIo().mostraMessaggio("Direzione inesistente");
					return;
				}
				
				if (prossimaStanza == null) {
				this.getIo().mostraMessaggio("Direzione inesistente");
				return;
		}

		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		this.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1);
		}
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}