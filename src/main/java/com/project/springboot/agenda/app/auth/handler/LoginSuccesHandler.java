package com.project.springboot.agenda.app.auth.handler;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class LoginSuccesHandler extends SimpleUrlAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		SessionFlashMapManager flashMapManager =new SessionFlashMapManager();
		FlashMap flashMap=new FlashMap();
		flashMap.put("success","Inicio de sesión exitoso!!");
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
}
