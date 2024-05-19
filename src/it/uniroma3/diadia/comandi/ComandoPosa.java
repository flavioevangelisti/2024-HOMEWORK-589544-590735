package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	private final static String NOME = "posa";
	private IO io = new IOConsole();

	/**
	 * Posa un oggetto.
	 */
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Quale attrezzo vuoi posare?");
		}
		else {
			Attrezzo attr= partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			if(attr == null) {
				io.mostraMessaggio("Attrezzo non presente");
			}
			else {
				if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(attr)) {
					partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
					io.mostraMessaggio("Hai posato "+ nomeAttrezzo );
				}else {
					io.mostraMessaggio("Non puoi posare l'attrezzo!");
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
