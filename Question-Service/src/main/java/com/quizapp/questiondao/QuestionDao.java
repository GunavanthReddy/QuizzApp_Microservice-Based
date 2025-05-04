package com.quizapp.questiondao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizapp.questionmodel.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	List<Question> findBydifficultylevel(String difficultylevel);
	
	@Query(value = "SELECT id FROM question q WHERE q.question_title = :questiontitle AND q.difficultylevel = :difficultylevel ORDER BY RAND()", nativeQuery = true)
	List<Integer> findRandomQuestionsByQuestionTitle(String questiontitle, String difficultylevel);

}
