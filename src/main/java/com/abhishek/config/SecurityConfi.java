package com.abhishek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
public class SecurityConfi {

	@Bean
	 public RestTemplate restTemplate()
	 {
		 return new RestTemplate();
	 }
		
	 @Bean
	    public UserDetailsService userDetailsService() {
	        UserDetails admin = User.withUsername("abhi")
	                .password("{noop}abhi123") // {noop} means no password encoding
	                .roles("ADMIN")
	                .build();

	        UserDetails user1 = User.withUsername("ravi")
	                .password("{noop}ravi123")
	                .roles("USER")
	                .build();

	        UserDetails user2 = User.withUsername("samarth")
	                .password("{noop}samarth123")
	                .roles("USER")
	                .build();

	        return new InMemoryUserDetailsManager(admin, user1, user2);
	    }
	
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf(csrf -> csrf.disable())
	                .authorizeHttpRequests(auth -> auth
	                        .requestMatchers("/student/save").hasRole("ADMIN") // only admin can save
	                        .requestMatchers("/student/getbyid/**", "/student/getall").hasAnyRole("ADMIN", "USER")
	                        .anyRequest().authenticated()
	                )
	                .httpBasic(Customizer.withDefaults())
	                .formLogin(Customizer.withDefaults());

	        return http.build();
	    }
	
       
}
