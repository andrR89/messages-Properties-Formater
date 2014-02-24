package com.andre.rules;

import java.util.regex.Pattern;

/**
 * Objeto da propertie.
 * 
 * @author andre .
 * 
 */
public class Propertie {
	/** Prefixo. */
	private String prefixo;

	/** Nome. */
	private String nome;

	/** Valor. */
	private String valor;

	/** Regex que verifica se a string é uma properties. */
	public final static String REGEX_PROPERTIE = "([\\s-]*)(([\\w-\\.]*)[.-]?([\\s-]*=)([*\\d*\\D]*))+$";

	/**
	 * Construtor.
	 */
	public Propertie() {

	}

	/**
	 * Construtor.
	 * 
	 * @param prefixo
	 * @param nome
	 * @param valor
	 */
	public Propertie(final String prefixo, final String nome, final String valor) {
		this.prefixo = prefixo;
		this.nome = nome;
		this.valor = valor;
	}

	/**
	 * @return the prefixo
	 */
	public String getPrefixo() {
		return prefixo;
	}

	/**
	 * Verifica se é uma linha de properities.
	 * 
	 * @param linha
	 * @return
	 */
	public static boolean isLinhaPropertie(final String linha) {
		if (linha == null) {
			return false;
		}
		return Pattern.matches(Propertie.REGEX_PROPERTIE, linha);
	}

	/**
	 * Transforma a string em propertie.
	 * 
	 * @param linha
	 *            .
	 * @return.
	 */
	public static Propertie getPropertie(final String linha) {
		if (isLinhaPropertie(linha)) {
			String[] propertie = linha.split("=");
			String[] prefixoENome = getPrefixoENome(propertie[0]);
			return new Propertie(prefixoENome[0], prefixoENome[1], propertie[1]);
		}
		return null;
	}

	/**
	 * Retorna o prefixo e o nome da Propertie.
	 * 
	 * @param propertie
	 *            .
	 * @return .
	 */
	private static String[] getPrefixoENome(final String propertie) {
		StringBuilder builder = new StringBuilder();
		String[] dadosExtract = propertie.split("\\.");
		String[] dadosReturn = new String[2];
		if (dadosExtract.length < 2) {
			dadosReturn[0] = "";
			dadosReturn[1] = propertie;
		} else {
			dadosReturn[0] = dadosExtract[0];
			for (int i = 1; i < dadosExtract.length; i++) {
				if (i != 1 && i < dadosExtract.length) {
					builder.append(".");
				}
				builder.append(dadosExtract[i]);
			}
			dadosReturn[1] = builder.toString();
		}
		return dadosReturn;
	}

	/**
	 * @param prefixo
	 *            the prefixo to set
	 */
	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		if (valor == null || nome == null || prefixo == null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		if (prefixo != null && !prefixo.trim().equals("")) {
			builder.append(prefixo.trim());
			builder.append(".");
		}
		builder.append(nome.trim());
		builder.append(" = ");
		builder.append(valor);
		return builder.toString();
	}
}
