package com.estock.users.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estock.users.entity.UserEntity;
@Repository
public interface UsersRepo extends CrudRepository<UserEntity,Long> {
	
	UserEntity findByEmailId(String email);
}
