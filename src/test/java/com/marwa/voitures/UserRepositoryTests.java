package com.marwa.voitures;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.marwa.voitures.entities.User;
import com.marwa.voitures.entities.Role;
import com.marwa.voitures.repos.RoleRepository;
import com.marwa.voitures.repos.UserRepository;


@SpringBootTest
class UserRepositoryTests {

	@Autowired 
	private UserRepository repo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setName("fourat");
		user.setPassword("test");
		User savedUser = repo.save(user);
	}
	
	@Test
	public void testAddRoleToNewUser() {
		Role roleAdmin = roleRepo.findByName("ADMIN");
		
		User user = new User();
		user.setName("fourat jouini again and again");
		user.setPassword("test");
		user.addRole(roleAdmin);		
		
		User savedUser = repo.save(user);
		
		assertThat(savedUser.getRoles().size()).isEqualTo(1);
	}
	
	
	
	
	
}