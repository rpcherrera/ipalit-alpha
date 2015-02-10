package com.rpcherrera.ipalit.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.rpcherrera.ipalit.entity.Blog;
import com.rpcherrera.ipalit.entity.User;
import com.rpcherrera.ipalit.repository.BlogRepository;
import com.rpcherrera.ipalit.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(Blog blog, String name) {
		User user = userRepository.findByUsername(name);
		Date date = new Date();
		blog.setDatePosted(date);
		blog.setUser(user);
		blogRepository.save(blog);
	}

	@PreAuthorize("#blog.user.username == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog")Blog blog) {
		blogRepository.delete(blog);
	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}
	
	public List<Blog> findAllBlogs(){
		return blogRepository.findAll();
	}

	@Transactional
	public Blog findOneBlog(int id) {
		Blog blog = blogRepository.findOne(id);
		return blog;
	}
	
	
	public List<Blog> findByItemname(String itemName){
		List<Blog> blog = blogRepository.findByItemname(itemName);
		
		return blog;
	}
}
