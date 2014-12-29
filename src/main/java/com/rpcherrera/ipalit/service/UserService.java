package com.rpcherrera.ipalit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rpcherrera.ipalit.entity.Blog;
import com.rpcherrera.ipalit.entity.Item;
import com.rpcherrera.ipalit.entity.User;
import com.rpcherrera.ipalit.repository.BlogRepository;
import com.rpcherrera.ipalit.repository.ItemRepository;
import com.rpcherrera.ipalit.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findUser(int id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User findUserWithBlogs(int id) {
		User user = findUser(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "postDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		userRepository.save(user);
		
	}
}
