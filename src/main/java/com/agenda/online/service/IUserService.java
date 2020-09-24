package com.agenda.online.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.agenda.online.model.User;
import com.agenda.online.web.dto.UserRegistrationDto;

public interface IUserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
