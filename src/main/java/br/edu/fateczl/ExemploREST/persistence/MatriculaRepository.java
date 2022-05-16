package br.edu.fateczl.ExemploREST.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.ExemploREST.model.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, String> {

}
