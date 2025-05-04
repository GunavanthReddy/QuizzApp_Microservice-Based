package com.quizapp.quizcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.quizmodel.DTO;
import com.quizapp.quizmodel.QuestionWrapper;
import com.quizapp.quizmodel.Response;
import com.quizapp.quizservice.QuizService;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizservice;
	
	
	@PostMapping ("create")
	public ResponseEntity<String> createQuiz(@RequestBody DTO dto)
	{
		return quizservice.createQuiz(dto.getQuiztitle(),dto.getQuestiontitle(), dto.getDifficultylevel());
	}
	
	@GetMapping("getquiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizBasedOnId(@PathVariable Integer id)
	{
		return quizservice.getQuizBasedOnId(id);
	}
	
	@PostMapping("submit")
	public ResponseEntity<Integer> sumbitQuiz(@RequestBody List<Response> responses)
	{
		return quizservice.submitQuiz(responses);
	}
	
}
