package com.andre.main;

import java.io.IOException;

import javax.swing.JFileChooser;

public class Execute {

	/**
	 * Executar.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		JFileChooser abrir = new JFileChooser();
		int retorno = abrir.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION)
			abrir.getSelectedFile().getAbsolutePath();
	}
}
