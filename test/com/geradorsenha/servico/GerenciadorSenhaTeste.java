package com.geradorsenha.servico;

import org.junit.Assert;
import org.junit.Test;

import com.geradorsenha.model.Categoria;
import com.geradorsenha.model.Funcionario;
import com.geradorsenha.model.Mesa;
import com.geradorsenha.model.Senha;

public class GerenciadorSenhaTeste {

	GerenciadorSenha gerenciador = new GerenciadorSenha();

	@Test
	public void enfilerarSenha_validarCategoria() {
		Senha senha = gerenciador.enfilerarSenha(null);
		Assert.assertNull(senha);
	}

	@Test
	public void enfilerarSenha_validarSenhaNaFila() {
		Senha senha = gerenciador.enfilerarSenha(Categoria.PREFERENCIAL);
		Assert.assertEquals(Categoria.PREFERENCIAL, senha.getCategoria());
		Assert.assertTrue(gerenciador.getFilaSenha().get(Categoria.PREFERENCIAL).contains(senha));

	}

	// @Test
	// public void chamarSenha_validarMesaNaoNula() {
	// Mesa mesa = new Mesa(1, new Funcionario());
	// Mesa mesaPr = new Mesa(2, new Funcionario());
	// Senha senhaPendencia = gerenciador.enfilerarSenha(Categoria.PENDENCIA);
	// Senha senhaPr = gerenciador.enfilerarSenha(Categoria.PREFERENCIAL);
	// Senha senhaPendencia2 = gerenciador.enfilerarSenha(Categoria.PENDENCIA);
	//
	// Senha preimeiraChamada = gerenciador.chamarSenha(mesaPr);
	// Senha segundaChamada = gerenciador.chamarSenha(mesa);
	// Assert.assertNotNull(gerenciador.chamarSenha(mesa).getMesa());
	// Assert.assertEquals(mesaPr.getNumero(),
	// preimeiraChamada.getMesa().getNumero());
	// Assert.assertEquals(mesa.getNumero(), segundaChamada.getMesa().getNumero());
	// }

	@Test
	public void chamarSenha_validarSenhaPreferencialOrden() {
		Mesa mesa = new Mesa(1, new Funcionario());
		Senha senhaPendencia = gerenciador.enfilerarSenha(Categoria.PENDENCIA);
		Senha senharRetirada = gerenciador.enfilerarSenha(Categoria.RETIRADA);
		Senha senharPreferencial = gerenciador.enfilerarSenha(Categoria.PREFERENCIAL);

		Assert.assertEquals(Categoria.PREFERENCIAL, gerenciador.chamarSenha(mesa).getCategoria());
		Assert.assertEquals(Categoria.PENDENCIA, gerenciador.chamarSenha(mesa).getCategoria());
		Assert.assertEquals(Categoria.RETIRADA, gerenciador.chamarSenha(mesa).getCategoria());
	}
}
