package com.andre.util;

import java.io.BufferedReader;
import java.io.File;
<<<<<<< HEAD
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.andre.exceptions.CrashException;
=======
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8

/**
 * Utilitario para leitura de arquivos.
 * 
 * @author andre.
 */
public class LeitorArquivo {

	/** Arquivo a ler. */
	private File arquivo;

<<<<<<< HEAD
=======
	/** FileReader. */
	private FileReader fileReader;

>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8
	/** BufferedReader. */
	private BufferedReader buffer;

	/**
	 * Construtor.
	 * 
	 * @throws FileNotFoundException
	 */
	public LeitorArquivo(final String diretorio) throws FileNotFoundException {
<<<<<<< HEAD

		if (diretorio == null) {
			throw new CrashException("Diretorio nulo");
		}
		this.arquivo = new File(diretorio);
		try {
			this.buffer = new BufferedReader(new InputStreamReader(
					new FileInputStream(this.arquivo), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new CrashException("Erro de Encooding");
		}
=======
		
		if(diretorio == null)
		{
			throw new IllegalArgumentException("Diretorio nulo");
		}
		this.arquivo = new File(diretorio);
		this.fileReader = new FileReader(this.arquivo);
		this.buffer = new BufferedReader(fileReader);
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8
	}

	/**
	 * Fechar Recursos da Classe.
	 */
	public void fecharRecursos() {
<<<<<<< HEAD
		RessourcesUtils.closeRessources(this.buffer);
=======
		RessourcesUtils.closeRessources(this.buffer, this.fileReader);
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8
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
<<<<<<< HEAD
			RessourcesUtils.closeRessources(buffer);
=======
			RessourcesUtils.closeRessources(buffer, fileReader);
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8
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
<<<<<<< HEAD
=======
	public FileReader getFileReader() {
		return fileReader;
	}

	/**
	 * 
	 * @return
	 */
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8
	public BufferedReader getBuffer() {
		return buffer;
	}
}
