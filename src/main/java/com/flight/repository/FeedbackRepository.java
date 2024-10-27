package com.flight.repository;

import com.flight.exception.FeedbackException;
import com.flight.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	@Query("select f from Feedback f")
	List<Feedback> getAllFeedbacks() throws FeedbackException;
}
