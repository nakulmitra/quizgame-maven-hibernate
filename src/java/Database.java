package com.placement;

import org.hibernate.Session;

public class Database {
	/**
	 * create query to insert user data into database
	 * @param name
	 * @param score
	 * @param grade
	 * @param session
	 */
	public void insertUser(String name, int score, String grade, Session session) {
		// TODO Auto-generated method stub
		User user = new User(name, score, grade);
		
		session.save(user);
	}
}
