package com.estock.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.users.dto.OtpDto;
import com.estock.users.dto.UserDto;
import com.estock.users.service.OtpService;
import com.estock.users.service.UserService;
import com.estock.users.util.EmailService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private Environment env;

	@Autowired
	UserService userService;

	@Autowired
	OtpService otpService;
	
	@Autowired
	EmailService emailService;

	@GetMapping("/status/check")
	public String status() {
		return "Working on port :" + env.getProperty("local.server.port") + " and token secret:"
				+ env.getProperty("token.secret");
	}

	@PostMapping
	public UserDto createUser(@RequestBody UserDto userDto) {
		return userService.createUser(userDto);
	}

	@PostMapping("/generateOtp")
	public void generateOtp(@RequestBody OtpDto otpDto) {
		String username=otpDto.getEmailId();
		int otp = otpService.generateOTP(username);
		emailService.sendOtpMessage(username, "OTP-EStock Management", "Hi, Your OTP No:"+otp+"");
	}

	@PostMapping(value = "/validateOtp")
	public boolean validateOtp(@RequestBody OtpDto otpDto) {
		int otpnum=Integer.parseInt(otpDto.getOtp());
		String username=otpDto.getEmailId();
		if (otpnum >= 0) {
			int serverOtp = otpService.getOtp(username);
			if (serverOtp > 0) {
				if (otpnum == serverOtp) {
					otpService.clearOTP(username);
					return true;
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
