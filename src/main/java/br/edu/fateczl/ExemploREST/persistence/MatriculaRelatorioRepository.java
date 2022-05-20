package br.edu.fateczl.ExemploREST.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.fateczl.ExemploREST.model.entity.MatriculaRelatorio;

public interface MatriculaRelatorioRepository extends JpaRepository<MatriculaRelatorio, Integer>  {

	@Query(value = "SELECT al.ra AS ra_aluno, al.nome AS nome_aluno, al.email AS email_aluno, "
			+ "	disc.codigo AS codigo_disciplina, disc.nome AS nome_disciplina "
			+ " FROM aluno al, matricula mat, disciplina disc "
			+ " WHERE al.ra = mat.ra_aluno "
			+ "	AND disc.codigo = mat.codigo_disciplina "
			+ "	AND disc.codigo = ?1 "
			+ "	ORDER BY ra_aluno",
			nativeQuery = true)
	public List<MatriculaRelatorio> geraLista(int codigo);
	
}
