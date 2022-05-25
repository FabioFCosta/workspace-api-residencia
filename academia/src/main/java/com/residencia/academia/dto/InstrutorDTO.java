package com.residencia.academia.dto;

import java.util.Date;
import java.util.List;

public class InstrutorDTO {

	private Integer idInstrutor;
	private Integer rgInstrutor;
	private String nome;
	private Date nascimento;
	private Integer titulacaoInstrutor;
	private List<TurmaDTO> turmaDTOList;

	public Integer getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Integer idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public Integer getRgInstrutor() {
		return rgInstrutor;
	}

	public void setRgInstrutor(Integer rgInstrutor) {
		this.rgInstrutor = rgInstrutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getTitulacaoInstrutor() {
		return titulacaoInstrutor;
	}

	public void setTitulacaoInstrutor(Integer titulacaoInstrutor) {
		this.titulacaoInstrutor = titulacaoInstrutor;
	}

	public List<TurmaDTO> getTurmaDTOList() {
		return turmaDTOList;
	}

	public void setTurmaDTOList(List<TurmaDTO> turmaDTOList) {
		this.turmaDTOList = turmaDTOList;
	}

	@Override
	public String toString() {
		return "InstrutorDTO [idInstrutor=" + idInstrutor + ", rgInstrutor=" + rgInstrutor + ", nome=" + nome
				+ ", nascimento=" + nascimento + ", titulacaoInstrutor=" + titulacaoInstrutor + ", turmaDTOList="
				+ turmaDTOList + "]";
	}

}
