package com.placement;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String username;
	
	private int score;
	private String grade;
	
	/**
	 * default constructor
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * parameterized constructor of class
	 * @param username
	 * @param score
	 * @param grade
	 */
	public User(String username, int score, String grade) {
		super();
		this.username = username;
		this.score = score;
		this.grade = grade;
	}

	/**
	 * object user name
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * object score
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * object grade
	 * @return
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * store user name into object field
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * store score into object field
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * store grade into object field
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
