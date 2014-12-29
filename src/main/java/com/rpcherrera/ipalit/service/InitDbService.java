package com.rpcherrera.ipalit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpcherrera.ipalit.entity.Blog;
import com.rpcherrera.ipalit.entity.Item;
import com.rpcherrera.ipalit.entity.Role;
import com.rpcherrera.ipalit.entity.User;
import com.rpcherrera.ipalit.repository.BlogRepository;
import com.rpcherrera.ipalit.repository.ItemRepository;
import com.rpcherrera.ipalit.repository.RoleRepository;
import com.rpcherrera.ipalit.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setUsername("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setUsername("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setUsername("admin");
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogBlog = new Blog();
		blogBlog.setName("Testing");
		blogBlog.setUrl("www.testing.com");
		blogBlog.setUser(userAdmin);
		blogRepository.save(blogBlog);
		
		Item item1 = new Item();
		item1.setBlog(blogBlog);
		item1.setTitle("First");
		item1.setLink("http://www.google.com");
		item1.setPostDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogBlog);
		item2.setTitle("Second");
		item2.setLink("http://www.googly.com");
		item2.setPostDate(new Date());
		itemRepository.save(item2);
		
	}
}
