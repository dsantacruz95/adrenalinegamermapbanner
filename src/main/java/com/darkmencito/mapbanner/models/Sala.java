package com.darkmencito.mapbanner.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "sala")
@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descripcion;
	private String sessionid;
	@Column(name = "fecregistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecRegistro;

	@JsonManagedReference
	@OneToMany(mappedBy = "sala")
	@OrderBy("id")
	private Set<SalaMapa> mapas;

	@JsonManagedReference
	@OneToMany(mappedBy = "sala")
	@OrderBy("id")
	private Set<SalaParticipante> participantes;

	public Sala(Long id, String descripcion, String sessionid, String ipPlayer1, String ipPlayer2, Date fecRegistro) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.sessionid = sessionid;
		this.fecRegistro = fecRegistro;
	}

	public Sala() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public Date getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public Set<SalaMapa> getMapas() {
		return mapas;
	}

	public void setMapas(Set<SalaMapa> mapas) {
		this.mapas = mapas;
	}

	public Set<SalaParticipante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<SalaParticipante> participantes) {
		this.participantes = participantes;
	}

}
