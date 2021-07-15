package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
@ManagedBean(value = "adminLivrosBean")
public class AdminLivrosBean {

	private Livro livro = new Livro();

	@Inject
	private LivroDao dao;
	
	

	@Inject
	private AutorDao autorDao;
	
	@Inject
	private FacesContext cont;

	

	public AdminLivrosBean() {

		cont = FacesContext.getCurrentInstance();
	}

	@Transactional
	public String salvar() {
		
		dao.salvar(livro);
		cont.getExternalContext().getFlash().setKeepMessages(true);
		cont.addMessage(null, new FacesMessage("Livro Cadastrado com Sucesso!!!!"));

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
