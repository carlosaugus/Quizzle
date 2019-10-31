package com.appuni9.quizzle.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.appuni9.quizzle.Model.Questoes;
import com.appuni9.quizzle.Model.User;
import com.appuni9.quizzle.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    FirebaseDatabase database;
    DatabaseReference questoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        int categoriaId = (int)getIntent().getSerializableExtra("categoriaId") + 1;

        database = FirebaseDatabase.getInstance();
        questoes = database.getReference("Questoes");

        try{
            questoes.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        Questoes qst = dataSnapshot.getValue(Questoes.class);
                        Toast.makeText(GameActivity.this, "Teste: " + qst.getQuestao(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GameActivity.this, "Não", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e){
            Toast.makeText(GameActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
