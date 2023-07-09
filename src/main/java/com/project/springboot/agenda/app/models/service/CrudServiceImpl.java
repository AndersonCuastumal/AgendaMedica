package com.project.springboot.agenda.app.models.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.agenda.app.models.dao.ICitaDao;
import com.project.springboot.agenda.app.models.dao.IHorarioDao;
import com.project.springboot.agenda.app.models.dao.IMedicoDao;
import com.project.springboot.agenda.app.models.dao.IPacienteDao;
import com.project.springboot.agenda.app.models.dao.IUsuarioDao;
import com.project.springboot.agenda.app.models.entity.Cita;
import com.project.springboot.agenda.app.models.entity.Horario;
import com.project.springboot.agenda.app.models.entity.Medico;
import com.project.springboot.agenda.app.models.entity.Paciente;
import com.project.springboot.agenda.app.models.entity.Usuario;

@Service
public class CrudServiceImpl implements ICrudService {

	@Autowired
	private IMedicoDao medicoDao;

	@Autowired
	private IPacienteDao pacienteDao;

	@Autowired
	private IHorarioDao horarioDao;

	@Autowired
	private ICitaDao citaDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Medico> findAll() {
		// TODO Auto-generated method stub
		return (List<Medico>) medicoDao.findAll();
	}

	// ---- Metodos Medico
	@Override
	@Transactional
	public void save(Medico medico) {
		// TODO Auto-generated method stub
		medicoDao.save(medico);
	}

	@Override
	@Transactional(readOnly = true)
	public Medico findOne(Long id) {
		// TODO Auto-generated method stub
		return medicoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		medicoDao.deleteById(id);
	}

	@Override
	public Page<Medico> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return medicoDao.findAll(pageable);
	}

	
	
	// --- Metodos Paciente

	@Override
	public List<Paciente> findAllPaciente() {
		// TODO Auto-generated method stub
		return (List<Paciente>) pacienteDao.findAll();
	}

	@Override
	public void savePaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		pacienteDao.save(paciente);
	}

	@Override
	@Transactional(readOnly = true)
	public Paciente findPacienteById(Long id) {
		// TODO Auto-generated method stub
		return pacienteDao.findById(id).orElse(null);
	}

	@Override
	public void deletePaciente(Long id) {
		// TODO Auto-generated method stub
		pacienteDao.deleteById(id);
	}

	@Override
	public Page<Paciente> findAllPaciente(Pageable pageable) {
		// TODO Auto-generated method stub
		return pacienteDao.findAll(pageable);
	}

	
	// --- Metodos horario
	
	@Override
	@Transactional(readOnly = true)
	public List<Horario> getHorariosByMedicoId(Long medicoId, LocalDate fecha) {
	    Medico medico = medicoDao.findById(medicoId).orElse(null);
	    if (medico == null) {
	        return Collections.emptyList();
	    }
	    
	    List<Cita> citas = citaDao.findByMedicoAndFechaCita(medico, fecha);
	    if (!citas.isEmpty()) {
	        // El médico ya tiene una cita programada para la fecha especificada
	        return Collections.emptyList();
	    } else {
	        // Obtener todos los horarios registrados
	        List<Horario> horarios = (List<Horario>) horarioDao.findAll();
	        List<Horario> horariosDisponibles = new ArrayList<>();
	        
	        // Validar cada hora de horario
	        for (Horario horario : horarios) {
	            if (validarHoraHorario(horario, fecha)) {
	                horariosDisponibles.add(horario);
	            }
	        }
	        
	        return horariosDisponibles;
	    }
	}

	private boolean validarHoraHorario(Horario horario, LocalDate fecha) {
	    // Obtener la hora del horario
	    LocalTime horaHorario = horario.getHora();

	    
	    // Verificar si existe una cita programada para la fecha y hora del horario
	    List<Cita> citas = citaDao.findByFechaCitaAndHoraCita(fecha, horaHorario);
	    
	    // Devolver true si no hay citas programadas en esa fecha y hora, de lo contrario, false
	    return citas.isEmpty();
	}


	@Override
	@Transactional(readOnly = true)
	public List<Horario> findAllHorario() {
		// TODO Auto-generated method stub
		return (List<Horario>) horarioDao.findAll();
	}

	
	// --- Metodos Citas
	
	@Override
	public void saveCita(Cita cita) {
		// TODO Auto-generated method stub
		citaDao.save(cita);
	}

	@Override
	@Transactional(readOnly = true)
	public Cita findCitaById(Long id) {
		// TODO Auto-generated method stub
		return citaDao.findById(id).orElse(null);
	}

	@Override
	public void deleteCita(Long id) {
		// TODO Auto-generated method stub
		citaDao.deleteById(id);
	}

	@Override
	public Paciente registrarPaciente(Paciente paciente) {
		Usuario usuario=new Usuario();
		usuario.setCorreo(paciente.getCorreo());
		usuario.setContrasena(paciente.getContrasena());
		usuario.setEstado(true);
		
		paciente.setUsuario(usuario);
		usuario.setPaciente(paciente);
		
		usuarioDao.save(usuario);
		
		return pacienteDao.save(paciente);
	}

	@Override
	public Paciente findPacienteByCorreo(String correo) {
		// TODO Auto-generated method stub
		return pacienteDao.findPacienteByCorreo(correo);
	}

	

}
