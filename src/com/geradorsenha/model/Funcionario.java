package com.geradorsenha.model;

public class Funcionario {

	private Cargo cargo;
	private String nome;

	public Funcionario() {
		super();
	}

	public Funcionario(Cargo cargo, String nome) {
		super();
		this.cargo = cargo;
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + ", nome=" + nome + "]";
	}

}
