package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_MORSO = "Bau! Hai perso 1 CFU venendo morso, ora ne hai ";
	private static final String MESSAGGIO_REGALO = "Bau! E' il mio cibo preferito, ti lascio a terra il mio collare come ringraziamento!";
	private static final String CIBO_PREFERITO = "osso";
	
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		msg = MESSAGGIO_MORSO + partita.getGiocatore().getCfu();
		
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo ("collare", 2));
			return MESSAGGIO_REGALO;
		}
		else {
			String msg = MESSAGGIO_MORSO + partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			return msg;
		}
			
	}
}
