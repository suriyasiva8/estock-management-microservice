package com.estock.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;

import com.estock.users.dto.UserDto;
import com.estock.users.entity.UserEntity;
import com.estock.users.repo.UsersRepo;
import com.estock.users.service.OtpService;
import com.estock.users.service.OtpServiceImpl;
import com.estock.users.service.UserService;
import com.estock.users.service.UserServiceImpl;

 class UsersServiceTest {

	@InjectMocks
	UserService userService = new UserServiceImpl();

	@InjectMocks
	OtpService otpService = new OtpServiceImpl();

	@Mock
	UsersRepo userRepo;

	@Mock
	BCryptPasswordEncoder bcryptPasswordEncoder;
	UserDto userDetails;
	UserEntity userEntity;

	@BeforeEach
	void init() {
		userEntity = new UserEntity();
		userEntity.setEmailId("cts@com");
		userEntity.setPassword("siva");
		userDetails = new UserDto();
		userDetails.setEmailId("cts@com");
		userDetails.setFirstName("Siva");
		userDetails.setLastName("Siva");
		userDetails.setMobileNumber("123");
		userDetails.setPassword("test");
		userEntity.getMobileNumber();
		userEntity.getId();
		userEntity.setId(1);
		userEntity.getLastName();
		userEntity.getFirstName();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateUser() {
		Mockito.when(bcryptPasswordEncoder.encode(Mockito.anyString())).thenReturn("test");
		Mockito.when(userRepo.save(Mockito.any())).thenReturn(userDetails);
		assertThrows(ClassCastException.class, () -> userService.createUser(userDetails));

	}

	@Test
	void loadUserByUsername() {
		Mockito.when(userRepo.findByEmailId(Mockito.anyString())).thenReturn(userEntity);
		assertNotNull(userService.loadUserByUsername("siva"));
	}

	@Test
	void getUserDetailsByEmail() {
		Mockito.when(userRepo.findByEmailId("cts@com")).thenReturn(userEntity);
		assertThrows(UsernameNotFoundException.class, () -> userService.getUserDetailsByEmail("siva"));
	}
	

}
