package com.geradorsenha.model;

import java.time.LocalDateTime;

public class Senha {

	private LocalDateTime data;
	private Categoria categoria;
	private String numero;
	private Mesa mesa;

	public Senha() {
		super();
	}

	@Override
	public String toString() {
		return "Senha [data=" + data + ", categoria=" + categoria + ", numero=" + numero + ", mesa=" + mesa + "]";
	}

	public Senha(LocalDateTime data, Categoria categoria, String numero, Mesa mesa) {
		super();
		this.data = data;
		this.categoria = categoria;
		this.numero = numero;
		this.mesa = mesa;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}
