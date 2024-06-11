package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando implements Comando {
	private final static String NOME = "non valido";
	/**
	 * Avverte di un errore.
	 */
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Comando non valido! Inseriscine un altro.");
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
	
}
