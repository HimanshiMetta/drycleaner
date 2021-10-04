package com.cg.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.main.beans.User;

public interface IUserRepository extends JpaRepository<User,Integer> {
	/*
	 * public User signIn(User user); public String signOut(User user); public
	 * String changePassword(long id, User user);
	 */
}
