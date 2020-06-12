package com.springbootdev.amazon.s3.example.encryption;
import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryptapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 /*Base64.Encoder encoder = Base64.getEncoder();  
	        // Creating byte array  
	        byte byteArr[] = {1,2};  
	        // encoding byte array  
	        byte byteArr2[] = encoder.encode(byteArr);  
	        System.out.println("Encoded byte array: "+byteArr2);  
	        byte byteArr3[] = new byte[5];                // Make sure it has enough size to store copied bytes  
	        int x = encoder.encode(byteArr,byteArr3);    // Returns number of bytes written  
	        System.out.println("Encoded byte array written to another array: "+byteArr3);  
	        System.out.println("Number of bytes written: "+x);  
	      
	        // Encoding string  
	        String str = encoder.encodeToString("password".getBytes());  
	        System.out.println("Encoded string: "+str);  

	}
*/
		
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		    System.out.println("encoder:  " + encoder.encode("password"));
		   // System.out.println("encoder:  " + encoder.encode("admin"));

		   /* if (encoder.matches("abel", "$2a$10$IAz6WzJ314LH1NXq7Rf.dOYPP2uvzk08g.eAl9l4DRG4YsxavEV4W")) {
		      System.out.println("encoder: true");
		    }


		    System.out.println("------------华丽的分割线-----------------------");
		    String Md5Password = MD5Util.encode("abel");
		    System.out.println("Md5Password:  " + Md5Password);
		    System.out.println("encoder:  " + encoder.encode(Md5Password));
		    if (encoder.matches(Md5Password, "$2a$10$37MXEfzlbtC6QSsRTlRhIOmykMRJtO5mU8Y.yiJBjy1x4WYWFR5gG")) {
		      System.out.println("Md5Password: true");
		    }*/

		  }
}
