package com.project.springboot.agenda.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.springboot.agenda.app.models.entity.Cita;


public interface ICitaDao extends PagingAndSortingRepository<Cita, Long>, CrudRepository<Cita,Long>{

}
