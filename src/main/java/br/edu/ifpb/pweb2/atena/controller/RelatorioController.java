package br.edu.ifpb.pweb2.atena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.atena.business.model.Aluno;
import br.edu.ifpb.pweb2.atena.business.service.AlunoService;

@Controller
@RequestMapping(value = "/relatorio")
public class RelatorioController {
	
	@Autowired
    private AlunoService alunoService;

	    
	    @RequestMapping
	    public ModelAndView relatorio(ModelAndView modelAndView) {
	        modelAndView.setViewName("relatorio");
	        List<Aluno> alunos = alunoService.getAlunos();
	        System.out.println(alunos); 
	        modelAndView.addObject("alunos", alunos);

	        return modelAndView;
	    }
	    


	}



