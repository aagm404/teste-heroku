package com.iot.impacta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.impacta.entity.User;
import com.iot.impacta.exception.UserNotFoundException;
import com.iot.impacta.repository.UserRepository;
import com.iot.impacta.vo.UserRequestVO;
import com.iot.impacta.vo.UserResponseVO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserResponseVO findById(Long id) {
		
		User login = repository.findById(id).orElseThrow(() -> new UserNotFoundException("There is no user with ID: " + id));
	
		return entityToResponseVOConverter(login, new UserResponseVO());
	}

	public UserResponseVO save(UserRequestVO request) {
		User entity = getEntityFromVO(request, new User());
		
		return entityToResponseVOConverter(repository.save(entity), new UserResponseVO());
	}

	private UserResponseVO entityToResponseVOConverter(User login, UserResponseVO response) {
		response.setId(login.getId());
		response.setName(login.getName());
		
		return response;
	}
	
	private User getEntityFromVO(UserRequestVO request, User login) {
		login.setFingerprint(request.getFingerprint());
		login.setName(request.getName());
		
		return login;
	}
}