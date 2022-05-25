package com.residencia.academia.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity

@JsonIdentityInfo(scope = Atividade.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAtividade")

@Table(name = "atividade")
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atividade")
	private Integer idAtividade;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "atividade")
	private List<Turma> turmaList;

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

	public List<Turma> getTurmaList() {
		return turmaList;
	}

	public void setTurmaList(List<Turma> turmaList) {
		this.turmaList = turmaList;
	}

}
