package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	private final static String NOME = "prendi";
	private IO io = new IOConsole();
	
	/**
	 * Prende un oggetto.
	 */
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Quale attrezzo vuoi raccogliere?");
		}
		else {
			Attrezzo attr=partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(attr == null) {
				io.mostraMessaggio("Attrezzo non presente");
			}
			else {
				if(partita.getGiocatore().getBorsa().addAttrezzo(attr)) {
					partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attr);
					io.mostraMessaggio("Hai preso "+ nomeAttrezzo );
				}else {
					io.mostraMessaggio("Non puoi prendere l'attrezzo!");
				}
			}
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
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
