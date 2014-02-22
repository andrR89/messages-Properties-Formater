package com.andre.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.andre.exceptions.CrashException;

/**
 * Utilitario para escrita em arquivos.
 * 
 * @author andre
 * 
 */
public class EscritorArquivo {

	/** Arquivo para que será escrito. */
	private File arquivo;

	/** OutputStreamWriter. */
	private OutputStreamWriter buffer;


	/**
	 * Construtor.
	 * 
	 * @param diretorio
	 * @throws IOException
	 */
	public EscritorArquivo(final String diretorio) throws IOException {
		if (diretorio == null) {
			throw new CrashException("Diretorio invalido.");
		}
		this.arquivo = new File(diretorio);
		if (!this.arquivo.exists()) {
			this.arquivo.createNewFile();

		}
		this.buffer = new OutputStreamWriter(
				new FileOutputStream(this.arquivo), "UTF-8");
	}

	/**
	 * Escreve no arquivo em uma nova linha.
	 */
	public void escreverNovaLinha(final String conteudo) {
		try {
			this.buffer.write(conteudo);
			this.buffer.write("\n");
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"Imposivel de escrever no arquivo.");
		}
	}

	/**
	 * Fecha os Recursos da classe.
	 */
	public void fecharRecursos() {
		RessourcesUtils.closeRessources(this.buffer);
	}

	/**
	 * @return the arquivo
	 * 
	 *         /**
	 * 
	 * @return
	 */
	public File getArquivo() {
		return arquivo;
	}

	/**
	 * @return the buffer
	 */
	public OutputStreamWriter getBuffer() {
		return buffer;
	}

}
