package com.quizapp.questionmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class Response {

	@Id
	int id;
	String response;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "Response [id=" + id + ", response=" + response + "]";
	}
	public Response() {
		super();
	}
	public Response(int id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
}
