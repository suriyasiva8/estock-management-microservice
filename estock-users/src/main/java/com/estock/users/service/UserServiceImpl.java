package com.estock.users.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estock.users.dto.UserDto;
import com.estock.users.entity.UserEntity;
import com.estock.users.repo.UsersRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UsersRepo userRepo;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	public UserDto createUser(UserDto userDetails) {
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity=modelMapper.map(userDetails, UserEntity.class);
		userEntity.setPassword(bcryptPasswordEncoder.encode(userDetails.getPassword()));
		userRepo.save(userEntity);
		return userDetails;
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=userRepo.findByEmailId(username);
		if(userEntity==null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(userEntity.getEmailId(),userEntity.getPassword(),true,true,true,true,new ArrayList<>());
	}


	@Override
	public UserDto getUserDetailsByEmail(String userName) {
		UserEntity userEntity=userRepo.findByEmailId(userName);
		if(userEntity==null) {
			throw new UsernameNotFoundException(userName);
		}
		return new ModelMapper().map(userEntity,UserDto.class);
	}

	
}
