package com.placement;

import java.util.ArrayList;
import java.util.List;

public class QuestionHelper {
	/**
	 * return the object of question according to difficulty level
	 * @param question
	 * @param level
	 * @return
	 */
	public static List<Questions> selectQuestions(List<Questions> question, int level) {
		
		List<Questions> q = new ArrayList<Questions>();
		
		if(level == 1) {
			for(int i = 0; i < 5; i++) {
				q.add(question.get(i));
			}
		}else if(level == 3) {
			for(int i = 5; i < 10; i++) {
				q.add(question.get(i));
			}
		}else {
			for(int i = 10; i < 15; i++) {
				q.add(question.get(i));
			}
		}
		return q;
	}
}
