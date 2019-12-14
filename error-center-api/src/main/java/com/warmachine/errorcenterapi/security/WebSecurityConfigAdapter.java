package com.warmachine.errorcenterapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.warmachine.errorcenterapi.dto.UserDetailDto;
import com.warmachine.errorcenterapi.entity.User;
import com.warmachine.errorcenterapi.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManagerBean();
	}
	
	@Bean  
	public static BCryptPasswordEncoder passwordEncoder() {  
	    return new BCryptPasswordEncoder();  
		}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository)
			throws Exception {
		if (userRepository.count() == 0) {
			User user = new User();
			user.setEmail("admin@gmail.com");
			user.setPassword("123456");

			userRepository.save(user);
		}

		builder.userDetailsService(email -> new UserDetailDto(userRepository.findByEmailEquals(email)))
        .passwordEncoder(passwordEncoder());
	}

}
