package com.andre.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase contendo as configuraçẽos da edição do arquivo.
 * 
 * @author andre .
 * 
 */
public class Configuracoes {

	/** Caminho ao arquivo de entrada. (leitura) */
	private String arquivoEntrada;

	/** Caminho ao aquivo de saida. (Escrita) */
	private String arquivoSaida;

	/** Regras de edição. */
	private RegrasEnum regras = RegrasEnum.NAO_ALTERAR;

	/** Propriedades exeções a regra de edição. */
	private List<PropertieExecao> propertiesExecoes = new ArrayList<PropertieExecao>();

	/** palavras exeções as regras. */
	private List<String> palavrasExcecoes = new ArrayList<>();

	/**
	 * Verifica se uma Propertie é execao a regra.
	 * 
	 * @param propertie
	 *            .
	 * @return .
	 */
	public boolean isPropertieExcecao(Propertie propertie) {
		boolean retorno = false;

		if (propertie == null) {
			return retorno;
		}

		for (PropertieExecao excecao : propertiesExecoes) {
			if (excecao.getNomePrefixo().equals(propertie.getPrefixo())) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}

	/**
	 * Verifica se a palavra é execção a regra.
	 * 
	 * @param palavra
	 * @return
	 */
	public boolean isPalavraExcecao(String palavra) {
		boolean retorno = false;

		if (palavra == null || palavra.trim().equals("")) {
			return retorno;
		}

		for (String excecao : palavrasExcecoes) {
			if (excecao.toLowerCase().equals(palavra.toLowerCase())) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}

	/**
	 * @return the arquivoEntrada
	 */
	public String getArquivoEntrada() {
		return arquivoEntrada;
	}

	/**
	 * @param arquivoEntrada
	 *            the arquivoEntrada to set
	 */
	public void setArquivoEntrada(String arquivoEntrada) {
		this.arquivoEntrada = arquivoEntrada;
	}

	/**
	 * @return the arquivoSaida
	 */
	public String getArquivoSaida() {
		return arquivoSaida;
	}

	/**
	 * @param arquivoSaida
	 *            the arquivoSaida to set
	 */
	public void setArquivoSaida(String arquivoSaida) {
		this.arquivoSaida = arquivoSaida;
	}

	/**
	 * @return the regras
	 */
	public RegrasEnum getRegras() {
		return regras;
	}

	/**
	 * @param regras
	 *            the regras to set
	 */
	public void setRegras(RegrasEnum regras) {
		this.regras = regras;
	}

	/**
	 * @return the propertiesExecoes
	 */
	public List<PropertieExecao> getPropertiesExecoes() {
		return propertiesExecoes;
	}

	/**
	 * @param propertiesExecoes
	 *            the propertiesExecoes to set
	 */
	public void setPropertiesExecoes(List<PropertieExecao> propertiesExecoes) {
		this.propertiesExecoes = propertiesExecoes;
	}

	/**
	 * @return the palavrasExcecoes
	 */
	public List<String> getPalavrasExcecoes() {
		return palavrasExcecoes;
	}

	/**
	 * @param palavrasExcecoes
	 *            the palavrasExcecoes to set
	 */
	public void setPalavrasExcecoes(List<String> palavrasExcecoes) {
		this.palavrasExcecoes = palavrasExcecoes;
	}

}
