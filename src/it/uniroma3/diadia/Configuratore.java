package it.uniroma3.diadia;

import java.io.*;
import java.util.Properties;

public class Configuratore {
	public final static String DIADIA_PROPERTIES = "diadia.properties";
	public final static String CFU_INIZIALI = "cfu_iniziali";
	public final static String PESO_MAX_BORSA = "peso_max_borsa";
	public static Properties prop;
	
	public static int getCFU() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty("cfu_iniziali"));
	}
	
	public static int getPesoMax() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty("peso_max_borsa"));
	}
	
	public static void carica() {
		prop = new Properties();
		try {
			FileInputStream input = new FileInputStream(DIADIA_PROPERTIES);
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
