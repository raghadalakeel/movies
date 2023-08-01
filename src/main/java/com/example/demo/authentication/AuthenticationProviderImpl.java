//package com.example.demo.authentication;
//
//
//import com.example.demo.Models.movieuser;
//import com.example.demo.services.userService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
//@Component
//public class AuthenticationProviderImpl implements AuthenticationProvider {
//    @Autowired
//    private userService Service;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String email = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        movieuser user = Service.getUserByEmail(email);
//        if (user == null) {
//            throw new BadCredentialsException("Invalid email or password");
//        }
//
//        if (!password.equals(user.getPassword())) {
//            throw new BadCredentialsException("Invalid email or password");
//        }
//
//        return new UsernamePasswordAuthenticationToken(email, password, Collections.emptyList());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//}
