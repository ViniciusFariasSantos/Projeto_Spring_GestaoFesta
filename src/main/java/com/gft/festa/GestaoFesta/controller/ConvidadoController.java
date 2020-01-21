package com.gft.festa.GestaoFesta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gft.festa.GestaoFesta.model.Convidado;
import com.gft.festa.GestaoFesta.repository.Convidados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/convidados")
public class ConvidadoController {
	
	@Autowired
	private Convidados convidados;

	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaConvidados");
		mv.addObject("convidados", convidados.todos());
		mv.addObject(new Convidado());
		return mv;
	}
	@RequestMapping( method = RequestMethod.POST)
	public String salvar(Convidado convidado) {
		this.convidados.adicionar(convidado);
		return "redirect:/convidados";
	}


}
