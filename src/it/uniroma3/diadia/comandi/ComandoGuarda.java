package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando implements Comando {
	private final static String NOME = "guarda";
	/**
	 * Stampa la stanza corrente e lo stato della partita.
	 */
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		this.getIo().mostraMessaggio("Hai: "+partita.getGiocatore().getCfu()+ "CFU");
		this.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
	
}
