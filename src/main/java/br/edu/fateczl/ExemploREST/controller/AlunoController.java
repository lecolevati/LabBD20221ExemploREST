package br.edu.fateczl.ExemploREST.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.ExemploREST.model.dto.AlunoDTO;
import br.edu.fateczl.ExemploREST.model.entity.Aluno;
import br.edu.fateczl.ExemploREST.persistence.AlunoRepository;

@RestController
@RequestMapping("/rest")
public class AlunoController implements IAlunoController {

	@Autowired
	AlunoRepository aRep;
	
	@Override
	@GetMapping("/aluno")
	public List<AlunoDTO> buscarAlunos() {
		List<Aluno> alunos = aRep.findAll();
		List<AlunoDTO> alunosDTO = converteAlunosAlunosDTO(alunos);
		return alunosDTO;
	}

	@Override
	@GetMapping("/aluno/email/{email}")
	public ResponseEntity<AlunoDTO> buscarAlunoPorEmail(
			@PathVariable(value = "email") String email) {
		Aluno aluno = aRep.findByEmail(email).orElseThrow();
		AlunoDTO alunoDTO = converteAlunoAlunoDTO(aluno);
		return ResponseEntity.ok().body(alunoDTO);
	}

	@Override
	@GetMapping("/aluno/{ra}")
	public ResponseEntity<AlunoDTO> buscarAluno(
			@PathVariable(value = "ra") String ra) {
		Aluno aluno = aRep.findById(ra).orElseThrow();
		AlunoDTO alunoDTO = converteAlunoAlunoDTO(aluno);
		return ResponseEntity.ok().body(alunoDTO);
	}

	@Override
	@PostMapping("/aluno")
	public ResponseEntity<String> insereAluno(
			@Valid @RequestBody Aluno aluno) {
		aRep.save(aluno);
		String saida = "Aluno inserido com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@PutMapping("/aluno")
	public ResponseEntity<String> atualizaAluno(
			@Valid @RequestBody Aluno aluno) {
		aRep.save(aluno);
		String saida = "Aluno atualizado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@DeleteMapping("/aluno")
	public ResponseEntity<String> excluiAluno(
			@Valid @RequestBody Aluno aluno) {
		aRep.delete(aluno);
		String saida = "Aluno excluido com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	private List<AlunoDTO> converteAlunosAlunosDTO(List<Aluno> alunos) {
		List<AlunoDTO> alunosDTO = new ArrayList<AlunoDTO>();
		for (Aluno a : alunos) {
			AlunoDTO alunoDTO = new AlunoDTO();
			alunoDTO = converteAlunoAlunoDTO(a);
			
			alunosDTO.add(alunoDTO);
		}
		return alunosDTO;
	}

	private AlunoDTO converteAlunoAlunoDTO(Aluno aluno) {
		AlunoDTO alunoDTO = new AlunoDTO();
		alunoDTO.setRa(aluno.getRa());
		alunoDTO.setNome(aluno.getNome());
		alunoDTO.setEmail(aluno.getEmail());
		
		return alunoDTO;
	}
	
}
