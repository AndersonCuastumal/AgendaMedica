package com.project.springboot.agenda.app.models.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;




@Entity
@Table(name="horarios")

public class Horario implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

	@NotEmpty
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_solicitud;
	
	@Temporal(TemporalType.TIME)
	private LocalTime hora_atencion;
	
	@Temporal(TemporalType.DATE)
	private Date dia_atencion;

	
	
	// -Typo de Relacion entidad 
	
	@ManyToOne(fetch=FetchType.LAZY) //Indica relacion de muchas citas un medico
	private Medico medico;
	
	@ManyToOne(fetch=FetchType.LAZY) //Indica relacion de una cita un paciente
	private Paciente paciente;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="horario_id")
	private List<ItemHorario> items;
	
	//Constructor
	public Horario() {
		this.items=new ArrayList<ItemHorario>();
	}
	
	//---Metodos
	
	@PrePersist
	public void prePersist() {
		fecha_solicitud=new Date();
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

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}
		

	public LocalTime getHora_atencion() {
		return hora_atencion;
	}

	public void setHora_atencion(LocalTime hora_atencion) {
		this.hora_atencion = hora_atencion;
	}

	public Date getDia_atencion() {
		return dia_atencion;
	}

	public void setDia_atencion(Date dia_atencion) {
		this.dia_atencion = dia_atencion;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
		
	public List<ItemHorario> getItems() {
		return items;
	}
	public void setItems(List<ItemHorario> items) {
		this.items = items;
	}
	
	public void addItemHorario(ItemHorario item) {
		this.items.add(item);
	}


	
	
	
	// Metodos validaciones
	

	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
}
