package com.rpcherrera.ipalit.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpcherrera.ipalit.entity.Feedback;
import com.rpcherrera.ipalit.entity.User;
import com.rpcherrera.ipalit.repository.FeedbackRepository;
import com.rpcherrera.ipalit.repository.UserRepository;

@Service
public class FeedbackService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	public void save(Feedback feedback, String name) {
		User user = userRepository.findByUsername(name);
		Date date = new Date();
		feedback.setDatePosted(date);
		feedback.setUser(user);
		feedbackRepository.save(feedback);
	}

	public void save(Feedback feed) {
		User user = new User();
		Date date = new Date();
		feed.setDatePosted(date);
		feed.setUser(user);
		feedbackRepository.save(feed);
	}
}
