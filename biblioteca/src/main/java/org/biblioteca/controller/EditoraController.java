package org.biblioteca.controller;

import java.util.List;

import org.biblioteca.dao.EditoraDAO;
import org.biblioteca.modelo.Editora;
import org.biblioteca.util.BibliotecaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("editoras")
public class EditoraController {
	
	@Autowired
	private EditoraDAO dao;
	
	@RequestMapping("/form")
	public ModelAndView iniciar(){		
		ModelAndView mv = new ModelAndView("editoras/form");
		return mv;		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Editora editora){
		editora.setCodigo(BibliotecaUtil.gerarCodigoMinimo());
		String msg = dao.salvar(editora);
		System.out.println(msg);
		return new ModelAndView("redirect:editoras");
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		List<Editora> editoras = dao.listarEditoras();
		ModelAndView mv = new ModelAndView("editoras/lista");
		mv.addObject("editoras", editoras);
		return mv;		
	}
	@RequestMapping("/delete")
	public ModelAndView remover(Integer id){
		ModelAndView mv = new ModelAndView("editoras/lista");
		String msg = dao.excluir(id);
		System.out.println(msg);
		return mv;
	}

	
}
