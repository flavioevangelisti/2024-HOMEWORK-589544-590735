package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando implements Comando {
	private static final String MESSAGGIO_CON_CHI = "Non c'è nessuno...";
	private static final String MESSAGGIO_CHE_COSA = "Non hai l'oggetto in borsa...";
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio!=null && attrezzo!=null) {
			this.setParametro(personaggio.riceviRegalo(attrezzo, partita));
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			this.getIo().mostraMessaggio(this.getParametro());

		} else if(personaggio==null)
			this.getIo().mostraMessaggio(MESSAGGIO_CON_CHI);
		else
			this.getIo().mostraMessaggio(MESSAGGIO_CHE_COSA);
	}
}
