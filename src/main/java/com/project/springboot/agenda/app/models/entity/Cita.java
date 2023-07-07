package com.project.springboot.agenda.app.models.entity;

import java.io.Serializable;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "citas")
public class Cita implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Double numero_citas;

	@Temporal(TemporalType.TIME)
	private LocalTime hora_inicio;

	@Temporal(TemporalType.TIME)
	private LocalTime hora_fin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNumero_citas() {
		return numero_citas;
	}

	public void setNumero_citas(Double numero_citas) {
		this.numero_citas = numero_citas;
	}

	public LocalTime getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(LocalTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public LocalTime getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(LocalTime hora_fin) {
		this.hora_fin = hora_fin;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
