package com.andre.util;

<<<<<<< HEAD
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.andre.exceptions.CrashException;
=======
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8

/**
 * Utilitario para escrita em arquivos.
 * 
 * @author andre
 * 
 */
public class EscritorArquivo {

	/** Arquivo para que será escrito. */
	private File arquivo;

<<<<<<< HEAD
	/** OutputStreamWriter. */
	private OutputStreamWriter buffer;
=======
	/** FileWriter */
	private FileWriter fileWriter;

	/** BufferedWriter. */
	private BufferedWriter buffer;
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8

	/**
	 * Construtor.
	 * 
	 * @param diretorio
	 * @throws IOException
	 */
	public EscritorArquivo(final String diretorio) throws IOException {
<<<<<<< HEAD
		if (diretorio == null) {
			throw new CrashException("Diretorio invalido.");
=======
		if(diretorio == null)
		{
			throw new IllegalArgumentException("Diretorio invalido.");
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8
		}
		this.arquivo = new File(diretorio);
		if (!this.arquivo.exists()) {
			this.arquivo.createNewFile();

		}
<<<<<<< HEAD

		this.buffer = new OutputStreamWriter(
				new FileOutputStream(this.arquivo), "UTF-8");
=======
		this.fileWriter = new FileWriter(this.arquivo);
		this.buffer = new BufferedWriter(fileWriter);
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8
	}

	/**
	 * Escreve no arquivo em uma nova linha.
	 */
	public void escreverNovaLinha(final String conteudo) {
		try {
			this.buffer.write(conteudo);
<<<<<<< HEAD
			this.buffer.write("\n");
=======
			this.buffer.newLine();
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"Imposivel de escrever no arquivo.");
		}
	}

	/**
	 * Fecha os Recursos da classe.
	 */
	public void fecharRecursos() {
<<<<<<< HEAD
		RessourcesUtils.closeRessources(this.buffer);
	}

	/**
	 * @return the arquivo
=======
		RessourcesUtils.closeRessources(this.buffer, this.fileWriter);
	}

	/**
	 * 
	 * @return
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8
	 */
	public File getArquivo() {
		return arquivo;
	}

	/**
<<<<<<< HEAD
	 * @return the buffer
	 */
	public OutputStreamWriter getBuffer() {
		return buffer;
	}
	
=======
	 * 
	 * @return
	 */
	public FileWriter getFileWriter() {
		return fileWriter;
	}

	public BufferedWriter getBuffer() {
		return buffer;
	}
>>>>>>> 27179259b9cfb9cf2e5975165ef34c4e27eda0e8
}
