package com.darkmencito.mapbanner.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "sala_participantes")
public class SalaParticipante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonBackReference
	@JoinColumn(name = "id_sala")
	@ManyToOne
	private Sala sala;

	private String nickname;

	@Column(name = "tipo_participante")
	private String tipoParticipante;

	@Column(name = "fecharegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	public SalaParticipante(Sala sala, String nickname, String tipoParticipante) {
		super();
		this.sala = sala;
		this.nickname = nickname;
		this.tipoParticipante = tipoParticipante;
		this.fechaRegistro = new Date();
	}

	public SalaParticipante() {
		this.fechaRegistro = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(String tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
