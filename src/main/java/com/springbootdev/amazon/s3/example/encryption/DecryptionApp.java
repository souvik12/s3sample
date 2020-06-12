package com.springbootdev.amazon.s3.example.encryption;

import java.util.Base64;

import org.springframework.stereotype.Component;
import java.security.PublicKey;


@Component
public class DecryptionApp {
	
	public static String decrypt(String value ) {
		Base64.Decoder decoder = Base64.getDecoder();  
		String dStr = new String(decoder.decode(value));
	//	value.decryptPassword(keyManager.getPrivateKey());
		//String dStr=value.getPassword();
		return dStr ;
	}

}
