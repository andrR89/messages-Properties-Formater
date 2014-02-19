package com.andre.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utilitario para leitura de arquivos.
 * 
 * @author andre.
 */
public class LeitorArquivo {

	/** Arquivo a ler. */
	private File arquivo;

	/** FileReader. */
	private FileReader fileReader;

	/** BufferedReader. */
	private BufferedReader buffer;

	/**
	 * Construtor.
	 * 
	 * @throws FileNotFoundException
	 */
	public LeitorArquivo(final String diretorio) throws FileNotFoundException {
		
		if(diretorio == null)
		{
			throw new IllegalArgumentException("Diretorio nulo");
		}
		this.arquivo = new File(diretorio);
		this.fileReader = new FileReader(this.arquivo);
		this.buffer = new BufferedReader(fileReader);
	}

	/**
	 * Fechar Recursos da Classe.
	 */
	public void fecharRecursos() {
		RessourcesUtils.closeRessources(this.buffer, this.fileReader);
	}

	/**
	 * Abre uma arquivo para leitura.
	 */
	public String getConteudoArquivo() {
		final StringBuilder builder = new StringBuilder();
		FileReader leitor = null;
		BufferedReader buffer = null;
		try {

			leitor = new FileReader(this.arquivo);
			buffer = new BufferedReader(leitor);

			while (buffer.ready()) {
				builder.append(buffer.readLine() + "\n");
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Imposivel de ler o arquivo "
					+ this.arquivo.getName());
		} finally {
			RessourcesUtils.closeRessources(buffer, fileReader);
		}

		return builder.toString();
	}

	/**
	 * Retorna o Arquivo.
	 * 
	 * @return arquivo a ler.
	 */
	public File getArquivo() {
		return arquivo;
	}

	/**
	 * 
	 * @return
	 */
	public FileReader getFileReader() {
		return fileReader;
	}

	/**
	 * 
	 * @return
	 */
	public BufferedReader getBuffer() {
		return buffer;
	}
}
