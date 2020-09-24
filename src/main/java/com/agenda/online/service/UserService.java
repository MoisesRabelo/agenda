package com.agenda.online.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.agenda.online.model.Role;
import com.agenda.online.model.User;
import com.agenda.online.repository.UserRepository;
import com.agenda.online.service.IUserService;
import com.agenda.online.web.dto.UserRegistrationDto;

@Service
public class UserService implements IUserService
{
	@Autowired private UserRepository userRepository;	
	@Autowired private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User save(UserRegistrationDto registrationDto) 
	{
		Collection<Role> roles = new ArrayList<Role>();
		roles.add(new Role("ROLE_USER"));

		User user = new User(registrationDto.getName(), 
				registrationDto.getNick(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), roles);
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}

	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
