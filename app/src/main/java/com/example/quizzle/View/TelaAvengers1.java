package com.example.quizzle.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizzle.Model.Methods;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.example.quizzle.R;

public class TelaAvengers1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_avengers1);
        Button button  = findViewById(R.id.btnAnswerA);
        button.setOnClickListener(btnAnswerA);
        Button button2 = findViewById(R.id.btnAnswerB);
        button2.setOnClickListener(btnAnswerB);
        Button button3 = findViewById(R.id.btnAnswerC);
        button2.setOnClickListener(btnAnswerC);
        Button button4 = findViewById(R.id.btnAnswerD);
        button2.setOnClickListener(btnAnswerD);
    }
    private View.OnClickListener btnAnswerA = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Methods.setRightAnswer("A");
            try{
                Methods.checkAnswer("D.Capitão America");
            }catch (InterruptedException ex){
            }
        }
    };

    private View.OnClickListener btnAnswerB = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Methods.setRightAnswer("B");
            try{
                Methods.checkAnswer("D.Capitão America");
            }catch (InterruptedException ex){
            }
        }
    };

    private View.OnClickListener btnAnswerC = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Methods.setRightAnswer("C");
            try{
                Methods.checkAnswer("D.Capitão America");
            }catch (InterruptedException ex){
            }
        }
    };

    private View.OnClickListener btnAnswerD = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Methods.setRightAnswer("D");
            try{
                Methods.checkAnswer("D.Capitão America");
            }catch (InterruptedException ex){
            }
        }
    };
}
