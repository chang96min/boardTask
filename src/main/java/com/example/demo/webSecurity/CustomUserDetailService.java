package com.example.demo.webSecurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@CrossOrigin(origins = "*", allowedHeaders ="*")
public class CustomUserDetailService implements UserDetailsService{//DB에서 찾기
	
	private final UserRepository userRepository;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

}
