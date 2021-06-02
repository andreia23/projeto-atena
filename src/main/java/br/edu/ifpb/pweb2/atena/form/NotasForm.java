package br.edu.ifpb.pweb2.atena.form;

import java.util.List;

import br.edu.ifpb.pweb2.atena.business.model.Aluno;

public class NotasForm {
	private List<Aluno> alunos;
	
	public List<Aluno> getAlunos()
	{
		return this.alunos;
	}
	
	public void setAlunos(List<Aluno> alns)
	{
		this.alunos = alns;
	}
}
