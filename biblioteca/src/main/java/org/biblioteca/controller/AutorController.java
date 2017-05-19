package org.biblioteca.controller;

import java.util.List;

import org.biblioteca.dao.AutorDAO;
import org.biblioteca.modelo.Autor;
import org.biblioteca.util.BibliotecaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("autores")
public class AutorController {
	
	@Autowired
	private AutorDAO dao;
	
	@RequestMapping("/form")
	public ModelAndView iniciar(){		
		ModelAndView mv = new ModelAndView("autores/form");
		return mv;		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Autor autor){
		autor.setCodigo(BibliotecaUtil.gerarCodigo());
		String msg = dao.salvar(autor);
		System.out.println(msg);
		return new ModelAndView("redirect:autores");
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		List<Autor> autores = dao.listarAutores();
		ModelAndView mv = new ModelAndView("autores/lista");
		mv.addObject("autores", autores);
		return mv;		
	}
	@RequestMapping("/delete")
	public ModelAndView remover(Integer id){
		ModelAndView mv = new ModelAndView("autores/lista");
		String msg = dao.excluir(id);
		System.out.println();
		return mv;
	}

}
