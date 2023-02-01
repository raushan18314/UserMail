package com.masai.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUserSession {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	Integer UserId;
	boolean present;
	public CurrentUserSession(Integer id, Integer userId, boolean present) {
		super();
		this.id = id;
		UserId = userId;
		this.present = present;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	@Override
	public String toString() {
		return "CurrentUserSession [id=" + id + ", UserId=" + UserId + ", present=" + present + "]";
	}
	
	
	
	
}

