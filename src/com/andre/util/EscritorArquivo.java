package com.andre.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utilitario para escrita em arquivos.
 * 
 * @author andre
 * 
 */
public class EscritorArquivo {

	/** Arquivo para que será escrito. */
	private File arquivo;

	/** FileWriter */
	private FileWriter fileWriter;

	/** BufferedWriter. */
	private BufferedWriter buffer;

	/**
	 * Construtor.
	 * 
	 * @param diretorio
	 * @throws IOException
	 */
	public EscritorArquivo(final String diretorio) throws IOException {
		if(diretorio == null)
		{
			throw new IllegalArgumentException("Diretorio invalido.");
		}
		this.arquivo = new File(diretorio);
		if (!this.arquivo.exists()) {
			this.arquivo.createNewFile();

		}
		this.fileWriter = new FileWriter(this.arquivo);
		this.buffer = new BufferedWriter(fileWriter);
	}

	/**
	 * Escreve no arquivo em uma nova linha.
	 */
	public void escreverNovaLinha(final String conteudo) {
		try {
			this.buffer.write(conteudo);
			this.buffer.newLine();
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"Imposivel de escrever no arquivo.");
		}
	}

	/**
	 * Fecha os Recursos da classe.
	 */
	public void fecharRecursos() {
		RessourcesUtils.closeRessources(this.buffer, this.fileWriter);
	}

	/**
	 * 
	 * @return
	 */
	public File getArquivo() {
		return arquivo;
	}

	/**
	 * 
	 * @return
	 */
	public FileWriter getFileWriter() {
		return fileWriter;
	}

	public BufferedWriter getBuffer() {
		return buffer;
	}
}
