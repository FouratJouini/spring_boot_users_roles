package com.marwa.voitures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.marwa.voitures.entities.Role;
import com.marwa.voitures.repos.RoleRepository;


@SpringBootTest
class RoleRepositoryTests {

	@Autowired 
	private RoleRepository repo;
	
	@Test
	public void testCreateRoles() {
		Role user = new Role("User");
		Role admin = new Role("Admin");
		Role customer = new Role("Customer");
		
		repo.saveAll(List.of(user, admin, customer));
		
		List<Role> listRoles = repo.findAll();
		
		assertThat(listRoles.size()).isEqualTo(3);
	}
	
}
