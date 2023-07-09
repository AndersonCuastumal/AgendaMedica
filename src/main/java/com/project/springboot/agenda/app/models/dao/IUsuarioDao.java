package com.project.springboot.agenda.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.springboot.agenda.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	public Usuario findByCorreo(String correo);
}
