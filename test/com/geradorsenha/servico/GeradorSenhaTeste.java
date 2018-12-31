package com.geradorsenha.servico;

import com.geradorsenha.model.Categoria;
import com.geradorsenha.model.Senha;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

public class GeradorSenhaTeste {

	GerarSenha gerador = new GeradorSenha();

	@Test
	public void gerarSenha_validarPorCategorias() {
		Senha senhaAg = gerador.gerarSenha(Categoria.AGENDAMENTO);
		Assert.assertEquals(Categoria.AGENDAMENTO, senhaAg.getCategoria());

		Senha senhaPd = gerador.gerarSenha(Categoria.PENDENCIA);
		Assert.assertEquals(Categoria.PENDENCIA, senhaPd.getCategoria());

		Senha senhaPr = gerador.gerarSenha(Categoria.PREFERENCIAL);
		Assert.assertEquals(Categoria.PREFERENCIAL, senhaPr.getCategoria());

		Senha senhaRt = gerador.gerarSenha(Categoria.RETIRADA);
		Assert.assertEquals(Categoria.RETIRADA, senhaRt.getCategoria());

	}

	@Test
	public void gerarSenha_validarCategoriaValida() {
		Senha senha = gerador.gerarSenha(null);
		Assert.assertNull(senha);
	}

	@Test
	public void gerarSenha_validarDataTime() {
		LocalDateTime now = LocalDateTime.now();
		Senha senha = gerador.gerarSenha(Categoria.RETIRADA);

		Assert.assertNotNull(senha.getData());
		Assert.assertFalse(now.isAfter(senha.getData()));

	}

	@Test
	public void gerarSenha_validarNumeroSenhaComSucesso() {
		Senha senhaAgPrimeira = gerador.gerarSenha(Categoria.AGENDAMENTO);
		Senha senhaAgSegunda = gerador.gerarSenha(Categoria.AGENDAMENTO);

		Senha senhaPdPrimeira = gerador.gerarSenha(Categoria.PENDENCIA);
		Senha senhaPdSegunda = gerador.gerarSenha(Categoria.PENDENCIA);

		Senha senhaPrPrimeira = gerador.gerarSenha(Categoria.PREFERENCIAL);
		Senha senhaPrSegunda = gerador.gerarSenha(Categoria.PREFERENCIAL);

		Senha senhaRtPrimeira = gerador.gerarSenha(Categoria.RETIRADA);
		Senha senhaRtSegunda = gerador.gerarSenha(Categoria.RETIRADA);

		Assert.assertNotEquals(senhaAgPrimeira.getNumero(), senhaAgSegunda.getNumero());
		Assert.assertNotEquals(senhaPdPrimeira.getNumero(), senhaPdSegunda.getNumero());
		Assert.assertNotEquals(senhaPrPrimeira.getNumero(), senhaPrSegunda.getNumero());
		Assert.assertNotEquals(senhaRtPrimeira.getNumero(), senhaRtSegunda.getNumero());
	}
}
