package com.andre.rules;

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
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append(prefixo);
		builder.append(".");
		builder.append(nome);
		builder.append(" = ");
		builder.append(valor);
		return builder.toString();
	}
}
