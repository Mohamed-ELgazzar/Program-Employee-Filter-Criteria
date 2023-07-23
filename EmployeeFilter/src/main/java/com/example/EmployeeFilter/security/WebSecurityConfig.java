// package com.example.EmployeeFilter.security;

// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// import java.util.Arrays;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig {
//     @Bean
//     public UserDetailsService userDetailsService() {
//         return new InMemoryUserDetailsManager(
//                 new User("user", "password", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//     }

//     @Bean
//     public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//         http.authorizeHttpRequests((requests) -> requests
//                 .anyRequest().permitAll());
//         return http.build();
//     }

// }