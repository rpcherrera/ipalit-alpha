package com.rpcherrera.ipalit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rpcherrera.ipalit.entity.Blog;
import com.rpcherrera.ipalit.entity.Item;
import com.rpcherrera.ipalit.entity.Role;
import com.rpcherrera.ipalit.entity.User;
import com.rpcherrera.ipalit.entity.Wishlist;
import com.rpcherrera.ipalit.repository.BlogRepository;
import com.rpcherrera.ipalit.repository.ItemRepository;
import com.rpcherrera.ipalit.repository.RoleRepository;
import com.rpcherrera.ipalit.repository.UserRepository;
import com.rpcherrera.ipalit.repository.WishlistRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private WishlistRepository wishlistRepository;
	
	@PostConstruct
	public void init(){
		if(roleRepository.findByName("ROLE_ADMIN") == null){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		User userAdmin = new User();
		userAdmin.setEnabledEh(true);
		userAdmin.setName("admin");
		userAdmin.setLname("admin");
		userAdmin.setEmail("admin@mail.com");
		userAdmin.setContactnum("09987284423");
		userAdmin.setUsername("admin");
		Date detu = new Date();
		userAdmin.setDateJoined(detu);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("nimdadmin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		
		User userRalph = new User();
		userRalph.setEnabledEh(true);
		userRalph.setName("Ralph");
		userRalph.setLname("Herrera");
		userRalph.setEmail("rpcherrera@mail.com");
		userRalph.setContactnum("09129876642");
		userRalph.setUsername("ralph");
		userRalph.setDateJoined(detu);
		userRalph.setPassword(encoder.encode("raprap"));
		userRalph.setRoles(roles);
		
		userRepository.save(userRalph);
		userRepository.save(userAdmin);
		
		User userMike = new User();
		userMike.setEnabledEh(true);
		userMike.setName("Mike");
		userMike.setLname("Gultia");
		userMike.setEmail("mikee@mail.com");
		userMike.setContactnum("09129876642");
		userMike.setUsername("mikee");
		userMike.setDateJoined(detu);
		userMike.setPassword(encoder.encode("mikemike"));
		userMike.setRoles(roles);
		userRepository.save(userMike);
		
		User userOmel = new User();
		userOmel.setEnabledEh(true);
		userOmel.setName("Omel");
		userOmel.setLname("Bautista");
		userOmel.setEmail("omel@mail.com");
		userOmel.setContactnum("09129876642");
		userOmel.setUsername("omeru");
		userOmel.setDateJoined(detu);
		userOmel.setPassword(encoder.encode("omelomel"));
		userOmel.setRoles(roles);
		userRepository.save(userOmel);
		
		User userJenndale = new User();
		userJenndale.setEnabledEh(true);
		userJenndale.setName("Jenndale");
		userJenndale.setLname("Merza");
		userJenndale.setEmail("buchik@mail.com");
		userJenndale.setContactnum("09129876642");
		userJenndale.setUsername("jenny");
		userJenndale.setDateJoined(detu);
		userJenndale.setPassword(encoder.encode("jenndale"));
		userJenndale.setRoles(roles);
		userRepository.save(userJenndale);
		
		Blog blogJavavids = new Blog();
		blogJavavids.setItemname("Test Item");
		String perks = "It's just that I don't want to be somebody's crush. If somebody likes me, I want them to like the real me, not what they think I am";
		blogJavavids.setItemdescription(perks);
		Date detus = new Date();
		blogJavavids.setDatePosted(detus);
		blogJavavids.setItemCondition("Already Used");
		blogJavavids.setWarranty("No Warranty");
		
//		blogJavavids.setName("X-ART");
//		blogJavavids.setUrl("http://www.google.com");
		blogJavavids.setUser(userAdmin);
		blogRepository.save(blogJavavids);
		
		Wishlist wishes = new Wishlist();
		wishes.setWishlistName("Wish Test");
		wishes.setWishlistDesc("Looking for a book");
		wishes.setDatePosted(detus);
		wishes.setUser(userAdmin);
		wishlistRepository.save(wishes);
		

		/* Item item1 = new Item();
		 item1.setBlog(blogJavavids);
		 item1.setTitle("First");
		 item1.setLink("http://www.bing.com");
		 item1.setPostDate(new Date());
		 itemRepository.save(item1);
		
		 Item item2 = new Item();
		 item2.setBlog(blogJavavids);
		 item2.setTitle("Second");
		 item2.setLink("http://www.yahoo.com");
		 item2.setPostDate(new Date());
		 itemRepository.save(item2);*/
		}
	}
}
