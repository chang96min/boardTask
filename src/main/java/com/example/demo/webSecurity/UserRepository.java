package com.example.demo.webSecurity;

import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {
	
	Optional<User> findByEmail(@Param("email")String email);

	void save(@Param("user")User user);
}
