package com.example.demo.webSecurity;

import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
//협업 관련 - 다른 ip에서 접속 허용
@CrossOrigin(origins = "*", allowedHeaders ="*")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    // 회원가입
    @PostMapping("/join")
    public void join(@RequestBody User user) {
    	userRepository.save(user);
    }
    
    // 아이디 중복검사
    @GetMapping("/checkEmail")
    public boolean checkEmail(String email) {
    	boolean checkEmail = userRepository.checkEmail(email);
    	System.out.println(":::::::::::::::::::::::::::::"+checkEmail);
    	return checkEmail;
    }

    // 로그인
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        User member = userRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        
        return jwtTokenProvider.createToken(member);
    }
}