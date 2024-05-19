package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class ComandoGuarda implements Comando {
	private final static String NOME = "guarda";
	private IO io = new IOConsole();
	/**
	 * Stampa la stanza corrente e lo stato della partita.
	 */
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Hai: "+partita.getGiocatore().getCfu()+ "CFU");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
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
