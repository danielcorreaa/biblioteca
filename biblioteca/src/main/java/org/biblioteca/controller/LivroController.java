package org.biblioteca.controller;

import java.util.List;

import org.biblioteca.dao.CategoriaDAO;
import org.biblioteca.dao.EditoraDAO;
import org.biblioteca.dao.LivroDAO;
import org.biblioteca.modelo.Categoria;
import org.biblioteca.modelo.Editora;
import org.biblioteca.modelo.Livro;
import org.biblioteca.util.BibliotecaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("livros")
public class LivroController {
	
	@Autowired
	private LivroDAO dao;
	
	@Autowired
	private EditoraDAO daoEditora;
	
	@Autowired
	private CategoriaDAO daoCategoria;
	
	@RequestMapping("/form")
	public ModelAndView iniciar(){		
		ModelAndView mv = new ModelAndView("livros/form");
		List<Editora> editoras = daoEditora.listarEditoras();		
		mv.addObject("editoras",editoras);
		List<Categoria> categorias = daoCategoria.listarCategorias();		
		mv.addObject("categorias",categorias);
		return mv;		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Livro livro){
		livro.setCodigo(BibliotecaUtil.gerarCodigoMinimo());
		String msg = dao.salvar(livro);
		System.out.println(msg);
		return new ModelAndView("redirect:livros");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		List<Livro> livros = dao.listaLivros();
		ModelAndView mv = new ModelAndView("livros/lista");
		mv.addObject("livros", livros);
		return mv;		
	}
	
	@RequestMapping("/delete")
	public ModelAndView remover(Integer id){
		ModelAndView mv = new ModelAndView("livros/lista");
		String msg = dao.excluir(id);
		System.out.println(msg);
		return mv;
	}
	
	
}
