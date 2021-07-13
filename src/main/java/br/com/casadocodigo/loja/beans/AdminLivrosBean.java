package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
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
@ManagedBean(value="adminLivrosBean")
public class AdminLivrosBean {
	
	private Livro livro = new Livro();
	
	@Inject
	private LivroDao dao;
	
	@Inject
	private AutorDao autorDao;

	private List<Integer> autoresId = new ArrayList<>();
	
	@Transactional
    public String salvar() {
        for (Integer autorId : autoresId) {
        	livro.getAutores().add(new Autor(autorId));
		}
		dao.salvar(livro);
    	System.out.println("Livro salvo com Sucesso!!!" + livro);
    	this.livro = new Livro();
    	this.autoresId = new ArrayList<>();
        return "/livros/lista?faces-redirect=true";
    }
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public List<Autor> getAutores() {
		return autorDao.listar();
	}
	
	

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
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
	


}
