package com.quizapp.feign;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.quizapp.quizmodel.QuestionWrapper;
import com.quizapp.quizmodel.Response;



@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuestionsforQuiz(@RequestParam String questionTitle, @RequestParam String difficultylevel);
	
	@PostMapping("question/getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds );
	@PostMapping("question/getscore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
