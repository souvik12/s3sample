package com.springbootdev.amazon.s3.example.aws.config;

import java.util.List;

public interface CustomeUserDetailsService {
	UserDetails getUserByUserName(String userName);
	void loadUser(List<UserDetails> users);
}
