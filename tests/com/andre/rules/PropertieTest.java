package com.andre.rules;

import org.junit.Assert;
import org.junit.Test;

public class PropertieTest {

	/**
	 * Testa se o metodo getPropertie com paramentro null.
	 */
	@Test
	public void getPropertieNull() {
		Assert.assertTrue(Propertie.getPropertie(null) == null);
	}

	/**
	 * Testa se o metodo getPropertie com paramentro "Não Propertie".
	 */
	@Test
	public void getPropertieFalse() {
		Assert.assertTrue(Propertie.getPropertie("Arrgh") == null);
	}

	/**
	 * Testa se o metodo getPropertie com paramentro "Não Propertie".
	 */
	@Test
	public void getPropertieOK() {
		Assert.assertTrue(Propertie.getPropertie("xxx=yyy") != null);
	}

	/**
	 * Testa se o metodo getPropertie com paramentro "Não Propertie".
	 */
	@Test
	public void getPropertieALlFieldsOK() {
		Propertie p = Propertie.getPropertie("x.xxx.x=yyy");
		Assert.assertTrue(p.getPrefixo().trim().equals("x"));
		Assert.assertTrue(p.getNome().trim().equals("xxx.x"));
		Assert.assertTrue(p.getValor().trim().equals("yyy"));
	}

	/**
	 * Testa se o metodo getPropertie com paramentro "Não Propertie".
	 */
	@Test
	public void getPropertieSemPrefixo() {
		Propertie p = Propertie.getPropertie("xxxx=yyy");
		Assert.assertTrue(p.getPrefixo().trim().equals(""));
		Assert.assertTrue(p.getNome().trim().equals("xxxx"));
		Assert.assertTrue(p.getValor().trim().equals("yyy"));
	}

	/**
	 * Testao que vem no toString.
	 */
	@Test
	public void testToStringSemPrefixo() {
		Propertie p = Propertie.getPropertie("xxxx=yyy");
		Assert.assertEquals("xxxx = yyy", p.toString());
	}

	/**
	 * Testa o que vem no toString.
	 */
	@Test
	public void testToStringComPrefixo() {
		Propertie p = new Propertie(" zombie ", " urrgh ", "arrgh");
		Assert.assertEquals("zombie.urrgh = arrgh", p.toString());
	}

	/**
	 * Testa o que vem no toString quando valores são nullos..
	 */
	@Test
	public void testToStringNull() {
		Propertie p = new Propertie(" zombie ", null, "arrgh");
		Assert.assertEquals("", p.toString());
	}

}
