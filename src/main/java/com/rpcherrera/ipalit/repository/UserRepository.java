package com.rpcherrera.ipalit.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rpcherrera.ipalit.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
