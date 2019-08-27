package br.com.casadocodigo.loja.validacao;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.modelo.Produto;

public class ProdutoValidacao implements Validator{
	
//	public void valida(Produto produto, Errors errors) {
//		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
//		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
//		
//		if(produto.getPaginas() <= 0) {
//			errors.rejectValue("paginas", "field.required");
//		}
//	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Produto produto = (Produto) target;
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		
		if(produto.getPaginas() <= 0){
            errors.rejectValue("paginas", "field.required");
        }
		
	}

}
