package com.springbootdev.amazon.s3.example.aws.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	private CustomeUserDetailsService customeUserDetailsService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		final List<AppUser> users = Arrays.asList(new AppUser(1,"admin","password","ADMIN"));
		System.out.println("Its in working stage --1");
		
		com.springbootdev.amazon.s3.example.aws.config.UserDetails userDetails = customeUserDetailsService.getUserByUserName("admin");
		
		List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+"ADMIN");
		return new User(userDetails.getUsername(), encoder.encode(userDetails.getPassword()), authorities);
	}
	
	
	private static class AppUser{
		private Integer id;
		private String username, password;
		private String role;
		
		
		public AppUser(Integer id, String username, String password, String role) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.role = role;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	}

}
