package com.residencia.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.AtividadeService;
import com.residencia.academia.service.InstrutorService;
import com.residencia.academia.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	@Autowired
	private InstrutorService instrutorService;
	@Autowired
	private AtividadeService atividadeService;

	@GetMapping
	public ResponseEntity<List<Turma>> findAllTurma() {
		List<Turma> turma = turmaService.findAllTurma();
		return new ResponseEntity<>(turma, HttpStatus.OK);
	}

	@GetMapping("/dto/{id}")
	public ResponseEntity<TurmaDTO> findTurmaDTOById(@PathVariable Integer id) {
		TurmaDTO turmaDTO = turmaService.findTurmaDTOById(id);
		if (null == turmaDTO.getIdTurma())
			throw new NoSuchElementFoundException("Não foi encontrada Turma com id " + id);
		else
			return new ResponseEntity<>(turmaDTO, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> findTurmaById(@PathVariable Integer id) {
		Turma turma = turmaService.findTurmaById(id);
		if (null == turma)

			throw new NoSuchElementFoundException("Não foi encontrada Turma com id " + id);
		else
			return new ResponseEntity<>(turma, HttpStatus.OK);
	}

	@PostMapping("/dto")
	public ResponseEntity<TurmaDTO> saveTurmaDTO(@RequestBody TurmaDTO turmaDTO) {
		turmaService.saveTurmaDTO(turmaDTO);
		return new ResponseEntity<>(turmaDTO, HttpStatus.CREATED);
	}

	@PostMapping
	public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma) {
		Instrutor instrutor = instrutorService.findInstrutorById(turma.getInstrutor().getIdInstrutor());
		Atividade atividade = atividadeService.findAtividadeById(turma.getAtividade().getIdAtividade());
		if (null == instrutor) {
			throw new NoSuchElementFoundException(
					"Não foi encontrado Instrutor com id " + turma.getInstrutor().getIdInstrutor());
		} else if (null == atividade) {
			throw new NoSuchElementFoundException(
					"Não foi encontrada Atividade com id " + turma.getAtividade().getIdAtividade());
		}
		turmaService.saveTurma(turma);
		return new ResponseEntity<>(turma, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Turma> updateTurma(@RequestBody Turma turma) {
		Turma newTurma = turmaService.uptadeTurma(turma);
		return new ResponseEntity<>(newTurma, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurma(@PathVariable Integer id) {
		Turma turma = turmaService.findTurmaById(id);
		if (null == turma)
			throw new NoSuchElementFoundException("Não foi encontrada Turma com id " + id);
		else {
			turmaService.deleteTurma(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
