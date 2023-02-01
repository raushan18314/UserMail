package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.MailException;
import com.masai.exception.UserException;
import com.masai.model.Mail;
import com.masai.serviceImplementation.MailServiceImp;

@RestController
public class MailController {

	@Autowired
	private MailServiceImp mi;
	
	@PostMapping("/masaimail/mail")
	public ResponseEntity<Mail> SendMail(@RequestBody Mail mail) throws MailException, UserException{
		Mail m=mi.sendMail(mail);
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	@PostMapping("/masaimail/starred/{id}")
	public ResponseEntity<String> StarMail(@PathVariable Integer id) throws MailException, UserException{
		String m=mi.StarMail(id);
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	@DeleteMapping("/masaimail/delete/{id}")
	public ResponseEntity<String> deleteMail(@PathVariable Integer id) throws MailException, UserException{
		String m=mi.deleteMail(id);
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	
}
