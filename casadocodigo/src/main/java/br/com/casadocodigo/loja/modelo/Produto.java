package br.com.casadocodigo.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	private Integer paginas;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getPaginas() {
		return paginas;
	}
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.titulo + "\nDescrição: " + this.descricao + "\nPáginas: " + this.paginas;
	}

}
