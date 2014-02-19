package com.andre.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class RessourcesUtilsTest {

	/** Arquivo utilizado no teste. */
	final static String ARQUIVO = "Arquivos/Testes/server-links-uteis.txt";

	/**
	 * Testa Close Ressources passa null.
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testCloseRessourcesNull() throws FileNotFoundException {
		FileReader fileReader = null;
		RessourcesUtils.closeRessources(null, fileReader);
	}

	/**
	 * Testa Close Ressources OK.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testCloseRessourcesOK() throws IOException {
		InputStream stream = new FileInputStream(ARQUIVO);
		FileReader fileReader = new FileReader(ARQUIVO);
		FileWriter fileWriter = new FileWriter(ARQUIVO);
		RessourcesUtils.closeRessources(fileReader, fileWriter, stream);
	}

}
