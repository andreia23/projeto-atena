package br.edu.ifpb.pweb2.atena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.atena.business.model.Aluno;
import br.edu.ifpb.pweb2.atena.business.model.Situations;
import br.edu.ifpb.pweb2.atena.business.service.AlunoService;
import br.edu.ifpb.pweb2.atena.form.NotasForm;



@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoservice;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView modelAndView) {
		modelAndView.setViewName("aluno/list");
		try {
			List<Aluno> alunos = alunoservice.findAll();
			modelAndView.addObject("alunos", alunos);
		} catch (Exception e) {
			modelAndView.addObject("mensagem", e.getMessage());
		}
		return modelAndView;
	}
	
	@RequestMapping("/new")
	public ModelAndView getFormAluno(ModelAndView modelAndView)
	{
		modelAndView.setViewName("aluno/form");
		modelAndView.addObject("aluno", new Aluno());
		return modelAndView;
	}
	
	@RequestMapping(value="/new", params={"salvar"}, method= RequestMethod.POST)
	public ModelAndView salvarAluno(ModelAndView modelAndView, Aluno a)
	{
		modelAndView.setViewName("redirect:/aluno");
		this.alunoservice.salvar(a);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}")
	public ModelAndView getFormAlunoEditar(@PathVariable("id") Integer id, ModelAndView modelAndView)
	{
		Aluno a = this.alunoservice.getById(id);
		modelAndView.setViewName("aluno/form");
		modelAndView.addObject("aluno", a);
		return modelAndView;
	}
	
	@RequestMapping(value="/remove/{id}")
	public ModelAndView getFormAlunoRemover(@PathVariable("id") Integer id, ModelAndView modelAndView)
	{
		this.alunoservice.deletar(id);
		modelAndView.setViewName("redirect:/aluno/");
		return modelAndView;
	}
	
	@RequestMapping("/notas")
	public ModelAndView getFormNotas(ModelAndView modelAndView) {
		modelAndView.setViewName("aluno/notas");
		try {
			List<Aluno> alunos = alunoservice.findAll();
			NotasForm notas = new NotasForm();
			notas.setAlunos(alunos);
			modelAndView.addObject("notas", notas);
			modelAndView.addObject("alunos", alunos);
		} catch (Exception e) {
			modelAndView.addObject("mensagem", e.getMessage());
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/notas", params={"salvar"}, method= RequestMethod.POST)
	public ModelAndView salvarNotas(ModelAndView modelAndView, NotasForm notasForm)
	{
		modelAndView.setViewName("redirect:/aluno/notas");
		try {
			for(Aluno a : notasForm.getAlunos())
			{
				if(a.getDataNascimento() == null)
				{
					Aluno b = this.alunoservice.getById(a.getId());
					a.setDataNascimento(b.getDataNascimento());
				}
				
				Double media = a.getMedia();
	            if (a.getNotaFinal() != null && media != null) {
	                double nota = ((media * 60) + (a.getNotaFinal().doubleValue() * 40)) / 100;
	                if (nota >= 50) {
	                    a.setSituacao(Situations.AP);
	                } else {
	                    a.setSituacao(Situations.RP);
	                }
	            } else if (a.getFaltas() != null) {
	                if (a.getFaltas() >= 25) {
	                    a.setSituacao(Situations.RF);
	                } else if (media != null) {
	                    if (media < 40) {
	                        a.setSituacao(Situations.RP);
	                    } else if (media < 70) {
	                        a.setSituacao(Situations.FN);
	                    } else {
	                        a.setSituacao(Situations.AP);
	                    }
	                }
	            }
				this.alunoservice.salvar(a);
			}
			
		}catch(Exception e)
		{
			modelAndView.addObject("mensagem", e.getMessage());
		}
		
		return modelAndView;
	}

}
