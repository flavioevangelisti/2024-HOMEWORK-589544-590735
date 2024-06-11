package it.uniroma3.diadia.test;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.*;

import java.util.*;

public class Fixture {

	public static IOSimulator simulazionePartitaFacile(List<String> comandi) throws Exception {
		IOSimulator io = new IOSimulator(comandi);
		Labirinto labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator simulazionePartitaDifficile(List<String> comandi) throws Exception {
		IOSimulator io = new IOSimulator(comandi);
		Labirinto labirinto = Labirinto.newBuilder("labirinto3.txt").getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}
	
//	public static IOSimulator simulazionePartitaMonolocale(List<String> comandi) {
//		IOSimulator io = new IOSimulator(comandi);
//		Labirinto monolocale = Labirinto.newBuilder()
//				.addStanzaIniziale("salotto") 
//				.addStanzaVincente("salotto") 
//				.getLabirinto();
//		DiaDia gioco = new DiaDia(io, monolocale);
//		gioco.gioca();
//		return io;
//	}
//	
//	public static IOSimulator simulazionePartitaBilocale(List<String> comandi) {
//		IOSimulator io = new IOSimulator(comandi);
//		Labirinto monolocale = Labirinto.newBuilder()
//				.addStanzaIniziale("salotto")
//				.addStanzaVincente("camera")
//				.addAttrezzo("letto",10)
//				.addAdiacenza("salotto", "camera", "nord")
//				.getLabirinto();
//		DiaDia gioco = new DiaDia(io, monolocale);
//		gioco.gioca();
//		return io;
//	}
//	
//	public static IOSimulator simulazionePartitaTrilocale(List<String> comandi) {
//		IOSimulator io = new IOSimulator(comandi);
//		Labirinto monolocale = Labirinto.newBuilder()
//				.addStanzaIniziale("salotto")
//				.addStanza("cucina")
//				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta
//				.addStanzaVincente("camera")
//				.addAdiacenza("salotto", "cucina", "nord")
//				.addAdiacenza("cucina", "camera", "est")
//				.getLabirinto();
//		DiaDia gioco = new DiaDia(io, monolocale);
//		gioco.gioca();
//		return io;
//	}
}

