package com.bus.repository;

import com.bus.exception.InvalidCredentialException;
import com.bus.model.CurrentUserLoginSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<CurrentUserLoginSession, Integer> {

	Optional<CurrentUserLoginSession> findByUserId(Integer userId) throws InvalidCredentialException;

	@Query("select c from CurrentUserLoginSession c where c.authKey=?1")
	Optional<CurrentUserLoginSession> findByAuthkey(String key);
}	
