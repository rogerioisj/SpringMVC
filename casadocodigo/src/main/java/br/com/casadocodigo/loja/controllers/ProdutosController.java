package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.modelo.Produto;
import br.com.casadocodigo.loja.modelo.UtilitarioProduto.TipoPreco;

@Controller
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;

	@RequestMapping("/produtos/form")
	public ModelAndView form() {
		ModelAndView mAV = new ModelAndView("produtos/form");
		mAV.addObject("tipos", TipoPreco.values());
		return mAV;
	}

	@RequestMapping("/produtos")
	public String grava(Produto produto) {
		System.out.println(produto);
		produtoDAO.gravar(produto);
		return "produtos/cadastrado";
	}

}
