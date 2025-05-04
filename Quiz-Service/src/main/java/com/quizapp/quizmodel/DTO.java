package com.quizapp.quizmodel;


public class DTO {

	private String quiztitle;
	private String questiontitle;
	private String difficultylevel;
	
	public String getDifficultylevel() {
		return difficultylevel;
	}
	public void setDifficultylevel(String difficultylevel) {
		this.difficultylevel = difficultylevel;
	}
	public String getQuiztitle() {
		return quiztitle;
	}
	public void setQuiztitle(String quiztitle) {
		this.quiztitle = quiztitle;
	}
	public String getQuestiontitle() {
		return questiontitle;
	}
	public void setQuestiontitle(String questiontitle) {
		this.questiontitle = questiontitle;
	}
	
	@Override
	public String toString() {
		return "DTO [quiztitle=" + quiztitle + ", questiontitle=" + questiontitle + ", difficultylevel="
				+ difficultylevel + "]";
	}
	public DTO(String quiztitle, String questiontitle, String difficultylevel) {
		super();
		this.quiztitle = quiztitle;
		this.questiontitle = questiontitle;
		this.difficultylevel = difficultylevel;
	}
	
	
	
	
}
