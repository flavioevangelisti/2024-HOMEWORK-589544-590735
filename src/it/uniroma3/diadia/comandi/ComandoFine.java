package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando implements Comando {
	private final static String NOME = "fine";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";
	/**
	 * Comando "Fine".
	 */
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(MESSAGGIO_FINE);  // si desidera smettere
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
	
}
