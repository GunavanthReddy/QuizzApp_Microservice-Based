package com.quizapp.quizmodel;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String questionTitle;
	@ElementCollection
	private List<Integer> questionsIds; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public List<Integer> getQuestionsIds() {
		return questionsIds;
	}
	public void setQuestionsIds(List<Integer> questionsIds) {
		this.questionsIds = questionsIds;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", questionTitle=" + questionTitle + ", questionsIds=" + questionsIds + "]";
	}
	

	
	
}
