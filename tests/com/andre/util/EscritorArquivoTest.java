package com.andre.util;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.andre.exceptions.CrashException;

/**
 * Teste na Classe Escritor Arquivo.
 * 
 * @author andre.
 */
public class EscritorArquivoTest {

	private String diretorioTeste = TesteUtils.DIR_TESTES + "teste.txt";

	/**
	 * 
	 */
	@After
	public void limparDiretorios() {
		TesteUtils.close("teste.txt");
	}

	/**
	 * Testa passando argumento nulo.
	 * 
	 * @throws IOException
	 */
	@Test(expected = CrashException.class)
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
		EscritorArquivo teste = new EscritorArquivo(diretorioTeste);
		Assert.assertTrue(teste != null);
		teste = new EscritorArquivo(diretorioTeste);
		Assert.assertTrue(teste.getArquivo().exists());
		teste.getArquivo().delete();
		Assert.assertFalse(teste.getArquivo().exists());
	}

	@Test
	public void escreverNovaLinhaOK() throws IOException {
		EscritorArquivo teste = new EscritorArquivo(diretorioTeste);
		teste.escreverNovaLinha("Urrgh");
		teste.fecharRecursos();
		LeitorArquivo leitor = new LeitorArquivo(diretorioTeste);
		Assert.assertTrue(leitor.getConteudoArquivo().equals("Urrgh\n"));
	}

}
