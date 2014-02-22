package com.andre.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.andre.exceptions.CrashException;
import com.andre.rules.Configuracoes;
import com.andre.rules.Propertie;
import com.andre.util.EscritorArquivo;
import com.andre.util.LeitorArquivo;

/**
 * Classe com as regras para a validação dos campos das messages.
 * 
 * @author andre
 * 
 */
public class RegrasMessages {

	/** Configurações das regras. */
	private Configuracoes configuracoes;

	/** Dados que serão escritos no arquivo. */
	private List<Propertie> dados;

	/** Leito do arquivo. */
	private LeitorArquivo leitor;

	/** Escritor do arquivo */
	private EscritorArquivo escritor;

	/**
	 * Construtor.
	 * 
	 * @param configuracoes
	 *            .
	 * @throws IOException .
	 */
	public RegrasMessages(final Configuracoes configuracoes) throws IOException {
		this.dados = new ArrayList<Propertie>();
		this.configuracoes = configuracoes;

		this.leitor = new LeitorArquivo(this.configuracoes.getArquivoEntrada());
		this.escritor = new EscritorArquivo(
				this.configuracoes.getArquivoSaida());
	}

	/**
	 * Executa o processo.
	 */
	public void executar() {
		try {
			while (this.leitor.getBuffer().ready()) {

			}
		} catch (IOException e) {
			throw new CrashException("Erro ao ler o arquivo.");
		}
	}

	/**
	 * Grava o processo.
	 */
	public void gravar() {
		for (Propertie dado : dados) {
			escritor.escreverNovaLinha(dado.toString());
		}
		escritor.fecharRecursos();
	}

	/**
	 * Verifica se é uma linha de properities.
	 * 
	 * @param linha
	 * @return
	 */
	private boolean isLinhaPropertie(final String linha) 
	{
		String re = "^[\\s-]*([0-9a-zA-Z-_\\.]+([\\h.-])?[\\s-]*=[*\\d*\\D]*)+$";
		String str = "message = teste";
		 
		Pattern p = Pattern.compile(re);
		Matcher m = p.matcher(str);
		return false;
	}
}
