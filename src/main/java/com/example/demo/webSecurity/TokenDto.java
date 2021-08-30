package com.example.demo.webSecurity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenDto {
	private int id;
	private String name;
	private String loc;
	private String phone;
	private int age;
	private String email;
	private String password;
	private String roles;
	
}
