package com.example.quizzle.Model;

public class Methods {
    public static String rightAnswer;

    public static String getRightAnswer() {
        return rightAnswer;
    }

    public static void setRightAnswer(String rightAnswer) {
        Methods.rightAnswer = rightAnswer;
    }

    public static void checkAnswer(String correctAnswer) throws InterruptedException{
        if(getRightAnswer().equals(correctAnswer.substring(0,1))){
            //RAviso a1 = new RAviso();
            // a1.setVisible(true);
        }
        else{
            //WAviso w1 = new WAviso();
            //w1.setVisible(true);
        }
    }
