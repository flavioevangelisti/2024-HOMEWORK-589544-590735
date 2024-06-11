package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

abstract public class AbstractComando {
	
	private String parametro;
	private String nome;
	private IO io;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public IO getIo() {
		return io;
	}

	public void setIo(IO io) {
		this.io = io;
	}

	abstract public void esegui(Partita partita);
	
	 public void setParametro(String parametro) {
		 this.parametro = parametro;
	 }
	 
	 public String getParametro() {
		 return this.parametro;
	 }
}
