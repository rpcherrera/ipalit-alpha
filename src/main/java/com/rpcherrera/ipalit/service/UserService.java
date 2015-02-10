package com.rpcherrera.ipalit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rpcherrera.ipalit.entity.Blog;
import com.rpcherrera.ipalit.entity.Feedback;
import com.rpcherrera.ipalit.entity.Item;
import com.rpcherrera.ipalit.entity.Role;
import com.rpcherrera.ipalit.entity.User;
import com.rpcherrera.ipalit.entity.Wishlist;
import com.rpcherrera.ipalit.repository.BlogRepository;
import com.rpcherrera.ipalit.repository.FeedbackRepository;
import com.rpcherrera.ipalit.repository.ItemRepository;
import com.rpcherrera.ipalit.repository.RoleRepository;
import com.rpcherrera.ipalit.repository.UserRepository;
import com.rpcherrera.ipalit.repository.WishlistRepository;

@Service
@Transactional
public class UserService {

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
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		/*for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "postDate"));
			blog.setItems(items);
		}*/
		List<Wishlist> wish = wishlistRepository.findByUser(user);
		List<Feedback> feedbacks = feedbackRepository.findByUser(user);
		user.setWish(wish);
		user.setBlogs(blogs);
		user.setFeedbacks(feedbacks);
		return user;
	}
	
//	@Transactional //reduntant sa naunang method kaibigan. 
//	public User findOneWithWish(int id){
//		User user = findOne(id);
//		List<Wishlist> wish = wishlistRepository.findByUser(user);
//		user.setWish(wish);
//		return user;
//	}

	public void save(User user) {
		user.setEnabledEh(true);
		Date date = new Date();
		user.setDateJoined(date);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);

		userRepository.save(user);
	}

	public User findOneWithBlogs(String name) {
		User user = userRepository.findByUsername(name);
		return findOneWithBlogs(user.getId());
	}

	public void delete(int id) {
		userRepository.delete(id);
	}

	public User findOne(String username) {
		return userRepository.findByUsername(username);
	}

	public User findOneEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findOneWithWish(String name) {
		User user = userRepository.findByUsername(name);
		return findOneWithBlogs(user.getId());
	}

	public User findOneWithFeeds(String name) {
		User user = userRepository.findByUsername(name);
		return findOneWithBlogs(user.getId());
	}
}
