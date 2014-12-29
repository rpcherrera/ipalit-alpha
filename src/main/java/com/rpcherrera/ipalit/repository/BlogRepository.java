package com.rpcherrera.ipalit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpcherrera.ipalit.entity.Blog;
import com.rpcherrera.ipalit.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);
		
	
}
