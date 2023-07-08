package com.project.springboot.agenda.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.springboot.agenda.app.models.entity.Horario;


public interface IHorarioDao extends PagingAndSortingRepository<Horario, Long>, CrudRepository<Horario,Long>{

}
