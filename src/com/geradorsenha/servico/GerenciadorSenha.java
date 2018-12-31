package com.geradorsenha.servico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.geradorsenha.model.Categoria;
import com.geradorsenha.model.Mesa;
import com.geradorsenha.model.Senha;

public class GerenciadorSenha {

	private GerarSenha geradorSenha;
	private Map<Categoria, LinkedList<Senha>> filaSenha;

	public GerenciadorSenha(GerarSenha geradorSenha) {
		this.geradorSenha = geradorSenha;
		this.filaSenha = new HashMap<>();
	}

	public GerenciadorSenha() {
		this(new GeradorSenha());
	}

	public GerarSenha getGeradorSenha() {
		return geradorSenha;
	}

	public void setGeradorSenha(GerarSenha geradorSenha) {
		this.geradorSenha = geradorSenha;
	}

	public Map<Categoria, LinkedList<Senha>> getFilaSenha() {
		return filaSenha;
	}

	public void setFilaSenha(Map<Categoria, LinkedList<Senha>> filaSenha) {
		this.filaSenha = filaSenha;
	}

	public Senha enfilerarSenha(Categoria categoria) {
		if (categoria == null) {
			return null;
		}
		Senha senha = geradorSenha.gerarSenha(categoria);
		LinkedList<Senha> lista = filaSenha.get(categoria);
		if (lista == null) {
			lista = new LinkedList<>();
		}
		lista.add(senha);
		filaSenha.put(categoria, lista);
		return senha;
	}

	public Senha chamarSenha(Mesa mesa) {
		LinkedList<Senha> listaPreferencial = filaSenha.get(Categoria.PREFERENCIAL);
		List<Senha> listaPrimeiros = new ArrayList<>();

		if (listaPreferencial != null && !listaPreferencial.isEmpty()) {
			Senha senha = listaPreferencial.getFirst();
			senha.setMesa(mesa);
			filaSenha.get(Categoria.PREFERENCIAL).remove(senha);
			return senha;
		}
		if (listaPreferencial.isEmpty()) {
			for (Categoria categoria : filaSenha.keySet()) {
				if (!Categoria.PREFERENCIAL.equals(categoria)) {
					if (filaSenha.get(categoria) != null && !filaSenha.get(categoria).isEmpty()) {
						listaPrimeiros.add(filaSenha.get(categoria).getFirst());
					}
				}
			}
		}

		if (listaPrimeiros.isEmpty()) {
			return null;
		}
		listaPrimeiros.sort(Comparator.comparing(new Function<Senha, LocalDateTime>() {
			@Override
			public LocalDateTime apply(Senha senha) {
				return senha.getData();
			}
		}));
		Senha senhaP = listaPrimeiros.get(0);
		senhaP.setMesa(mesa);
		filaSenha.get(senhaP.getCategoria()).remove(senhaP);

		return senhaP;
	}
}
