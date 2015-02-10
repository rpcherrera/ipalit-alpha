package com.rpcherrera.ipalit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpcherrera.ipalit.entity.Feedback;
import com.rpcherrera.ipalit.entity.User;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

	List<Feedback> findByUser(User user);

}
