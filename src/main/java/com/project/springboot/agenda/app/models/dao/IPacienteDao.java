package com.project.springboot.agenda.app.models.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.springboot.agenda.app.models.entity.Paciente;


public interface IPacienteDao extends PagingAndSortingRepository<Paciente, Long>, CrudRepository<Paciente,Long>{

}

