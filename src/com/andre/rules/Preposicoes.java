package com.andre.rules;

/**
 * Enum com as preposições.
 * 
 * @author andre
 * 
 */
public enum Preposicoes {
	/* Perposições. */
	DA("da"),

	DAS("das"),

	DE("de"),

	DO("do"),

	DOS("dos"),

	A("a"),
	
	AH("á"),
	
	AH_CRASE("à"),

	AS("as"),

	E("e"),
	
	EH("é"),

	O("o"),

	OS("os"),

	COM("com"),

	PARA("para"),

	COMO("como"),

	NA("na"),

	NAS("nas"),

	NO("no"),

	NOS("nos"),

	POR("por"),

	EM("em"),

	UM("um"),

	UNS("uns"),

	UMA("uma"),

	UMAS("umas"),

	SEM("sem"),

	PELO("pelo"),

	PELOS("pelos"),

	PELA("pela"),

	PELAS("pelas");

	/** Variavel da Palavra */
	private final String palavra;

	/**
	 * Constutor da enum.
	 * 
	 * @param palavra
	 */
	private Preposicoes(String palavra) {
		this.palavra = palavra;
	}

	/**
	 * @return the palavra
	 */
	public String getPalavra() {
		return palavra;
	}

}
