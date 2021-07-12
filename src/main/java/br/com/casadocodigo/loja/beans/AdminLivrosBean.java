package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro();
	
	private List <Autor> autores = new ArrayList<Autor>();
	
	@Inject
	private LivroDao dao;
	
	@Inject
	private AutorDao autorDao;
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public List<Autor> getAutores() {
		return autorDao.listar();
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public LivroDao getDao() {
		return dao;
	}

	public void setDao(LivroDao dao) {
		this.dao = dao;
	}

	public AutorDao getAutorDao() {
		return autorDao;
	}

	public void setAutorDao(AutorDao autorDao) {
		this.autorDao = autorDao;
	}
	
	@Transactional
    public String salvar() {
        for (Autor autor : autores) {
        	livro.getAutores().add(autor);
		}
		dao.salvar(livro);
    	System.out.println("Livro salvo com Sucesso!" + this.livro);
    	return "/livros/lista?faces-redirect=true";
    }

}
