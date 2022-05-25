package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.InstrutorRepository;

@Service
public class InstrutorService {

	@Autowired
	private InstrutorRepository instrutorRepository;

	public List<Instrutor> findAllInstrutor() {
		return instrutorRepository.findAll();
	}

	public InstrutorDTO findInstrutorDTOById(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).isPresent() ? instrutorRepository.findById(id).get()
				: null;

		InstrutorDTO instrutorDTO = new InstrutorDTO();
		if (null != instrutor) {
			instrutorDTO = converterEntidadeParaDTO(instrutor);
		}

		return instrutorDTO;
	}

	public Instrutor findInstrutorById(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).isPresent() ? instrutorRepository.findById(id).get()
				: null;
		return instrutor;
	}

	public InstrutorDTO saveInstrutorDTO(InstrutorDTO instrutorDTO) {
		Instrutor instrutor = converterDTOParaEntidade(instrutorDTO);
		Instrutor novoInstrutor = instrutorRepository.save(instrutor);
		return converterEntidadeParaDTO(novoInstrutor);
	}

	public Instrutor saveInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public Instrutor updateInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public void deleteInstrutorById(Integer id) {
		Instrutor inst = instrutorRepository.findById(id).get();
		instrutorRepository.delete(inst);
	}

	public void deleteInstrutor(Instrutor instrutor) {
		instrutorRepository.delete(instrutor);
	}

	private InstrutorDTO converterEntidadeParaDTO(Instrutor instrutor) {
		InstrutorDTO instrutorDTO = new InstrutorDTO();
		if (null != instrutor) {
			instrutorDTO.setNascimento(instrutor.getNascimento());
			instrutorDTO.setNome(instrutor.getNome());
			instrutorDTO.setIdInstrutor(instrutor.getIdInstrutor());
			instrutorDTO.setRgInstrutor(instrutor.getRgInstrutor());
			instrutorDTO.setTitulacaoInstrutor(instrutor.getTitulacaoInstrutor());

			if (instrutor.getTurmaList() != null) {
				List<TurmaDTO> listTurmaDTO = new ArrayList<>();

				for (Turma turma : instrutor.getTurmaList()) {
					TurmaDTO turmaDTO = new TurmaDTO();
					turmaDTO.setDataFim(turma.getDataFim());
					turmaDTO.setDataInicio(turma.getDataInicio());
					turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
					turmaDTO.setHorarioTurma(turma.getHorarioTurma());
					turmaDTO.setIdTurma(turma.getIdTurma());

					listTurmaDTO.add(turmaDTO);

				}

				instrutorDTO.setTurmaDTOList(listTurmaDTO);
			}
		}

		return instrutorDTO;
	}

	private Instrutor converterDTOParaEntidade(InstrutorDTO instrutorDTO) {
		Instrutor instrutor = new Instrutor();
		if (null != instrutorDTO) {
			instrutor.setIdInstrutor(instrutorDTO.getIdInstrutor());
			instrutor.setNascimento(instrutorDTO.getNascimento());
			instrutor.setNome(instrutorDTO.getNome());
			instrutor.setRgInstrutor(instrutorDTO.getRgInstrutor());
			instrutor.setTitulacaoInstrutor(instrutorDTO.getTitulacaoInstrutor());

			if (instrutorDTO.getTurmaDTOList() != null) {
				List<Turma> listTurma = new ArrayList<>();

				for (TurmaDTO turmaDTO : instrutorDTO.getTurmaDTOList()) {
					Turma turma = new Turma();
					turma.setDataFim(turmaDTO.getDataFim());
					turma.setDataInicio(turmaDTO.getDataInicio());
					turma.setDuracaoTurma(turmaDTO.getDuracaoTurma());
					turma.setHorarioTurma(turmaDTO.getHorarioTurma());
					turma.setIdTurma(turmaDTO.getIdTurma());

					listTurma.add(turma);
				}
				instrutor.setTurmaList(listTurma);
			}
		}
		return instrutor;
	}
}
