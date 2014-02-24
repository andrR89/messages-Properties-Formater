package com.andre.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Utilitario para teste.
 * 
 * @author andre .
 * 
 */
public final class TesteUtils {

	/** Diretorio Dump pra execução dos teste. */
	public final static String DIR_TESTES = "Arquivos/Testes/Dump/";
	/** Arquivo utilizado no teste. */
	public final static String DIR_ARQUIVOS = "Arquivos/Testes/";

	/** Diretorio Dump pra execução dos teste. */
	public final static String ARQ_PROPERTIES_TEST = "teste.properties";

	/** Diretorio Dump pra execução dos teste. */
	public final static String ARQ_DEFAULT_TEST = "server-links-uteis.txt";

	/**
	 * Joga arquivo de teste no diretorio DUMP.
	 * 
	 * @throws IOException
	 */
	public static void init(String nomeArquivo) throws IOException {
		File in = new File(DIR_ARQUIVOS + nomeArquivo);
		File out = new File(DIR_TESTES + nomeArquivo);
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
	public static void close(String arquivo) {
		File out = new File(DIR_TESTES + arquivo);

		if (out.exists()) {
			out.delete();
		}
	}

}
