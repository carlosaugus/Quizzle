package com.example.quizzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //teste
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirLogin(View view){
        Intent it = new Intent(this, LoginActivity.class);
        startActivity(it);
    }

    //public void abrirConvidado(View view){
    //    Intent it = new Intent(this, ConvidadoActivity.class);
    //    startActivity(it);
    //}

    public void abrirCadastro(View view){
        Intent it = new Intent(this, CadastroActivity.class);
        startActivity(it);
    }
}
