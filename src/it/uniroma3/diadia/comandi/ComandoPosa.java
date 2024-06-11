package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPosa extends AbstractComando implements Comando {
	private final static String NOME = "posa";

	/**
	 * Posa un oggetto.
	 */
	@Override
	public void esegui(Partita partita) {
		if(this.getParametro()==null) {
			this.getIo().mostraMessaggio("Quale attrezzo vuoi posare?");
		}
		else {
			Attrezzo attr= partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
			if(attr == null) {
				this.getIo().mostraMessaggio("Attrezzo non presente");
			}
			else {
				if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(attr)) {
					partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
					this.getIo().mostraMessaggio("Hai posato "+ this.getParametro());
				}else {
					this.getIo().mostraMessaggio("Non puoi posare l'attrezzo!");
				}
			}
		}	
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
