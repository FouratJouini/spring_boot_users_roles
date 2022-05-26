package com.marwa.voitures.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marwa.voitures.entities.User;



public interface UserRepository extends JpaRepository<User, Long>{
	@Query("SELECT u FROM User u WHERE u.name = ?1")
	public User findByName(String name);

}
