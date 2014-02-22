package com.andre.rules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes na classe de Configurações.
 * 
 * @author andre .
 */
public class ConfiguracoesTest {

	private Configuracoes conf = new Configuracoes();

	/**
	 * Carrega valores para teste.
	 */
	@Before
	public void before() {
		this.conf.getPalavrasExcecoes().add("André");
		this.conf.getPalavrasExcecoes().add("JSF");
		this.conf.getPalavrasExcecoes().add("Java");

		PropertieExecao pex1 = new PropertieExecao("messages",
				RegrasEnum.MINUSCULA_ALL);
		PropertieExecao pex2 = new PropertieExecao("exceptions",
				RegrasEnum.MAIUSCULA_ALL);

		this.conf.getPropertiesExecoes().add(pex1);
		this.conf.getPropertiesExecoes().add(pex2);
	}
	
	/**
	 * Testa se é uma palavre execção.
	 */
	@Test
	public void testIsPalavraExcecaoNull()
	{
		final String palavra = null;
		Assert.assertFalse(conf.isPalavraExcecao(palavra));
	}
	
	/**
	 * Testa se é uma palavre execção.
	 */
	@Test
	public void testIsPalavraExcecaoVazio()
	{
		final String palavra = "";
		Assert.assertFalse(conf.isPalavraExcecao(palavra));
	}
	
	/**
	 * Testa se é uma palavre execção.
	 */
	@Test
	public void testIsPalavraExcecaoFalse()
	{
		final String palavra = "Andŕe";
		Assert.assertFalse(conf.isPalavraExcecao(palavra));
	}
	
	/**
	 * Testa se é uma palavre execção.
	 */
	@Test
	public void testIsPalavraExcecaoTRUE()
	{
		final String palavra = "jsf";
		Assert.assertTrue(conf.isPalavraExcecao(palavra));
	}

	/**
	 * Verifica se a propertie é execcao;
	 */
	@Test
	public void testIsPropertieExcecaoTRUE() {
		final Propertie p = new Propertie("messages", "cadastro_incluido_com_sucesso", "Seu CADASTRO foi inserido com sucesso!");
		Assert.assertTrue(conf.isPropertieExcecao(p));
	}
	
	/**
	 * Verifica se a propertie é execcao;
	 */
	@Test
	public void testIsPropertieExcecaoFALSE() {
		final Propertie p = new Propertie("label", "carro", "CaRRo");
		Assert.assertFalse(conf.isPropertieExcecao(p));
	}
	
	/**
	 * propertie é execcao param invalido;
	 */
	@Test
	public void testIsPropertieExcecaoParamInvalido() {
		Assert.assertFalse(conf.isPropertieExcecao(null));
	}

}
