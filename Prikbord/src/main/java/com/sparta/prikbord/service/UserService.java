package com.sparta.prikbord.service;

import com.sparta.prikbord.dto.SignupRequestDto;
import com.sparta.prikbord.entity.User;
import com.sparta.prikbord.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();

        // 유효성 검사: username은 최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)로 구성되어야 한다.
        if (username.length() < 4 || username.length() > 10 || !Pattern.matches("^[a-z0-9]*$", username)) {
            throw new IllegalArgumentException("유효하지 않은 아이디입니다.");
        }

        // 유효성 검사: password는 최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9)로 구성되어야 한다.
        if (password.length() < 8 || password.length() > 15 || !Pattern.matches("^[a-zA-Z0-9]*$", password)) {
            throw new IllegalArgumentException("유효하지 않은 비밀번호입니다.");
        }

        // DB에 중복된 username이 없다면 회원을 저장한다.
        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new IllegalArgumentException("중복된 아이디가 존재합니다.");
        }

        User newUser = new User(username, password);
        userRepository.save(newUser);
    }
}

