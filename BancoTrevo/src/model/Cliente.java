package model;

public class Cliente {

	// Atributos
	private int idCliente;
	private String cpfCliente;
	private String nomeCliente;
	private String senhaCLiente;

	// Metodo ToString
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", cpfCliente=" + cpfCliente + ", nomeCliente=" + nomeCliente
				+ ", senhaCLiente=" + senhaCLiente + "]";
	}

	// Metodo Construtor
	public Cliente(int idCliente, String cpfCliente, String nomeCliente, String senhaCLiente) {
		super();
		this.idCliente = idCliente;
		this.cpfCliente = cpfCliente;
		this.nomeCliente = nomeCliente;
		this.senhaCLiente = senhaCLiente;
	}

	// Metodos Get's e Set's
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getSenhaCLiente() {
		return senhaCLiente;
	}

	public void setSenhaCLiente(String senhaCLiente) {
		this.senhaCLiente = senhaCLiente;
	}

}
