package com.appuni9.quizzle.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.appuni9.quizzle.R;

public class GameActivity extends AppCompatActivity {

    TextView resposta1;
    TextView resposta2;
    TextView resposta3;
    TextView resposta4;

    TextView pergunta;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.pergunta = findViewById(R.id.pergunta);

        this.resposta1 = findViewById(R.id.resposta1);
        this.resposta2 = findViewById(R.id.Resposta2);
        this.resposta3 = findViewById(R.id.Resposta3);
        this.resposta4 = findViewById(R.id.Resposta4);

        this.btn1 = findViewById(R.id.btn_res_1);
        this.btn2 = findViewById(R.id.Btn_Res_2);
        this.btn3 = findViewById(R.id.Btn_Res_3);
        this.btn4 = findViewById(R.id.Btn_Res_4);

    }
}
