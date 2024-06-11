package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private Direzione direzioneBloccata;
	private String oggettoParticolare;
	
	
	public StanzaBloccata(String nome, Direzione direzione, String oggetto) {
		super(nome);
		this.direzioneBloccata= direzione;
		this.oggettoParticolare= oggetto;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(oggettoParticolare)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String blocco= "Questa stanza è bloccata nella direzione " + direzioneBloccata + "\nPer sbloccarla prendi e posa qui " +oggettoParticolare;
		if(!this.hasAttrezzo(oggettoParticolare)) {
			return blocco;
		}
		return super.getDescrizione();
	}
}
