package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando implements Comando {
	private static final String MESSAGGIO_CON_CHI = "Chi dovrei salutare?...";
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.setParametro(personaggio.saluta());
			this.getIo().mostraMessaggio(this.getParametro());

		} else 
			this.getIo().mostraMessaggio(MESSAGGIO_CON_CHI);
	}
}
