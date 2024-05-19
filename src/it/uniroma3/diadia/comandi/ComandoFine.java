package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class ComandoFine implements Comando {
	private final static String NOME = "fine";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";
	private IO io = new IOConsole();
	/**
	 * Comando "Fine".
	 */
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(MESSAGGIO_FINE);  // si desidera smettere
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
