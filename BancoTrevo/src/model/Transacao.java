package model;

import java.time.LocalDate;

public class Transacao {

	private int idConta;
	private int idTransacao;
	private LocalDate dataTransacao;
	private String tipoTransacao;
	private float valorTransacao;

	// Metodo ToString
	@Override
	public String toString() {
		return "Transacao [idConta=" + idConta + ", idTransacao=" + idTransacao + ", dataTransacao=" + dataTransacao
				+ ", tipoTransacao=" + tipoTransacao + ", valorTransacao=" + valorTransacao + "]";
	}

	// Metodo Construtor
	public Transacao(int idConta, int idTransacao, LocalDate dataTransacao, String tipoTransacao,
			float valorTransacao) {
		super();
		this.idConta = idConta;
		this.idTransacao = idTransacao;
		this.dataTransacao = dataTransacao;
		this.tipoTransacao = tipoTransacao;
		this.valorTransacao = valorTransacao;
	}

	// Metodos Get's e Set's
	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public int getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}

	public LocalDate getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(LocalDate dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public float getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(float valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

}
