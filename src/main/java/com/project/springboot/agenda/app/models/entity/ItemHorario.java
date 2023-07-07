package com.project.springboot.agenda.app.models.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="horarios_item")
public class ItemHorario implements Serializable{

		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Boolean fecha_disponible;
	


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cita_id")
	private Cita cita;
	
	
	//Metodos	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getFecha_disponible() {
		
		return fecha_disponible;
	}
	public void setFecha_disponible(Boolean fecha_disponible) {
		this.fecha_disponible = fecha_disponible;
	}

	// Metodos validacion
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
