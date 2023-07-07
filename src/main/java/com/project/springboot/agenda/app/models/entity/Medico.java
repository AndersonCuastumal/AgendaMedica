package com.project.springboot.agenda.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "medicos")

public class Medico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellido;
	private String estado;
	
	//Un medico puede tener muchas citas
	@OneToMany(mappedBy="medico",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Horario> horarios;
	
	
	//Constructor
	public Medico() {
		horarios=new ArrayList<Horario>();
	}
	
	//------Metodos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	
	public void addHorario(Horario horario) {
		horarios.add(horario);
	}
	
	
	
	
}