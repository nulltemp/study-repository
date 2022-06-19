package com.nulltemp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		RequestMatcher csrfRequestMatcher = new RequestMatcher() {
			private final AntPathRequestMatcher disabledRequestMatcher = new AntPathRequestMatcher("/api/**");

			@Override
			public boolean matches(HttpServletRequest request) {
				if ("GET".equals(request.getMethod())) {
					return false;
				}
				return !disabledRequestMatcher.matches(request);
			}
		};

		http.csrf().requireCsrfProtectionMatcher(csrfRequestMatcher).and()
				.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.mvcMatchers("/api/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		UserDetails user = User.withUsername("user")
				.password(encoder.encode("password"))
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
