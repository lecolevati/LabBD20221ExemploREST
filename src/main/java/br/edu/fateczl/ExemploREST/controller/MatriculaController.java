package br.edu.fateczl.ExemploREST.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.ExemploREST.model.dto.AlunoDTO;
import br.edu.fateczl.ExemploREST.model.dto.DisciplinaDTO;
import br.edu.fateczl.ExemploREST.model.dto.MatriculaDTO;
import br.edu.fateczl.ExemploREST.model.dto.MatriculaRelatorioDTO;
import br.edu.fateczl.ExemploREST.model.entity.Matricula;
import br.edu.fateczl.ExemploREST.model.entity.MatriculaRelatorio;
import br.edu.fateczl.ExemploREST.persistence.MatriculaRelatorioRepository;
import br.edu.fateczl.ExemploREST.persistence.MatriculaRepository;

@RestController
@RequestMapping("/rest")
public class MatriculaController implements IMatriculaController {

	@Autowired
	MatriculaRepository mRep;

	@Autowired
	MatriculaRelatorioRepository mrRep;
	
	@Override
	@GetMapping("/matricula")
	public List<MatriculaDTO> buscarMatriculas() {
		List<Matricula> matriculas = mRep.findAll();
		List<MatriculaDTO> matriculasDTO = converteMatriculasMatriculasDTO(matriculas);
		return matriculasDTO;
	}

	@Override
	@GetMapping("/matricula/{codigo}")
	public List<MatriculaDTO> buscarMatricula(@PathVariable(value = "codigo") int codigo) {
		List<Matricula> matriculas = mRep.findByDisciplinaCodigo(codigo);
		List<MatriculaDTO> matriculasDTO = converteMatriculasMatriculasDTO(matriculas);
		return matriculasDTO;
	}

	@Override
	@GetMapping("/matricula/lista/{codigo}")
	public List<MatriculaRelatorioDTO> listaMatricula(@PathVariable(value = "codigo") int codigo) {
		List<MatriculaRelatorio> listaMatriculaRelatorio = mrRep.geraLista(codigo);
		List<MatriculaRelatorioDTO> listaMatriculaRelatorioDTO = converteListaMRListaMRDTO(listaMatriculaRelatorio);
		return listaMatriculaRelatorioDTO;
	}
	
	private MatriculaRelatorioDTO converteMRMRDTO(MatriculaRelatorio mat) {
		MatriculaRelatorioDTO mrDTO = new MatriculaRelatorioDTO();
		mrDTO.setRaAluno(mat.getRaAluno());
		mrDTO.setNomeAluno(mat.getNomeAluno());
		mrDTO.setEmailAluno(mat.getEmailAluno());
		mrDTO.setCodigoDisicplina(mat.getCodigoDisicplina());
		mrDTO.setNomeDisciplina(mat.getNomeDisciplina());
		
		return mrDTO;
	}
	
	private List<MatriculaRelatorioDTO> converteListaMRListaMRDTO(List<MatriculaRelatorio> listaMat) {
		List<MatriculaRelatorioDTO> listaMRDTO = new ArrayList<MatriculaRelatorioDTO>();
		for (MatriculaRelatorio mat : listaMat) {
			MatriculaRelatorioDTO mrDTO = new MatriculaRelatorioDTO();
			mrDTO = converteMRMRDTO(mat);
			
			listaMRDTO.add(mrDTO);
		}
		return listaMRDTO;
	}
	
	private MatriculaDTO converteMatriculaMatriculaDTO(Matricula mat) {
		AlunoDTO alunoDTO = new AlunoDTO();
		DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
		
		alunoDTO.setRa(mat.getAluno().getRa());
		alunoDTO.setNome(mat.getAluno().getNome());
		alunoDTO.setEmail(mat.getAluno().getEmail());

		disciplinaDTO.setCodigo(mat.getDisciplina().getCodigo());
		disciplinaDTO.setNome(mat.getDisciplina().getNome());
		
		MatriculaDTO matriculaDTO = new MatriculaDTO();
		matriculaDTO.setAluno(alunoDTO);
		matriculaDTO.setDisciplina(disciplinaDTO);
		
		return matriculaDTO;
	}
	
	private List<MatriculaDTO> converteMatriculasMatriculasDTO(List<Matricula> matriculas) {
		List<MatriculaDTO> matriculasDTO = new ArrayList<MatriculaDTO>();
		for (Matricula mat : matriculas) {
			MatriculaDTO matriculaDTO = new MatriculaDTO();
			matriculaDTO = converteMatriculaMatriculaDTO(mat);
			
			matriculasDTO.add(matriculaDTO);
		}
		return matriculasDTO;
	}
}
