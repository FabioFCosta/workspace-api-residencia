package com.residencia.academia.dto;

import java.util.List;

public class AtividadeDTO {
	
	private Integer idAtividade;
	private String nome;
	private List<TurmaDTO> turmaDTOList;
	
	public Integer getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(Integer idAtividade) {
		this.idAtividade = idAtividade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<TurmaDTO> getTurmaDTOList() {
		return turmaDTOList;
	}
	public void setTurmaDTOList(List<TurmaDTO> turmaDTOList) {
		this.turmaDTOList = turmaDTOList;
	}
	@Override
	public String toString() {
		return "AtividadeDTO [idAtividade=" + idAtividade + ", nome=" + nome + ", turmaDTOList=" + turmaDTOList + "]";
	}
	
	
	
	
}
