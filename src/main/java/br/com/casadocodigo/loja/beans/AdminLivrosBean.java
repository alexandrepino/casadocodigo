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
	
	private List <Integer> autoresId = new ArrayList<Integer>();
	
	@Inject
	private LivroDao dao;
	@Inject
	private AutorDao autorDao;

	
	@Transactional
    public void salvar() {
        for (Integer autorId : autoresId) {
        	livro.getAutores().add(new Autor(autorId));
			
		}
		dao.salvar(livro);
    	System.out.println("Livro salvo com Sucesso!" + this.livro);
    	
    	this.livro = new Livro();
        
    }

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public List<Autor>getAutores(){
		return autorDao.listar();
		
		
	}
    
    

}
