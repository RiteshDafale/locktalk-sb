package com.Locktalk.Service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SecrectMessanger {

	public String getSecretMsg(String hint) {
		
		String str = "This#is-my!first.namehello&^%$";
		str = str.concat(hint);
		
		String secretMsg = " ";
		Random rnd = new Random(); 
		for(int i=1;i<=9;i++) {
           		int val = rnd.nextInt(30);	
			secretMsg = secretMsg + str.charAt(val);
			
		}
		secretMsg = secretMsg.trim();
		
		return secretMsg ;
	}
}
