package com.project.springboot.agenda.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.agenda.app.models.dao.IUsuarioDao;
import com.project.springboot.agenda.app.models.entity.Role;
import com.project.springboot.agenda.app.models.entity.Usuario;




@Service("jpaUsuarioDetailService")
public class JpaUsuariosDetailsService implements UserDetailsService{
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	private final Logger log=LoggerFactory.getLogger(getClass());
	
	
	
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Usuario usuario =usuarioDao.findByCorreo(correo);
		
		if(usuario==null) {
			log.error("Error Login: no existe el usuario: ".concat(correo));
		}else {
			log.info("Exito: Bienvenido: ".concat(correo));
		}
		
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		
		for(Role role:usuario.getRoles()) {
			log.info("Role: ".concat(role.getAuthority()));
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		if(authorities.isEmpty()) {
			log.error("Error Login: no existe el usuario: ".concat(correo).concat(" No tiene roles asignados!!"));
		}
		
		
		
		return new User(usuario.getCorreo(), usuario.getContrasena(), usuario.getEstado(), true, true, true, authorities);
	}
	
	
	

}
