package br.edu.ifpb.pweb2.atena.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.atena.business.model.Aluno;
import br.edu.ifpb.pweb2.atena.business.repository.AlunoRepository;

@Service
public class AlunoService {
	
	private AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService(AlunoRepository repository)
	{
		this.alunoRepository = repository;
	}
	
	public List<Aluno> findAll()
	{
		return this.alunoRepository.findAll();
	}
<<<<<<< HEAD

	 public List<Aluno> getAlunos(){
	        return this.alunoRepository.findAll();
	    }
=======
	

	public void updateNotas(Aluno a)
	{
		this.alunoRepository.save(a);
	}
	
	public Aluno getById(Integer id)
	{
		return this.alunoRepository.getById(id);
	}
	
>>>>>>> d2f2eeac48d7c3d4eaa17a3eadb3a3c7b587b614
}
