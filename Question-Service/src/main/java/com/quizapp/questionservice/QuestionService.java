package com.quizapp.questionservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.quizapp.questiondao.QuestionDao;
import com.quizapp.questionmodel.Question;
import com.quizapp.questionmodel.QuestionWrapper;
import com.quizapp.questionmodel.Response;


@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questiondao;
	
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		try 
		{
			return new ResponseEntity<> (questiondao.findAll(), HttpStatus.OK);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	
	public ResponseEntity<List<Question>> getQuestionsByDifficultylevel(String difficultylevel) 
	{
		try 
		{
			return new ResponseEntity<>(questiondao.findBydifficultylevel(difficultylevel), HttpStatus.OK);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<String> addQuestion(Question question) 
	{
		try 
		{
			questiondao.save(question);
			return new ResponseEntity<>("success",HttpStatus.CREATED);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> deleteQuestionById(int id) 
	{
		try
		{
			questiondao.deleteById(id);
			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Failed", HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<String> updateQuestionById(Question question) 
	{
		try 
		{
			questiondao.save(question);
			return new ResponseEntity<>("Updated", HttpStatus.OK);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Failed", HttpStatus.NOT_FOUND);

	}


	public ResponseEntity<List<Integer>> getQuestionsforQuiz(String questionTitle, String difficultylevel) {
		
		List<Integer> questions = questiondao.findRandomQuestionsByQuestionTitle(questionTitle, difficultylevel);
		System.out.println(questions);
		
		return new ResponseEntity<>( questions, HttpStatus.OK);
	}


	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		
		List<QuestionWrapper> questionwrappers = new ArrayList<QuestionWrapper>();
		List<Question> questions = new ArrayList<Question>();
		
		for(Integer i : questionIds)
		{
			questions.add(questiondao.findById(i).get());
		}
		
		for(Question q : questions)
		{
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionwrappers.add(qw);
		}
		
		return new ResponseEntity<>(questionwrappers,HttpStatus.OK);
		
	}


	public ResponseEntity<Integer> getScore(List<Response> responses) {
		
		int score=0;
		
		for(Response r : responses)
		{
			Question q = questiondao.findById(r.getId()).get();
			
			if(q.getRightAnswer().equals(r.getResponse()));
			{
				System.out.println(q.getRightAnswer()+"&"+ r.getResponse());
				score++;
			}
			
		}
		
		return new ResponseEntity<>(score, HttpStatus.OK);
	}
	
		
}
