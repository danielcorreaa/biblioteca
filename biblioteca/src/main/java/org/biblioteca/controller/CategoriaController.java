package org.biblioteca.controller;

import java.util.List;

import org.biblioteca.dao.CategoriaDAO;
import org.biblioteca.modelo.Categoria;
import org.biblioteca.util.BibliotecaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaDAO dao;
	
	@RequestMapping("/form")
	public ModelAndView iniciar(){		
		ModelAndView mv = new ModelAndView("categorias/form");
		return mv;		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Categoria categoria){
		categoria.setCodigo(BibliotecaUtil.gerarCodigo());
		String msg = dao.salvar(categoria);
		System.out.println(msg);
		return new ModelAndView("redirect:categorias");
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		List<Categoria> categorias = dao.listarCategorias();
		ModelAndView mv = new ModelAndView("categorias/lista");
		mv.addObject("categorias", categorias);
		return mv;		
	}
	@RequestMapping("/delete")
	public ModelAndView remover(Integer id){
		ModelAndView mv = new ModelAndView("categorias/lista");
		String msg = dao.excluir(id);
		System.out.println(msg);
		return mv;
	}

	
}
