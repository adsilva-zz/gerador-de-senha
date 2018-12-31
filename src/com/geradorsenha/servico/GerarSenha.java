package com.geradorsenha.servico;

import com.geradorsenha.model.Categoria;
import com.geradorsenha.model.Senha;

public interface GerarSenha {

	public Senha gerarSenha(Categoria categoria);
}
