package com.example.testproject.Service;

import com.example.testproject.entity.Users;
import com.example.testproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder; //시큐리티 설정에 Bean BCryptPasswordEncoder 주입

    public Users create(String username,String password) {
        Users user = new Users();
        user.setUsername(username);
        //비밀번호 암호화
        user.setPassword(passwordEncoder.encode(password));
        //저장
        this.userRepository.save(user);
        return null;
    }

}