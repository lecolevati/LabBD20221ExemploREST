package br.edu.fateczl.ExemploREST.controller;

import java.util.List;

import br.edu.fateczl.ExemploREST.model.dto.MatriculaDTO;
import br.edu.fateczl.ExemploREST.model.dto.MatriculaRelatorioDTO;

public interface IMatriculaController {

	public List<MatriculaDTO> buscarMatriculas();
	public List<MatriculaDTO> buscarMatricula(int codigo);
	public List<MatriculaRelatorioDTO> listaMatricula(int codigo);
	
}
