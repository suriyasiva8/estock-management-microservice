package com.estock.users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.estock.users.controller.UsersController;
import com.estock.users.dto.OtpDto;
import com.estock.users.dto.UserDto;
import com.estock.users.service.OtpService;
import com.estock.users.service.UserService;
import com.estock.users.util.EmailService;

class UsersControllerTest {

	@InjectMocks
	UsersController userCont;

	@Mock
	UserService userService;

	@Mock
	OtpService otpService;

	@Mock
	EmailService emailService;

	UserDto userDto;

	OtpDto otpDto;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		otpDto = new OtpDto();
		otpDto.setEmailId("cts@com");
		otpDto.setOtp("345");
		userDto = new UserDto();
		userDto.setEmailId("test@com");
		userDto.setFirstName("Siva");
		userDto.setLastName("Siva");
		userDto.setMobileNumber("1234567");
		userDto.setPassword("test");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testCreateUser() {
		Mockito.when(userService.createUser(userDto)).thenReturn(userDto);
		assertNotNull(userCont.createUser(userDto));
	}

	@Test
	void generateOtp() {
		Mockito.when(otpService.generateOTP(Mockito.anyString())).thenReturn(123);
		Mockito.doNothing().when(emailService).sendOtpMessage(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyString());
		userCont.generateOtp(otpDto);
		assertNotNull(otpDto);
	}

	@Test
	void validateOtp() {
		Mockito.when(otpService.getOtp(Mockito.anyString())).thenReturn(123);
		Mockito.doNothing().when(otpService).clearOTP(Mockito.any());
		Mockito.when(otpService.getOtp(Mockito.anyString())).thenReturn(Integer.valueOf(otpDto.getOtp()));
		assertTrue(userCont.validateOtp(otpDto));
	}

}
