package it.uniroma3.diadia;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole con;

	public DiaDia(IOConsole console) {
		this.partita = new Partita();
		this.con = console;
	}

	public void gioca() {
		String istruzione;
		con.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = con.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			con.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			con.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			con.mostraMessaggio(elencoComandi[i]+" ");
		con.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			con.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			con.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		con.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	
	private void prendi(String nomeAttrezzo) {
		Attrezzo a=this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		this.partita.getGiocatore().getBorsa().addAttrezzo(a);
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
	}
	
	private void posa(String nomeAttrezzo) {
		Attrezzo attr=this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attr);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		
	}	

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		con.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console= new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}