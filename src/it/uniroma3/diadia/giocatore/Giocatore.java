package it.uniroma3.diadia.giocatore;


public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	
	private Borsa borsa;
	private int cfu;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public Borsa setBorsa(Borsa borsa) {
		return this.borsa = borsa;
	}
	
	public int setCfu(int cfu) {
		return this.cfu = cfu;
	}
	
}
