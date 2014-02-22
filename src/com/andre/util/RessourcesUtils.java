package com.andre.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 
 * @author andre.
 * 
 */
public final class RessourcesUtils {

	/**
	 * Fecha os recursos READER.
	 */
	public static void closeRessources(Closeable... closeables) {
		try {
			if (closeables != null) {
				for (Closeable closer : closeables) {
					if (closer != null) {
						closer.close();
					}
				}
			}

		} catch (IOException e) {
			throw new IllegalArgumentException("Impossivel fechar os buffers");
		}
	}
}
