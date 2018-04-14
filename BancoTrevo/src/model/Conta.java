package model;

public class Conta {

	private int idCliente;
	private int idConta;
	private String numeroConta;
	private String agenciaConta;
	private String tipoConta;

	// Metodo ToString
	@Override
	public String toString() {
		return "Conta [idCliente=" + idCliente + ", idConta=" + idConta + ", numeroConta=" + numeroConta
				+ ", agenciaConta=" + agenciaConta + ", tipoConta=" + tipoConta + "]";
	}

	// Metodo Construtor
	public Conta(int idCliente, int idConta, String numeroConta, String agenciaConta, String tipoConta) {
		super();
		this.idCliente = idCliente;
		this.idConta = idConta;
		this.numeroConta = numeroConta;
		this.agenciaConta = agenciaConta;
		this.tipoConta = tipoConta;
	}

	// Metodos Get's e Set's
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getAgenciaConta() {
		return agenciaConta;
	}

	public void setAgenciaConta(String agenciaConta) {
		this.agenciaConta = agenciaConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

}
