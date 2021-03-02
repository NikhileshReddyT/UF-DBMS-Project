package com.olist.DBMSProject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.olist.DBMSProject.model.Users;

@Repository
public class UserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	public int add(Users user)
	{
		return jdbcTemplate.update("insert into USERS(NAME, PASSWORD, EMAIL) VALUES(?,?,?)", user.getName(), user.getPassword(), user.getEmail());
	}
	
	public List<Users> findByNameAndPassword(String name, String password) {
		return jdbcTemplate.query("select * from USERS s where s.name=? and s.password=?", new BeanPropertyRowMapper<>(Users.class), name, password);
	}
	
	public List<Users> findByName(String name) {
		return jdbcTemplate.query("select * from USERS s where s.name=?", new BeanPropertyRowMapper<>(Users.class), name);
	}

}
