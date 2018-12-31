package com.geradorsenha.servico;

import java.time.LocalDateTime;

import com.geradorsenha.model.Categoria;
import com.geradorsenha.model.Senha;

public class GeradorSenha implements GerarSenha {

	private static int SENHA_PENDENCIA = 0;
	private static int SENHA_PREFERENCIAL = 0;
	private static int SENHA_AGENDAMENTO = 0;
	private static int SENHA_RETIRADA = 0;

	public static int getSENHA_PENDENCIA() {
		return SENHA_PENDENCIA;
	}

	public static int getSENHA_PREFERENCIAL() {
		return SENHA_PREFERENCIAL;
	}

	public static int getSENHA_AGENDAMENTO() {
		return SENHA_AGENDAMENTO;
	}

	public static int getSENHA_RETIRADA() {
		return SENHA_RETIRADA;
	}

	public static int gerarRetirada() {
		SENHA_RETIRADA = SENHA_RETIRADA + 1;
		return SENHA_RETIRADA;
	}

	public static int gerarPendencia() {
		SENHA_PENDENCIA = SENHA_PENDENCIA + 1;
		return SENHA_PENDENCIA;
	}

	public static int gerarAgendamento() {
		SENHA_AGENDAMENTO = SENHA_AGENDAMENTO + 1;
		return SENHA_AGENDAMENTO;
	}

	public static int gerarPreferencial() {
		SENHA_PREFERENCIAL = SENHA_PREFERENCIAL + 1;
		return SENHA_PREFERENCIAL;
	}

	@Override
	public Senha gerarSenha(Categoria categoria) {

		if (categoria != null) {
			Senha senha = new Senha();
			senha.setData(LocalDateTime.now());

			if (Categoria.PENDENCIA.equals(categoria)) {
				senha.setCategoria(categoria);
				senha.setNumero("PN" + this.gerarPendencia());
			} else if (Categoria.PREFERENCIAL.equals(categoria)) {
				senha.setCategoria(categoria);
				senha.setNumero("PR" + this.gerarPreferencial());
			} else if (Categoria.AGENDAMENTO.equals(categoria)) {
				senha.setCategoria(categoria);
				senha.setNumero("AG" + this.gerarAgendamento());
			} else if (Categoria.RETIRADA.equals(categoria)) {
				senha.setCategoria(categoria);
				senha.setNumero("RT" + this.gerarRetirada());
			}

			return senha;
		}
		return null;
	}

}
