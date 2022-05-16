package br.edu.fateczl.ExemploREST.model.dto;

public class MatriculaDTO {

	private AlunoDTO aluno;
	private DisciplinaDTO disciplina;
	
	public AlunoDTO getAluno() {
		return aluno;
	}
	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}
	public DisciplinaDTO getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaDTO disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Matricula [aluno=" + aluno + ", disciplina=" + disciplina + "]";
	}
	
}
