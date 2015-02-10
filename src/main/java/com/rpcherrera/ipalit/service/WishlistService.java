package com.rpcherrera.ipalit.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.rpcherrera.ipalit.entity.User;
import com.rpcherrera.ipalit.entity.Wishlist;
import com.rpcherrera.ipalit.repository.UserRepository;
import com.rpcherrera.ipalit.repository.WishlistRepository;

@Service
public class WishlistService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WishlistRepository wishlistRepository;
	
	
	public void save(Wishlist wish, String name){
		User user = userRepository.findByUsername(name);
		Date detu = new Date();
		wish.setDatePosted(detu);
		wish.setUser(user);
		wishlistRepository.save(wish);
	}
	
	@PreAuthorize("#wishlist.user.username == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("wishlist")Wishlist wishlist){
		wishlistRepository.delete(wishlist);
	}
	
	public Wishlist findOne(int id){
		return wishlistRepository.findOne(id);
	}

	public List<Wishlist> findAllWish() {
		return wishlistRepository.findAll();
	}

	@Transactional
	public Wishlist findOneWish(int id) {
		Wishlist wishlist = wishlistRepository.findOne(id);
		return wishlist;
	}

	public List<Wishlist> findByWishlistName(String wishlistName){
		List<Wishlist> wish = wishlistRepository.findByWishlistName(wishlistName);
		
		return wish;
	}
	
}
