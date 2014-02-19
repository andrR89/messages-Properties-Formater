package com.andre.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LeitorArquivoTest {

	/** Diretorio Dump pra execução dos teste. */
	final static String DIR_TESTES = "Arquivos/Testes/Dump/teste.txt";
	/** Arquivo utilizado no teste. */
	final static String ARQUIVO = "Arquivos/Testes/server-links-uteis.txt";

	/**
	 * Joga arquivo de teste no diretorio DUMP.
	 * 
	 * @throws IOException
	 */
	@BeforeClass
	public static void init() throws IOException {
		File in = new File(ARQUIVO);
		File out = new File(DIR_TESTES);
		FileInputStream fileInputStream = new FileInputStream(in);
		FileChannel sourceChannel = fileInputStream.getChannel();
		FileOutputStream fileOutputStream = new FileOutputStream(out);
		FileChannel destinationChannel = fileOutputStream.getChannel();
		sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);

		sourceChannel.close();
		destinationChannel.close();
		fileInputStream.close();
		fileOutputStream.close();
	}

	/**
	 * Exclui o arquivo do diretorio de DUMP.
	 */
	@AfterClass
	public static void close() {
		File out = new File(DIR_TESTES);

		if (out.exists()) {
			out.delete();
		}
	}

	/**
	 * Testa Construtor OK
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testConstruorOK() throws FileNotFoundException {
		LeitorArquivo leito = new LeitorArquivo(DIR_TESTES);
		Assert.assertTrue(leito.getArquivo() != null);
	}

	/**
	 * Testa Contrutor com parametro null.
	 * 
	 * @throws FileNotFoundException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstruorNull() throws FileNotFoundException {
		LeitorArquivo leitor = new LeitorArquivo(null);
		Assert.assertTrue(leitor.getArquivo() != null);
	}

	/**
	 * Testa contrutor com paramentro Vazio.
	 * 
	 * @throws FileNotFoundException
	 */
	@Test(expected = FileNotFoundException.class)
	public void testConstruorVazio() throws FileNotFoundException {
		LeitorArquivo leitor = new LeitorArquivo("");
		Assert.assertTrue(leitor.getArquivo() != null);
	}

	/**
	 * Testa metodo getConteudo Arquivo.
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGetConteudoArquivo() throws FileNotFoundException {
		LeitorArquivo leitor = new LeitorArquivo(DIR_TESTES);
		leitor.fecharRecursos();
		Assert.assertTrue(leitor.getConteudoArquivo() != null);
	}

}
