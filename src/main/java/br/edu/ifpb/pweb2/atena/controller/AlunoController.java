package br.edu.ifpb.pweb2.atena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.atena.business.model.Aluno;
import br.edu.ifpb.pweb2.atena.business.service.AlunoService;


@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoservice;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getForm(ModelAndView modelAndView) {
		modelAndView.setViewName("aluno/list");
		try {
			List<Aluno> alunos = alunoservice.findAll();
			modelAndView.addObject("alunos", alunos);
		} catch (Exception e) {
			modelAndView.addObject("mensagem", e.getMessage());
		}
		return modelAndView;
	}
	
	
	
}
