package com.qi.appcadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.qi.appcadastro.model.Corrida;
import com.qi.appcadastro.repository.CorridaRepository;

@Service
@Transactional
@Controller
public class CorridaController {
	
	@Autowired
	private CorridaRepository rep;
	
	public List<Corrida> listarTodos() {
		return this.rep.findAll();
	}
	
	public void salvar(Corrida cor) {
		this.rep.save(cor);
	}
	
	public Corrida getCorrida(long id) {
		return this.rep.findById(id).get();
	}
	
	public void excluir(long id) {
		this.rep.deleteById(id);
	}
	
	@RequestMapping("/home")
	public String chamarLista(Model modelo) {
		List<Corrida> listaCorrida = this.listarTodos();
		modelo.addAttribute("listaCorrida", listaCorrida);
		return "home";
	}
	
	@RequestMapping("/")
	public String chamarIndex() {
		return "index";
	}
	
	@RequestMapping("/novo")
	public ModelAndView chamarNovo() {
		ModelAndView modelo = new ModelAndView("novo");
		Corrida objCorrida = new Corrida();
		modelo.addObject("corrida", objCorrida);
		return modelo;
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView chamarEditar(@PathVariable(name = "id") long id) {
		ModelAndView modelo  = new ModelAndView("editar");
		Corrida objCorrida = this.getCorrida(id);
		modelo.addObject("corrida",objCorrida);
		return modelo;
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String chamarSalvar(@ModelAttribute("corrida") Corrida objCorrida) {
		this.salvar(objCorrida);
		return "redirect:/home";
	}
	
	@RequestMapping("/excluir/{id}")
	public String chamarExcluir(@PathVariable(name = "id") long id) {
		this.excluir(id);
		return "redirect:/home";
	}
	
	
	
	
}
