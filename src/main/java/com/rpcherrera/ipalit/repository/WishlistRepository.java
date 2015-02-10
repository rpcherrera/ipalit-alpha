package com.rpcherrera.ipalit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpcherrera.ipalit.entity.User;
import com.rpcherrera.ipalit.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{

	List<Wishlist> findByUser(User user);
	List<Wishlist> findByWishlistName(String wishlistName);
}	
