package com.andre.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.andre.exceptions.CrashException;
import com.andre.rules.Configuracoes;
import com.andre.rules.Propertie;
import com.andre.rules.PropertieExecao;
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
	private List<String> dados;

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
		this.dados = new ArrayList<String>();
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
				processarLinha();
			}
		} catch (IOException e) {
			throw new CrashException("Erro ao ler o arquivo.");
		}
	}

	/**
	 * Grava o processo.
	 */
	public void gravar() {
		for (String dado : dados) {
			escritor.escreverNovaLinha(dado.toString());
		}
		escritor.fecharRecursos();
	}

	/**
	 * Processa a linha.
	 * 
	 * @throws IOException
	 */
	private void processarLinha() throws IOException {
		final String linha = this.leitor.getBuffer().readLine();
		if (Propertie.isLinhaPropertie(linha)) {
			EditorProperties editor = new EditorProperties(configuracoes);

			Propertie propertie = Propertie.getPropertie(linha);

			if (configuracoes.isPropertieExcecao(propertie)) {
				final PropertieExecao excecao = configuracoes
						.getExcecao(propertie);
				propertie = editor.executarAlteracoes(propertie,
						excecao.getRegra());
			} else {
				propertie = editor.executarAlteracoes(propertie,
						configuracoes.getRegras());
			}

			dados.add(propertie.toString());
		} else {
			// Não faz nada na linha pq não é uma properties.
			dados.add(linha);
		}
	}
}
