package br.com.casadocodigo.loja.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDao;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("produtos")
public class ProdutosControler {
	@Autowired
	private ProdutoDao dao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView produtos() {
		ModelAndView modelAndView = new ModelAndView("produtos/list");
		List<Produto> produtos = dao.listar();
		modelAndView.addObject("produto", produtos);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String gravar(Produto produto) {
		dao.gravar(produto);
		return "produtos/ok";
	}

	@RequestMapping("/livros")
	public String livros() {
		return "produtos/livros";
	}

	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}

}
