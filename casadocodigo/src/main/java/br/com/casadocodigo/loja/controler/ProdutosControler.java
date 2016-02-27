package br.com.casadocodigo.loja.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.daos.ProdutoDao;
import br.com.casadocodigo.loja.models.Produto;

@Controller
public class ProdutosControler {
	@Autowired
	private ProdutoDao dao;

	@RequestMapping("/produtos")
	public String produtos() {
		return "produtos/produtos";
	}

	@RequestMapping("/livros")
	public String livros() {
		return "produtos/livros";
	}

	@RequestMapping("/cadastrar")
	public String cadastrarProduto() {
		return "produtos/cadastrar";
	}

	@RequestMapping("/ok")
	public String cadastrado(Produto produto) {
		dao.gravar(produto);
		return "produtos/ok";
	}
}
