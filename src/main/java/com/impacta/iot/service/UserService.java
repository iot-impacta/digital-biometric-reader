package com.impacta.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impacta.iot.entity.User;
import com.impacta.iot.exception.UserNotFoundException;
import com.impacta.iot.repository.UserRepository;
import com.impacta.iot.vo.UserRequestVO;
import com.impacta.iot.vo.UserResponseVO;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserResponseVO> findAll() {
		List<User> users = repository.findAll();

		return users.stream().map(user -> entityToResponseVOConverter(user, new UserResponseVO())).toList();
	}

	public UserResponseVO findById(Long id) {

		User login = repository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("There is no user with ID: " + id));

		return entityToResponseVOConverter(login, new UserResponseVO());
	}

	public UserResponseVO save(UserRequestVO request) {
		User entity = getEntityFromVO(request, new User());

		return entityToResponseVOConverter(repository.save(entity), new UserResponseVO());
	}

	private UserResponseVO entityToResponseVOConverter(User user, UserResponseVO response) {

		response.setId(user.getId());
		response.setName(user.getName());
		response.setFingerprint(user.getFingerprint());

		return response;
	}

	private User getEntityFromVO(UserRequestVO request, User user) {

		user.setFingerprint(request.getFingerprint());
		user.setName(request.getName());

		return user;
	}
}