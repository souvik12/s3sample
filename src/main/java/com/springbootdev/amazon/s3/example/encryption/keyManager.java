package com.springbootdev.amazon.s3.example.encryption;

import java.security.*;

public interface keyManager {
	public PublicKey getPublicKey();
	public static PrivateKey getPrivateKey() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSymmetricKey();
	public String getPushKey();
	

}
