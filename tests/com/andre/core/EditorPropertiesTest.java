package com.andre.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.andre.rules.Configuracoes;
import com.andre.rules.Propertie;
import com.andre.rules.RegrasEnum;

/**
 * Teste na classe de Edicao de properties.
 * 
 * @author andre
 * 
 */
public class EditorPropertiesTest {

	/**
	 * Testa executarAlteracoes MAIUSCULA_ALL null
	 */
	@Test
	public void executarAlteracoesMAIUSCULA_ALL_Null() {
		
//		Configuracoes conf = new Configuracoes();
//		List<String> excessoes = new ArrayList<String>();
//		excessoes.add("URRGH");
//		excessoes.add("Arrgh");
//		conf.setPalavrasExcecoes(excessoes);
		
		Propertie prop = new Propertie("arrgh", "urrgh", null);
		
		EditorProperties ed = new EditorProperties(null);
		Propertie propEd = ed.executarAlteracoes(prop, RegrasEnum.MAIUSCULA_ALL);
		
		Assert.assertEquals("", propEd.getValor());
	}
	
	/**
	 * Testa executarAlteracoes MAIUSCULA_ALL OK
	 */
	@Test
	public void executarAlteracoesMAIUSCULA_ALL_ok() {
				
		Propertie prop = new Propertie("arrgh", "urrgh", "zombie");
		
		EditorProperties ed = new EditorProperties(null);
		Propertie propEd = ed.executarAlteracoes(prop, RegrasEnum.MAIUSCULA_ALL);
		
		Assert.assertEquals("ZOMBIE", propEd.getValor());
	}
	
	/**
	 * Testa executarAlteracoes MINUSCULA_ALL null
	 */
	@Test
	public void executarAlteracoesMINUSCULA_ALL_Null() {
				
		Propertie prop = new Propertie("arrgh", "urrgh", null);
		
		EditorProperties ed = new EditorProperties(null);
		Propertie propEd = ed.executarAlteracoes(prop, RegrasEnum.MINUSCULA_ALL);
		
		Assert.assertEquals("", propEd.getValor());
	}
	
	/**
	 * Testa executarAlteracoes MINUSCULA_ALL OK
	 */
	@Test
	public void executarAlteracoesMINUSCULA_ALL_OK() {
				
		Propertie prop = new Propertie("arrgh", "urrgh", "ZOMBIE");
		
		EditorProperties ed = new EditorProperties(null);
		Propertie propEd = ed.executarAlteracoes(prop, RegrasEnum.MINUSCULA_ALL);
		
		Assert.assertEquals("zombie", propEd.getValor());
	}
	
	/**
	 * Testa executarAlteracoes MAIUSCULA_PRIMEIRA_LETRA NULL
	 */
	@Test
	public void executarAlteracoesMAIUSCULA_PRIMEIRA_LETRA_NUll() {
				
		Propertie prop = new Propertie("arrgh", "urrgh", null);
		
		EditorProperties ed = new EditorProperties(new Configuracoes());
		Propertie propEd = ed.executarAlteracoes(prop, RegrasEnum.MAIUSCULA_PRIMEIRA_LETRA);
		
		Assert.assertEquals("", propEd.getValor());
	}
	
	/**
	 * Testa executarAlteracoes MAIUSCULA_PRIMEIRA_LETRA OK
	 */
	@Test
	public void executarAlteracoesMAIUSCULA_PRIMEIRA_LETRA_OK() {
				
		Propertie prop = new Propertie("arrgh", "urrgh", "caro usuário, blabla o chunda é gay");
		
		EditorProperties ed = new EditorProperties(new Configuracoes());
		Propertie propEd = ed.executarAlteracoes(prop, RegrasEnum.MAIUSCULA_PRIMEIRA_LETRA);
		
		Assert.assertEquals("Caro Usuário, Blabla o Chunda é Gay ", propEd.getValor());
	}
}
