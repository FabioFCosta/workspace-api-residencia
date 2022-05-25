package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.AtividadeDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepository;

	public List<Atividade> findAllAtividade() {
		return atividadeRepository.findAll();
	}

	public Atividade findAtividadeById(Integer id) {
		return atividadeRepository.findById(id).isPresent() ? atividadeRepository.findById(id).get() : null;
	}

	public AtividadeDTO findAtividadeDTOById(Integer id) {
		Atividade atividade = atividadeRepository.findById(id).isPresent() ? atividadeRepository.findById(id).get()
				: null;

		AtividadeDTO atividadeDTO = new AtividadeDTO();
		if (null != atividade) {
			atividadeDTO = converterEntidadeParaDTO(atividade);
		}

		return atividadeDTO;
	}

	public Atividade saveAtividade(Atividade atividade) {
		return atividadeRepository.save(atividade);
	}
	
	public AtividadeDTO saveAtividadeDTO(AtividadeDTO atividadeDTO) {
		Atividade atividade = converterDTOParaEntidade(atividadeDTO);
		Atividade novaAtividade = atividadeRepository.save(atividade);
		return converterEntidadeParaDTO(novaAtividade);
	}


	public Atividade updateAtividade(Atividade atividade) {
		return atividadeRepository.save(atividade);
	}

	public void deleteAtividadeById(Integer id) {
		Atividade ativ = atividadeRepository.findById(id).get();
		atividadeRepository.delete(ativ);
	}

	public void deleteAtividade(Atividade atividade) {
		atividadeRepository.delete(atividade);
	}

	private AtividadeDTO converterEntidadeParaDTO(Atividade atividade) {
		AtividadeDTO atividadeDTO = new AtividadeDTO();
		if (null != atividade) {
			atividadeDTO.setNome(atividade.getNome());
			atividadeDTO.setIdAtividade(atividade.getIdAtividade());

			if (atividade.getTurmaList() != null) {
				List<TurmaDTO> listTurmaDTO = new ArrayList<>();

				for (Turma turma : atividade.getTurmaList()) {
					TurmaDTO turmaDTO = new TurmaDTO();
					turmaDTO.setDataFim(turma.getDataFim());
					turmaDTO.setDataInicio(turma.getDataInicio());
					turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
					turmaDTO.setHorarioTurma(turma.getHorarioTurma());
					turmaDTO.setIdTurma(turma.getIdTurma());

					listTurmaDTO.add(turmaDTO);

				}

				atividadeDTO.setTurmaDTOList(listTurmaDTO);
			}
		}

		return atividadeDTO;
	}

	private Atividade converterDTOParaEntidade(AtividadeDTO atividadeDTO) {
		Atividade atividade = new Atividade();
		if (null != atividadeDTO) {
			atividade.setIdAtividade(atividadeDTO.getIdAtividade());
			atividade.setNome(atividadeDTO.getNome());

			if (atividadeDTO.getTurmaDTOList() != null) {
				List<Turma> listTurma = new ArrayList<>();

				for (TurmaDTO turmaDTO : atividadeDTO.getTurmaDTOList()) {
					Turma turma = new Turma();
					turma.setDataFim(turmaDTO.getDataFim());
					turma.setDataInicio(turmaDTO.getDataInicio());
					turma.setDuracaoTurma(turmaDTO.getDuracaoTurma());
					turma.setHorarioTurma(turmaDTO.getHorarioTurma());
					turma.setIdTurma(turmaDTO.getIdTurma());

					listTurma.add(turma);
				}
				atividade.setTurmaList(listTurma);
			}
		}
		return atividade;
	}
}