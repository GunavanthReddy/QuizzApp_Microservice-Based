package com.quizapp.quizservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapp.feign.QuizInterface;
import com.quizapp.quizdao.QuizDao;
import com.quizapp.quizmodel.DTO;
import com.quizapp.quizmodel.Question;
import com.quizapp.quizmodel.QuestionWrapper;
import com.quizapp.quizmodel.Quiz;
import com.quizapp.quizmodel.Response;


@Service
public class QuizService {
	
	@Autowired
	QuizDao quizdao;
	@Autowired
	QuizInterface quizInterface;
	

	public ResponseEntity<String> createQuiz(String Quiztitle, String questiontitle, String Difficultylevel) {
		try 
		{
			List<Integer> Questions = quizInterface.getQuestionsforQuiz(questiontitle, Difficultylevel).getBody();
						
			Quiz quiz = new Quiz();
			quiz.setQuestionTitle(Quiztitle);
			quiz.setQuestionsIds(Questions);
			quizdao.save(quiz);
			System.out.println(Questions);
		
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Failed to Create", HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizBasedOnId(Integer id) {
		
		try 
		{
			Optional<Quiz> quiz = quizdao.findById(id);
			List<Integer> questionsIdsFromDB = quiz.get().getQuestionsIds();
			List<QuestionWrapper> questionsToUser = quizInterface.getQuestionsFromId(questionsIdsFromDB).getBody();;

			return new ResponseEntity<>(questionsToUser, HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList(), HttpStatus.NO_CONTENT);


	}

	public ResponseEntity<Integer> submitQuiz(List<Response> responses) {
		
		try 
		{
			int score = quizInterface.getScore(responses).getBody();
			
			return new ResponseEntity<>(score, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	
	
}
