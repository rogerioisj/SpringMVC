package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.modelo.Produto;
import br.com.casadocodigo.loja.modelo.UtilitarioProduto.TipoPreco;
import br.com.casadocodigo.loja.validacao.ProdutoValidacao;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;

	@Autowired
	private FileSaver fileSaver;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidacao());
	}

	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
		ModelAndView mAV = new ModelAndView("produtos/form");
		mAV.addObject("tipos", TipoPreco.values());
		return mAV;
	}

	@RequestMapping(method = RequestMethod.POST)
	@CacheEvict(value = "prosutosHome", allEntries = true)
	public ModelAndView grava(MultipartFile sumario, @Valid Produto produto, BindingResult result,
			RedirectAttributes redirectAttributes) {

		System.out.println(sumario.getOriginalFilename());
		if (result.hasErrors()) {
			return form(produto);
		}

		String path = fileSaver.write("arquivos-sumario", sumario);

		System.out.println(path);
		produto.setSumarioPath(path);

		System.out.println(produto);
		produtoDAO.gravar(produto);

		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDAO.listar();
		ModelAndView mAV = new ModelAndView("produtos/lista");
		mAV.addObject("produtos", produtos);
		return mAV;
	}

	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		ModelAndView detalhe = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDAO.find(id);
		System.out.println(produto);
		detalhe.addObject("produto", produto);
		return detalhe;
	}

//	@RequestMapping("/{id}")
//	@ResponseBody
//	public Produto detalheJSON(@PathVariable("id") Integer id) {
//		return produtoDAO.find(id);
//	}

}
