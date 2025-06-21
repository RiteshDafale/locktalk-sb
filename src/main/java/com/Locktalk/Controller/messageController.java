package com.Locktalk.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Locktalk.Entity.Message;
import com.Locktalk.Repository.messageRepo;
import com.Locktalk.Service.SecrectMessanger;

@RestController
@CrossOrigin(origins= "https://locktalk13.netlify.app/")
public class messageController {

	@Autowired
	private messageRepo msgrepo;
	
//	@Autowired
//	Message Message;

		
	@Autowired
	private SecrectMessanger SecrectMessanger;
	
	
	@PostMapping("/sentMessage")
	public String msg(String msg , String password,String hint) {
		
		String secret = SecrectMessanger.getSecretMsg(hint);
		Message Message = new Message();
		Message.setMessage(msg);
		Message.setPassword(password);
		Message.setSecret(secret);		
		System.out.println("Secret = "+secret);
		msgrepo.save(Message);
		
		return secret;
	}

	@PostMapping("/varifyPassword")
	public List<Message> varify(String secret, String password) {

		secret = secret.trim();
		password = password.trim();
		System.out.println("secret = " + secret);
		System.out.println("password = " + password);
		List<Message> messageList = msgrepo.findBySecretAndPassword(secret, password);

		if (messageList.equals(null)) {
			System.out.println("no data found");
		}
		return messageList;	
	}
}
