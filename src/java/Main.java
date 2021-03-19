package com.placement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Class --> Main
 * @author praveenbhatt
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creating session for transaction of database
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		try {
			/**
			 * variables
			 */
			int level;
			int choice;
			String name;
			String[] answer = {"-1", "-1", "-1", "-1", "-1"};
			String[] abality = {"Very Strong", "Strong", "Good", "Bad", "Poor"};
			boolean flag = true;
			
			InputStreamReader r = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(r);
			
			CSVHelper lqr = new CSVHelper();
			List<Questions> questions = lqr.readQuestions();
			
			System.out.println("Enter your name: ");
			name = br.readLine();
			
			//block for taking input the difficulty level
			while(flag) {
				int score = 0;				
				while(true) {
					try {
						System.out.println("1.Easy 2.Medium 3.Hard");
						System.out.print("Enter your choise: ");
						level = Integer.parseInt(br.readLine());
						
						if(level != 1 && level != 2 && level != 3) {
							throw new Exception ("\n-------Wrong Choice-------\nPlease Select the right choice\n");
						}else {
							break;
						}
					}catch (Exception ex){
						System.out.println(ex.getMessage());
					}
				}
				
				List<Questions> q = new ArrayList<Questions>();
				QuestionHelper qh = new QuestionHelper();
				q = qh.selectQuestions(questions, level);
				
				//showing question to user
				System.out.println("\n--------Here's the Questions-------");
				
				for(int i = 0; i < 5; i++) {
					System.out.print("Question " + (i + 1));
					System.out.println(" " + q.get(i).getQuestion());
					System.out.println("Option 1: " + q.get(i).getOp1());
					System.out.println("Option 2: " + q.get(i).getOp2());
					System.out.println("Option 3: " + q.get(i).getOp3());
					System.out.println("Option 4: " + q.get(i).getOp4());
					System.out.println("Enter Your Option: ");
					answer[i] = br.readLine();
					if(answer[i].equals(q.get(i).getCorrect())) {
						score++;
					}
				}
				
				if(score > 0) {
					System.out.println(abality[5 - score]);	
				}
				String grade;
				if(score > 0) {
					grade = abality[5- score];
				}else {
					grade = "NA";
				}
				//showing result
				System.out.println(name+ " your Score is:"+score +"and Grade is:"+grade);
				Database db = new Database();
				db.insertUser(name, score, grade, session);
				
				//asking user want to play again
				while(true) {
					try {
						System.out.println("\nDo You Want to Play Again ?");
						System.out.print("1.Yes 2. No\nEnter Your Choice: ");
						choice = Integer.parseInt(br.readLine());
						if(choice == 1 || choice == 2) {
							if(choice == 1) {
								flag = true;
							}else {
								flag = false;
								System.out.println("\n------------Thank You------------");
							}
							break;
						}else {
							System.out.println("\n-------Wrong Choice------\nPlease Select Again");
						}
					}catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}finally {
			//close session and factory variables.
			t.commit();
			session.close();
			factory.close();
		}
	}

}
