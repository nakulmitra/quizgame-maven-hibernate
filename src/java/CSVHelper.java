package com.placement;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class CSVHelper {
	/**
	 * read question from csv file
	 * @return
	 */
	public static List<Questions> readQuestions(){
		List<Questions> ques = new ArrayList<Questions>();
		
		String[] level = {"Easy.csv", "Hard.csv", "Medium.csv"};
		Scanner sc = null;
		
		try {
	    	for (String fname : level) {
	    		sc = new Scanner( new File("CSVFile//"+fname));
	  	      
		  	      // Check if there is another line of input
		  	      while(sc.hasNextLine()){
		  	        String str = sc.nextLine();
		  	        Questions q = new Questions();
		  	        // parse each line using delimiter
		  	        parseData(str, q);
		  	        ques.add(q);
		  	      }
		  	    } 
	    }catch (IOException  exp) {
		  	      // TODO Auto-generated catch block
		  	      exp.printStackTrace();
		  	    }finally{
		  	      if(sc != null)
		  	        sc.close();
		  	    }
		return ques;
	}
	
	/**
	 * split the data 
	 * @param str
	 * @param q
	 */
	private static void parseData(String str, Questions q){	
	    Scanner lineScanner = new Scanner(str);
	    lineScanner.useDelimiter("\\|");
	    
	    while(lineScanner.hasNext()){
			q.setQuestion(lineScanner.next());
			q.setCorrect(lineScanner.next());
	    	q.setOp1(lineScanner.next());
	    	q.setOp2(lineScanner.next());
	    	q.setOp3(lineScanner.next());
	    	q.setOp4(lineScanner.next());
	    }
	    lineScanner.close();
	 }
}
