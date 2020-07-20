package com.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.security.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u left join fetch u.authorities where u.username=:username")
	User findByUsername(String username);

}
