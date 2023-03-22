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
@Table(name = "sala_mapas")
public class SalaMapa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonBackReference
	@JoinColumn(name = "id_sala")
	@ManyToOne
	private Sala sala;

	private String descripcion;
	private String estado;

	@Column(name = "nicknameedita")
	private String nicknameEdita;

	@Column(name = "fechabanea")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaBanea;

	public SalaMapa(Long id, Sala sala, String descripcion, String estado) {
		this.id = id;
		this.sala = sala;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public SalaMapa() {

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNicknameEdita() {
		return nicknameEdita;
	}

	public void setNicknameEdita(String nicknameEdita) {
		this.nicknameEdita = nicknameEdita;
	}

	public Date getFechaBanea() {
		return fechaBanea;
	}

	public void setFechaBanea(Date fechaBanea) {
		this.fechaBanea = fechaBanea;
	}

}
