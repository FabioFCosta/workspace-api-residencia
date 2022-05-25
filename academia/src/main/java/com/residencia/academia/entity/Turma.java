package com.residencia.academia.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTurma")
@Table(name="turma")
public class Turma {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_turma")
	private Integer idTurma;
	
	@Column(name="horario")
	@JsonFormat(pattern="HH:mm:ss")
	private Date horarioTurma;
	
	@Column(name="duracao")
	private Integer duracaoTurma;
	
	@Column(name="data_inicio")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataInicio;
	
	@Column(name="data_fim")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataFim;
	
	 @ManyToOne
	 @JoinColumn(name = "id_instrutor", referencedColumnName = "id_instrutor")
	 private Instrutor instrutor;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_atividade", referencedColumnName = "id_atividade")
	 private Atividade atividade;

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public Date getHorarioTurma() {
		return horarioTurma;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
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

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
	
}
