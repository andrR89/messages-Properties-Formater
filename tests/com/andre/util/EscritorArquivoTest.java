package com.andre.util;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Teste na Classe Escritor Arquivo.
 * 
 * @author andre.
 */
public class EscritorArquivoTest {

	final static String DIR_ARQUIVO = "/home/andre/Documentos/teste.txt";

	@After
	public void limparDiretorios() {
		File file = new File(DIR_ARQUIVO);

		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * Testa passando argumento nulo.
	 * 
	 * @throws IOException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorStringNull() throws IOException {
		final EscritorArquivo error = new EscritorArquivo(null);
		error.getArquivo();
	}

	/**
	 * Testa passando arguemnto não arquivo.
	 * 
	 * @throws IOException
	 */
	@Test(expected = IOException.class)
	public void testConstrutorStringVazia() throws IOException {
		final EscritorArquivo error = new EscritorArquivo("");
		error.getArquivo();
	}

	/**
	 * Testa criando um aquivo com o argumento valido.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testConstrutorOKNovoArquivo() throws IOException {
		EscritorArquivo teste = new EscritorArquivo(DIR_ARQUIVO);
		Assert.assertTrue(teste != null);
		teste = new EscritorArquivo(DIR_ARQUIVO);
		Assert.assertTrue(teste.getArquivo().exists());
		teste.getArquivo().delete();
		Assert.assertFalse(teste.getArquivo().exists());
	}

	@Test
	public void escreverNovaLinhaOK() throws IOException {
		EscritorArquivo teste = new EscritorArquivo(DIR_ARQUIVO);
		teste.escreverNovaLinha("Urrgh");
		teste.fecharRecursos();
		LeitorArquivo leitor = new LeitorArquivo(DIR_ARQUIVO);
		Assert.assertTrue(leitor.getConteudoArquivo().equals("Urrgh\n"));
	}

}
