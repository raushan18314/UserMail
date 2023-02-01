package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.MailException;
import com.masai.exception.UserException;
import com.masai.model.Mail;
import com.masai.model.User;
import com.masai.serviceImplementation.UserServiceImp;

@RestController
public class UserController {

	@Autowired
	private UserServiceImp ui;
	
	@PostMapping("/masaimail/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws MailException, UserException{
		User u1= ui.register(user);
		return new ResponseEntity<>(u1,HttpStatus.CREATED);
	}
	
	@PostMapping("/masaimail/login")
	public ResponseEntity<String> loginUser(@RequestBody User user) throws MailException, UserException{
		String u1= ui.Login(user);
		return new ResponseEntity<>(u1,HttpStatus.OK);
	}
	@GetMapping("/masaimail/mail")
	public ResponseEntity<List<Mail>> getMail(@RequestBody User user) throws MailException, UserException{
		List<Mail> u1= ui.allMails();
		return new ResponseEntity<>(u1,HttpStatus.OK);
	}
	@GetMapping("/masaimail/starred")
	public ResponseEntity<List<Mail>> starredMail(@RequestBody User user) throws MailException, UserException{
		List<Mail> u1= ui.allStaredMails();
		return new ResponseEntity<>(u1,HttpStatus.OK);
	}
	@PutMapping("/masaimail/register")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws MailException, UserException{
		User u1= ui.updateUser(user);
		return new ResponseEntity<>(u1,HttpStatus.OK);
	}
	
	
}
