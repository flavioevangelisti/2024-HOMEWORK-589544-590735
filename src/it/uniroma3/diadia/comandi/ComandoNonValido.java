package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoNonValido implements Comando {
	private final static String NOME = "non valido";
	private IO io;
	/**
	 * Avverte di un errore.
	 */
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando non valido! Inseriscine un altro.");
	}
	
	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public String getParametro() {
		return null;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}
