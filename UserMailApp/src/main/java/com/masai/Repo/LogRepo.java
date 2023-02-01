package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentUserSession;

public interface LogRepo extends JpaRepository<CurrentUserSession, Integer>{

}
