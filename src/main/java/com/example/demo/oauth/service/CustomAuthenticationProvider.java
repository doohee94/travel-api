package com.example.demo.oauth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * TODO : 주석 풀기
 * @createBy  DO
 * @Date  2020.06.13
 *
*/

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

//    private final PasswordEncoder passwordEncoder;

    // private final UserRepository userRepository;

    // private final AuthorityRepository authorityRepository;

    @Override
    public Authentication authenticate(Authentication authentication) {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

////    User user = userRepository.findByEmail(Email.of(name))
//        User user = userRepository.findByEmail(name)
//                .orElseThrow(() -> new UserNotFoundException("user is not exists"));
//
//        if (!user.getPassword().isMatched(password)) {
//            throw new InvalidLoginInputException("password is not valid");
//        }
//
//        Set<Authority> authorities = user.getAuthorities();
//        authorities.stream().map(authority -> authority.getName()).collect(Collectors.toList());
//        return new UsernamePasswordAuthenticationToken(name, password, authorities.stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
//                .collect(Collectors.toSet()));

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}

