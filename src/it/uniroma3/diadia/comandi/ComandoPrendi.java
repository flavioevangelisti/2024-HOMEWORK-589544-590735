package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPrendi extends AbstractComando implements Comando {
	private final static String NOME = "prendi";
	
	/**
	 * Prende un oggetto.
	 */
	@Override
	public void esegui(Partita partita) {
		if(this.getParametro()==null) {
			this.getIo().mostraMessaggio("Quale attrezzo vuoi raccogliere?");
		}
		else {
			Attrezzo attr=partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.getParametro());
			if(attr == null) {
				this.getIo().mostraMessaggio("Attrezzo non presente");
			}
			else {
				if(partita.getGiocatore().getBorsa().addAttrezzo(attr)) {
					partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attr);
					this.getIo().mostraMessaggio("Hai preso "+ this.getParametro());
				}else {
					this.getIo().mostraMessaggio("Non puoi prendere l'attrezzo!");
				}
			}
		}
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
	
}
