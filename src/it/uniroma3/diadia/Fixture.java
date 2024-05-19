package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import java.util.*;

public class Fixture {

	public static IOSimulator simulazionePartitaFacile(List<String> comandi) {
		IOSimulator io = new IOSimulator(comandi);
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator simulazionePartitaDifficile(List<String> comandi) {
		IOSimulator io = new IOSimulator(comandi);
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.addStanza("Aula N11")
				.addAdiacenza("Aula N11", "Atrio", "sud")
				.addAdiacenza("Atrio", "Aula N11", "nord")
				.addStanza("Aula N10")
				.addAdiacenza("Aula N10", "Atrio", "est")
				.addAdiacenza("Atrio", "Aula N10", "ovest")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator simulazionePartitaMonolocale(List<String> comandi) {
		IOSimulator io = new IOSimulator(comandi);
		Labirinto monolocale = Labirinto.newBuilder()
				.addStanzaIniziale("salotto") 
				.addStanzaVincente("salotto") 
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, monolocale);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator simulazionePartitaBilocale(List<String> comandi) {
		IOSimulator io = new IOSimulator(comandi);
		Labirinto monolocale = Labirinto.newBuilder()
				.addStanzaIniziale("salotto")
				.addStanzaVincente("camera")
				.addAttrezzo("letto",10)
				.addAdiacenza("salotto", "camera", "nord")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, monolocale);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator simulazionePartitaTrilocale(List<String> comandi) {
		IOSimulator io = new IOSimulator(comandi);
		Labirinto monolocale = Labirinto.newBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, monolocale);
		gioco.gioca();
		return io;
	}
}

