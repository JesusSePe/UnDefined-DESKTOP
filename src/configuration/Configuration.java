package configuration;

import java.util.List;

public class Configuration {
	
	private String language;
	private List<String> questionType;
	private int timeout;
	private int maxQuestion;
	private String pathXML;
	public String getLanguage() {
		return language;
	}
	
	public Configuration(String language, List<String> questionType, int timeout, int maxQuestion, String pathXML) {
		super();
		this.language = language;
		this.questionType = questionType;
		this.timeout = timeout;
		this.maxQuestion = maxQuestion;
		this.pathXML = pathXML;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public List<String> getQuestionType() {
		return questionType;
	}
	
	public void setQuestionType(List<String> questionType) {
		this.questionType = questionType;
	}
	
	public int getTimeout() {
		return timeout;
	}
	
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	public int getMaxQuestion() {
		return maxQuestion;
	}
	
	public void setMaxQuestion(int maxQuestion) {
		this.maxQuestion = maxQuestion;
	}
	
	public String getPathXML() {
		return pathXML;
	}
	
	public void setPathXML(String pathXML) {
		this.pathXML = pathXML;
	}

	@Override
	public String toString() {
		return "Configuration [\n\tLanguage = " + language + ",\n\tQuestion Type = " + questionType + ",\n\tTimeout = " + timeout
				+ ",\n\tMax of questions = " + maxQuestion + ",\n\tPath XML = " + pathXML + "\n]";
	}

}
