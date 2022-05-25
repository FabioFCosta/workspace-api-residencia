package com.residencia.academia.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class TurmaDTO {

	private Integer idTurma;
	@JsonFormat(pattern = "HH:mm:ss")
	private Date horarioTurma;
	private Integer duracaoTurma;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataInicio;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataFim;
	private InstrutorDTO instrutorDTO;
	private AtividadeDTO atividadeDTO;

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public Date getHorarioTurma() {
		return horarioTurma;
	}

	public void setHorarioTurma(Date horarioTurma) {
		this.horarioTurma = horarioTurma;
	}

	public Integer getDuracaoTurma() {
		return duracaoTurma;
	}

	public void setDuracaoTurma(Integer duracaoTurma) {
		this.duracaoTurma = duracaoTurma;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public InstrutorDTO getInstrutorDTO() {
		return instrutorDTO;
	}

	public void setInstrutorDTO(InstrutorDTO instrutorDTO) {
		this.instrutorDTO = instrutorDTO;
	}

	public AtividadeDTO getAtividadeDTO() {
		return atividadeDTO;
	}

	public void setAtividadeDTO(AtividadeDTO atividadeDTO) {
		this.atividadeDTO = atividadeDTO;
	}	

}
