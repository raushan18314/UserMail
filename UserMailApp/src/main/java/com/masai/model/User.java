package com.masai.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  
  @Pattern(regexp = "^[a-zA-Z]*$", message = "First Name Special Characters are not Allowed.")
  private String name;

  @Pattern(regexp = "[789]{1}[0-9]{9}",message = "invalid mobile number")
  private String phoneNo;
  
  @Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])).{6,100}$", message = "password not allowed")
  private String password;
  
  
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  @Past(message = "date should be past")
  private Date dateOfBirth;
 
  @JsonIgnore
  @OneToOne(cascade = CascadeType.ALL)
  private Email email;
 
  

}
