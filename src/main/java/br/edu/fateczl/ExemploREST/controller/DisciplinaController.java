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

import br.edu.fateczl.ExemploREST.model.dto.DisciplinaDTO;
import br.edu.fateczl.ExemploREST.model.entity.Disciplina;
import br.edu.fateczl.ExemploREST.persistence.DisciplinaRepository;

@RestController
@RequestMapping("/rest")
public class DisciplinaController implements IDisciplinaController {

	@Autowired
	DisciplinaRepository dRep;
	
	@Override
	@GetMapping("/disciplina")
	public List<DisciplinaDTO> buscarDisciplinas() {
		List<Disciplina> disciplinas = dRep.findAll();
		List<DisciplinaDTO> disciplinasDTO = 
				converteDisciplinasDisciplinasDTO(disciplinas);
		return disciplinasDTO;
	}

	private List<DisciplinaDTO> converteDisciplinasDisciplinasDTO(List<Disciplina> disciplinas) {
		List<DisciplinaDTO> disciplinasDTO = new ArrayList<DisciplinaDTO>();
		for (Disciplina d : disciplinas) {
			DisciplinaDTO dDTO = new DisciplinaDTO();
			dDTO.setCodigo(d.getCodigo());
			dDTO.setNome(d.getNome());
			disciplinasDTO.add(dDTO);
		}
		return disciplinasDTO;
	}

	@Override
	@GetMapping("/disciplina/{codigo}")
	public ResponseEntity<DisciplinaDTO> buscarDisciplina(@PathVariable(value = "codigo") int codigo) {
		Disciplina disciplina = dRep.findById(codigo).orElseThrow();
		DisciplinaDTO disciplinaDTO = converteDisciplinaDisciplinaDTO(disciplina);
		return ResponseEntity.ok().body(disciplinaDTO);
	}

	@Override
	@PostMapping("/disciplina")
	public ResponseEntity<String> insereDisciplina(@Valid @RequestBody Disciplina disciplina) {
		dRep.save(disciplina);
		String saida = "Disciplina cadastrada com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@PutMapping("/disciplina")
	public ResponseEntity<String> atualizaDisciplina(@Valid @RequestBody Disciplina disciplina) {
		dRep.save(disciplina);
		String saida = "Disciplina atualizada com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@DeleteMapping("/disciplina")
	public ResponseEntity<String> excluiDisciplina(@Valid @RequestBody Disciplina disciplina) {
		dRep.delete(disciplina);
		String saida = "Disciplina excluida com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@GetMapping("/disciplina/nome/{nome}")
	public ResponseEntity<DisciplinaDTO> buscarDisciplinaPorNome(@PathVariable(value = "nome") String nome) {
		Disciplina disc = dRep.findByNome(nome);
		DisciplinaDTO dDTO = converteDisciplinaDisciplinaDTO(disc);
		return ResponseEntity.ok().body(dDTO);
	}

	private DisciplinaDTO converteDisciplinaDisciplinaDTO(Disciplina disciplina) {
		DisciplinaDTO dDTO = new DisciplinaDTO();
		dDTO.setCodigo(disciplina.getCodigo());
		dDTO.setNome(disciplina.getNome());

		return dDTO;
	}
	
}
