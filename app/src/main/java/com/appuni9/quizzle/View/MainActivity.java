package com.appuni9.quizzle.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.appuni9.quizzle.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
