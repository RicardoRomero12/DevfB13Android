package com.example.quizz.models;

/**
 * Created by Richy on 14/02/2017.
 */

public class Questions {

    private String title;

    private int answer;

    public Questions(String title, int answer){

        this.title = title;
        this.answer = answer;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }


}
