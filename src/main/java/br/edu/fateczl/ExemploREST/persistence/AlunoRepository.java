package br.edu.fateczl.ExemploREST.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.ExemploREST.model.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
	
//	public Aluno udf(String ra);
	public Optional<Aluno> findByEmail(String email);
	
}
