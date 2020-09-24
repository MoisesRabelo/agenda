package com.agenda.online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.online.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	User findByEmail(String email);
	
	List<User> findAllById(Iterable<Long> id);
}
