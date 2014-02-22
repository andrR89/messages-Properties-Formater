package com.andre.rules;

/**
 * Prefixo Properties execção as regras defaul.
 * 
 * @author andre .
 */
public class PropertieExecao {

	/** Nome do profixo da propertie.*/
	private String nomePrefixo;

	/** Regra expecifica.*/
	private RegrasEnum regra;

	/**
	 * 
	 * @param nomePrefixo
	 * @param regra
	 */
	public PropertieExecao(final String nomePrefixo, final RegrasEnum regra) {
		this.nomePrefixo = nomePrefixo;
		this.regra = regra;
	}

	/**
	 * @return the nomePrefixo
	 */
	public String getNomePrefixo() {
		return nomePrefixo;
	}

	/**
	 * @param nomePrefixo
	 *            the nomePrefixo to set
	 */
	public void setNomePrefixo(String nomePrefixo) {
		this.nomePrefixo = nomePrefixo;
	}

	/**
	 * @return the regra
	 */
	public RegrasEnum getRegra() {
		return regra;
	}

	/**
	 * @param regra
	 *            the regra to set
	 */
	public void setRegra(RegrasEnum regra) {
		this.regra = regra;
	}
}
