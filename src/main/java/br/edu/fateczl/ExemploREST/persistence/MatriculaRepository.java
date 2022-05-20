package br.edu.fateczl.ExemploREST.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.ExemploREST.model.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, String> {

	public List<Matricula> findByDisciplinaCodigo(int codigo);
	
}
