package com.geradorsenha.model;

public class Mesa {

	private int numero;
	private Funcionario funcionario;

	public Mesa() {
		super();
	}

	public Mesa(int numero, Funcionario funcionario) {
		super();
		this.numero = numero;
		this.funcionario = funcionario;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Mesa [numero=" + numero + ", funcionario=" + funcionario + "]";
	}

}
