package com.prototype.product.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuditConfig implements  AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		String nameUser = SecurityContextHolder.getContext().getAuthentication().getName();
		return Optional.of(nameUser);
	}

}
