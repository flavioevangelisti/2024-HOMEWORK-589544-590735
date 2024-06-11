package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando implements Comando {
	private final static String NOME = "aiuto";
	
	static final public String[] ELENCO_COMANDI = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "saluta","interagisci","regala"};

	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			this.getIo().mostraMessaggio(ELENCO_COMANDI[i]+" ");
		this.getIo().mostraMessaggio("");
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
