package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzoParticolare;
	
	public StanzaBuia(String nome , String attrezzo) {
		super(nome);
		this.attrezzoParticolare = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		String buio=new String();
		buio= "qui c'è un buio pesto";
		if(!this.hasAttrezzo(attrezzoParticolare)) {
			return buio;
		}
		return super.getDescrizione();
	}
}


