package com.example.leylandgo.Models;

public class QuestionModel {
    private String question,optionA,optionB,correctAnswer;
    public QuestionModel(String question, String optionA, String optionB,String correctAnswer){
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.correctAnswer = correctAnswer;
    }

    public QuestionModel(){

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
