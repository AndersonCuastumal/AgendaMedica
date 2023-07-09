package com.project.springboot.agenda.app.models.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.project.springboot.agenda.app.models.entity.Cita;
import com.project.springboot.agenda.app.models.entity.Medico;


public interface ICitaDao extends PagingAndSortingRepository<Cita, Long>, CrudRepository<Cita,Long>{
	@Query("SELECT c FROM Cita c WHERE c.medico = :medico AND c.fecha_cita = :fecha")
    List<Cita> findByMedicoAndFechaCita(@Param("medico") Medico medico, @Param("fecha") LocalDate fecha);

    @Query("SELECT c FROM Cita c WHERE c.fecha_cita = :fecha_cita AND c.hora_cita = :hora_cita")
    List<Cita> findByFechaCitaAndHoraCita(@Param("fecha_cita") LocalDate fechaCita, @Param("hora_cita") LocalTime horaCita);
}
