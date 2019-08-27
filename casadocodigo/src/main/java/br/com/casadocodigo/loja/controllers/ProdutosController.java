package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.modelo.Produto;
import br.com.casadocodigo.loja.modelo.UtilitarioProduto.TipoPreco;
import br.com.casadocodigo.loja.validacao.ProdutoValidacao;

@Controller
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidacao());
	}

	@RequestMapping("/produtos/form")
	public ModelAndView form() {
		ModelAndView mAV = new ModelAndView("produtos/form");
		mAV.addObject("tipos", TipoPreco.values());
		return mAV;
	}

	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public ModelAndView grava(@Valid Produto produto,BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()){
			return form();
		}
		System.out.println(produto);
		produtoDAO.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(value="/produtos", method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDAO.listar();
		ModelAndView mAV = new ModelAndView("produtos/lista");
		mAV.addObject("produtos", produtos);
		return mAV;
	}

}
