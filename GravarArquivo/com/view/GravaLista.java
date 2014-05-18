package com.view;

import java.io.FileWriter;
import java.io.IOException;

public class GravaLista {

	private FileWriter arquivo;

	public void ContatoSalvar(String filename) {
		try {
			arquivo = new FileWriter(filename);
		} catch (IOException e) {
			e.printStackTrace();
			arquivo = null;
		}
	}

	public void gravar(String msg) {
		if (arquivo == null)
			return;
		try {
			arquivo.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (arquivo == null)
			return;
		try {
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
