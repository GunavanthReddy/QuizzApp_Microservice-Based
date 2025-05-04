package com.quizapp.questioncontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.questionmodel.Question;
import com.quizapp.questionmodel.QuestionWrapper;
import com.quizapp.questionmodel.Response;
import com.quizapp.questionservice.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	@Autowired
	Environment environment;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestion()
	{
		return questionService.getAllQuestions();
	}
	
	@GetMapping("difficultylevel/{difficultylevel}")
	public ResponseEntity<List<Question>> getQuestionsByDifficultylevel(@PathVariable String  difficultylevel)
	{
		return questionService.getQuestionsByDifficultylevel(difficultylevel);
	}
	
	@PostMapping("addquestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{	
		return questionService.addQuestion(question);
	}
	
	@DeleteMapping("delete/{id}")
	public  ResponseEntity<String>  deleteQuestionById(@PathVariable int id)
	{
		return questionService.deleteQuestionById(id);
	}
	
	@PutMapping("update")
	public  ResponseEntity<String>  updateQuestionById(@RequestBody Question question)
	{
		return questionService.updateQuestionById(question); 
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsforQuiz(@RequestParam String questionTitle, @RequestParam String difficultylevel)
	{
		return questionService.getQuestionsforQuiz(questionTitle, difficultylevel);
	}
	
	@PostMapping("getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds )
	{
		System.out.println(environment.getProperty("local.server.port"));
		return questionService.getQuestionsFromId(questionIds);
	}
	@PostMapping("getscore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
	{
		return questionService.getScore(responses);
	}

/*	@GetMapping("getquestion/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable int id)
	{
		return questionService.getQuestionById(id);
	}*/

}
