package com.quizapp.quizdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizapp.quizmodel.Quiz;



@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
