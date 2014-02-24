package com.andre.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.andre.exceptions.CrashException;

public class LeitorArquivoTest {

	/**
	 * Joga arquivo de teste no diretorio DUMP.
	 * 
	 * @throws IOException
	 */
	@BeforeClass
	public static void init() throws IOException {
		TesteUtils.init(TesteUtils.ARQ_DEFAULT_TEST);
	}

	/**
	 * Exclui o arquivo do diretorio de DUMP.
	 */
	@AfterClass
	public static void close() {
		TesteUtils.close(TesteUtils.ARQ_DEFAULT_TEST);
	}

	/**
	 * Testa Construtor OK
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testConstruorOK() throws FileNotFoundException {
		LeitorArquivo leito = new LeitorArquivo(TesteUtils.DIR_TESTES
				+ TesteUtils.ARQ_DEFAULT_TEST);
		Assert.assertTrue(leito.getArquivo() != null);
	}

	/**
	 * Testa Contrutor com parametro null.
	 * 
	 * @throws FileNotFoundException
	 */
	@Test(expected = CrashException.class)
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
		LeitorArquivo leitor = new LeitorArquivo(TesteUtils.DIR_TESTES
				+ TesteUtils.ARQ_DEFAULT_TEST);
		leitor.fecharRecursos();
		Assert.assertTrue(leitor.getConteudoArquivo() != null);
	}

}
