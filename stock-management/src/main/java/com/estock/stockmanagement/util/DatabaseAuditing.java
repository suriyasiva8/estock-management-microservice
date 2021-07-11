package com.estock.stockmanagement.util;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class DatabaseAuditing implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		String uname = "system";
		return Optional.of(uname);
	}

}
