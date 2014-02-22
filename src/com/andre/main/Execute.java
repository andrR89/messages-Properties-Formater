package com.andre.main;

import java.io.IOException;

import com.andre.util.LeitorArquivo;

public class Execute {

	/**
	 * Executar.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		LeitorArquivo l = new LeitorArquivo("Arquivos/Testes/server-links-uteis.txt");
		System.out.println(l.getConteudoArquivo());
	}
}
