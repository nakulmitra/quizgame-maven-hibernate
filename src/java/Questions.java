package com.placement;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Questions {
	@Id
	private String question;
	
	private String correct;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * parameterized constructor of class
	 * @param question
	 * @param correct
	 * @param op1
	 * @param op2
	 * @param op3
	 * @param op4
	 */
	public Questions(String question, String correct, String op1, String op2, String op3, String op4) {
		super();
		this.question = question;
		this.correct = correct;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
	}

	/**
	 * object question
	 * @return
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * object correct answer
	 * @return
	 */
	public String getCorrect() {
		return correct;
	}

	/**
	 * object option1
	 * @return
	 */
	public String getOp1() {
		return op1;
	}

	/**
	 * object option2
	 * @return
	 */
	public String getOp2() {
		return op2;
	}
	
	/**
	 * object option3
	 * @return
	 */
	public String getOp3() {
		return op3;
	}

	/**
	 * object option3
	 * @return
	 */
	public String getOp4() {
		return op4;
	}

	/**
	 * store question into object field
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
	/**
	 * store correct option into object field
	 * @param correct
	 */
	public void setCorrect(String correct) {
		this.correct = correct;
	}

	/**
	 * store option1 into object field
	 * @param op1
	 */
	public void setOp1(String op1) {
		this.op1 = op1;
	}

	/**
	 * store option2 into object field
	 * @param op2
	 */
	public void setOp2(String op2) {
		this.op2 = op2;
	}

	/**
	 * store option3 into object field
	 * @param op3
	 */
	public void setOp3(String op3) {
		this.op3 = op3;
	}

	/**
	 * store option4 into object field
	 * @param op4
	 */
	public void setOp4(String op4) {
		this.op4 = op4;
	}
}
