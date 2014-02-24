package com.andre.core;

import java.awt.print.Paper;

import org.apache.commons.lang3.text.WordUtils;

import com.andre.rules.Configuracoes;
import com.andre.rules.Propertie;
import com.andre.rules.RegrasEnum;

public class EditorProperties {

	/** Instancia de configuração. */
	private Configuracoes configuracao;

	/**
	 * Construtor.
	 * 
	 * @param configuracao
	 *            .
	 */
	public EditorProperties(Configuracoes configuracao) {
		this.configuracao = configuracao;
	}

	/**
	 * Inicia as alterações
	 * 
	 * @return
	 */
	public Propertie executarAlteracoes(final Propertie propertie, RegrasEnum regras) 
	{
		final Propertie propertieAlterada = new Propertie(propertie.getPrefixo(),propertie.getNome(), propertie.getValor());
		String valor = null;
		switch (regras) {
		case MAIUSCULA_ALL:
			valor = processarTodasMaiusculas(propertie.getValor());
			break;
		case MINUSCULA_ALL:
			valor = processarTodasMinusculas(propertie.getValor());
			break;
		case MAIUSCULA_PRIMEIRA_LETRA:
			valor = processarMaiusculasPrimeiraLetraTodas(propertie.getValor());
			break;
		case MAIUSCULA_PRIMEIRA_LETRA_FRASE:
			valor = processarMaiusculasPrimeiraLetraFrase(propertie.getValor());
			break;
		case NAO_ALTERAR:
			System.out.println("Não alterar a frase!");
			valor = propertie.getValor();
			break;
		}
		propertieAlterada.setValor(valor);
		return propertieAlterada;
	}

	/**
	 * Processa todas as palavras em letra maiuscula.
	 * 
	 * @param valor
	 *            .
	 * @return .
	 */
	private String processarTodasMaiusculas(String valor) {
		if (valor == null) {
			return "";
		}
		return valor.toUpperCase();
	}

	/**
	 * Processa todas as palavras em letra minusculas.
	 * 
	 * @param valor
	 *            .
	 * @return .
	 */
	private String processarTodasMinusculas(String valor) {
		if (valor == null) {
			return "";
		}
		return valor.toLowerCase();
	}

	/**
	 * Processa todas as palavras em letra minusculas.
	 * 
	 * @param valor
	 *            .
	 * @return .
	 */
	private String processarMaiusculasPrimeiraLetraFrase(String valor) {
		if (valor == null) {
			return "";
		}

		String frase = valor;
		for (int i = 0; i < valor.length(); i++) {
			if (Character.isAlphabetic(valor.charAt(i))) {

				frase = valor.replace(valor.charAt(i),
						Character.toUpperCase(valor.charAt(i)));
				break;
			}
		}

		return frase;
	}

	/**
	 * Processa todas as palavras em letra minusculas.
	 * 
	 * @param valor
	 *            .
	 * @return .
	 */
	private String processarMaiusculasPrimeiraLetraTodas(String valor) {
		if (valor == null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		// Quebra a frase em palavras
		String[] palavras = valor.split(" ");

		int count = 0;
		for (String palavra : palavras) {
			// ajusta todas as palavas pra maiusculo
			palavra = WordUtils.capitalize(palavra);
			
			// Primeira letra da palavra.. tem que ser maiuscula.
			if (count != 0)
				palavra = alterarPreposicao(palavra);

			palavra = alterarPalavrasExcecoes(palavra);

			count++;
			builder.append(palavra);
			builder.append(" ");
		}

		return builder.toString();
	}

	/**
	 * Altera a string caso seja uma preposicao (Tudo minuscula).
	 * 
	 * @param valor
	 * @return
	 */
	private String alterarPreposicao(String valor) {
		if (configuracao.isPreposicao(valor)) {
			return valor.toLowerCase();
		}
		return valor;
	}

	/**
	 * Altera a string caso seja uma palavra execao. (Tudo maiuscula)
	 * 
	 * @param valor
	 * @return
	 */
	private String alterarPalavrasExcecoes(String valor) {
		if (configuracao.isPalavraExcecao(valor)) {
			return valor.toUpperCase();
		}
		return valor;
	}
}
