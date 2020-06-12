package com.springbootdev.amazon.s3.example.aws.config;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootdev.amazon.s3.example.encryption.DecryptionApp;

@Service
public class CustomeUserDetailsServiceImpl implements CustomeUserDetailsService {

	private List<UserDetails> users;
	
	@Override
	public UserDetails getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		System.out.println("Its in working stage --2");
		for(UserDetails user : users) {
			if(user.getUsername().equals(userName)) {
				System.out.println("Found User ---" + user);
				user.setPassword(DecryptionApp.decrypt(user.getPassword()));
				System.out.println("Found User ---" + user);
				return user;
			}
				
		}
		
		return null;
		
		//return new UserDetails(1,"admin","password","ADMIN");
	}

	@Override
	public void loadUser(List<UserDetails> users) {
		// TODO Auto-generated method stub
		this.users=users;
	}

}
