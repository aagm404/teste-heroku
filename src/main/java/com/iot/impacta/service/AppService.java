package com.iot.impacta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.impacta.AppRepository;
import com.iot.impacta.entity.Login;
import com.iot.impacta.vo.LoginRequestVO;
import com.iot.impacta.vo.LoginResponseVO;

@Service
public class AppService {
	
	@Autowired
	private AppRepository repository;
	
	public LoginResponseVO findById(Long id) {
		
		Login login = repository.findById(id).orElseThrow(() -> new RuntimeException("Não existe login de ID: " + id));
	
		return entityToResponseVOConverter(login, new LoginResponseVO());
	}

	public LoginResponseVO save(LoginRequestVO request) {
		Login entity = getEntityFromVO(request, new Login());
		
		return entityToResponseVOConverter(repository.save(entity), new LoginResponseVO());
	}

	private LoginResponseVO entityToResponseVOConverter(Login login, LoginResponseVO response) {
		response.setId(login.getId());
		response.setNome(login.getNome());
		
		return response;
	}
	
	private Login getEntityFromVO(LoginRequestVO request, Login login) {
		login.setDigital(request.getDigital());
		login.setNome(request.getNome());
		
		return login;
	}
}
