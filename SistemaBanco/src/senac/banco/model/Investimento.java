package senac.banco.model;

import java.sql.Date;
import senac.banco.model.Conta;

public class Investimento {

	private int dataCriacao;

	public int getDataCriacao() {
		return this.getDataCriacao();
	}

	public void setDataCriacao() {
		Date data = new Date(System.currentTimeMillis());
		String dataStr = data.toString();
		dataStr = dataStr.replaceAll("[^\\d.]", "");
		this.dataCriacao = Integer.parseInt(dataStr);
	}

}
