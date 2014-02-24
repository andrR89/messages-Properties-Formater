package com.andre.core;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.andre.rules.Configuracoes;
import com.andre.rules.RegrasEnum;
import com.andre.util.TesteUtils;

public class RegrasMessagesTest {

	private static final String arquivoLido = TesteUtils.DIR_TESTES
			+ TesteUtils.ARQ_PROPERTIES_TEST;
	
	private static final String arquivoEscrito = TesteUtils.DIR_TESTES
			+ "nova.properties";

	/**
	 * Joga arquivo de teste no diretorio DUMP.
	 * 
	 * @throws IOException
	 */
	@BeforeClass
	public static void init() throws IOException {
		TesteUtils.init(TesteUtils.ARQ_PROPERTIES_TEST);
	}

	/**
	 * Exclui o arquivo do diretorio de DUMP.
	 */
	@AfterClass
	public static void close() {
		TesteUtils.close(TesteUtils.ARQ_PROPERTIES_TEST);
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	@Test
	public void testar() throws IOException
	{
		Configuracoes conf = new Configuracoes();
		conf.setRegras(RegrasEnum.MAIUSCULA_ALL);
		conf.setArquivoEntrada(arquivoLido);
		conf.setArquivoSaida(arquivoEscrito);
		RegrasMessages x = new RegrasMessages(conf);
		x.executar();
		x.gravar();
	}
}
