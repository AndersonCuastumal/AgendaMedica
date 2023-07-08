package com.project.springboot.agenda.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "pacientes")

public class Paciente implements Serializable {

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String correo;
	
	@NotEmpty
	private String contrasena;
	
	@NotEmpty
	private String telefono;
	
	@NotEmpty
	private String direccion;
	
	
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha_creacion;
	
	

	@Column(name = "ultimo_inicio_sesion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ultimo_inicio_sesion;
	private String estado;
	
	//Un medico puede tener muchas citas
	@OneToMany(mappedBy="paciente",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Cita> citas;

	private static final long serialVersionUID = 1L;
	
	//-- constructor
	public Paciente() {
		citas=new ArrayList<Cita>();
	}
	
	// --- metodos
	@PrePersist
	public void prePersist() {
		fecha_creacion=new Date();
		ultimo_inicio_sesion=new Date();
	}
	
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getUltimo_inicio_sesion() {
		return ultimo_inicio_sesion;
	}

	public void setUltimo_inicio_sesion(Date ultimo_inicio_sesion) {
		this.ultimo_inicio_sesion = ultimo_inicio_sesion;
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

	public List<Cita> getHorarios() {
		return citas;
	}

	public void setHorarios(List<Cita> citas) {
		this.citas = citas;
	}
	
	public void addHorario(Cita cita) {
		citas.add(cita);
	}
	

}