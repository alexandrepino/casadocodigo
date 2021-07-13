package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class AdminListaLivrosBean {
	
	@Inject
	private LivroDao dao;
	
	
	private List<Livro> livros = new ArrayList<Livro>();

	public List<Livro> getLivros() {
		
		this.livros = dao.listar();
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	
	
	
	

}
