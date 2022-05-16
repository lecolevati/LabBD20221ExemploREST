package br.edu.fateczl.ExemploREST.model.entity;

import java.io.Serializable;

public class MatriculaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Aluno aluno;
	private Disciplina disciplina;
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Matricula [aluno=" + aluno + ", disciplina=" + disciplina + "]";
	}

}
