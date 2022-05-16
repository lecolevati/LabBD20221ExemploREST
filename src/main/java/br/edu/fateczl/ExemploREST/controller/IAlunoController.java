package br.edu.fateczl.ExemploREST.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.edu.fateczl.ExemploREST.model.dto.AlunoDTO;
import br.edu.fateczl.ExemploREST.model.entity.Aluno;

public interface IAlunoController {

	public List<AlunoDTO> buscarAlunos();
	public ResponseEntity<AlunoDTO> buscarAluno(String ra);
	public ResponseEntity<AlunoDTO> buscarAlunoPorEmail(String email);
	public ResponseEntity<String> insereAluno(Aluno aluno);
	public ResponseEntity<String> atualizaAluno(Aluno aluno);
	public ResponseEntity<String> excluiAluno(Aluno aluno);
	
}
