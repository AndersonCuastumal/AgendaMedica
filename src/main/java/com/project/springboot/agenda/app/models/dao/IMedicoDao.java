package com.project.springboot.agenda.app.models.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.springboot.agenda.app.models.entity.Medico;
import com.project.springboot.agenda.app.models.entity.Paciente;


public interface IMedicoDao extends PagingAndSortingRepository<Medico, Long>, CrudRepository<Medico,Long>{

}

