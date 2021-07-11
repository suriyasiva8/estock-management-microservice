package com.estock.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.estock.users.dto.UserDto;

public interface UserService extends UserDetailsService {
	public UserDto createUser(UserDto userDetails);

	public UserDto getUserDetailsByEmail(String userName);
}
