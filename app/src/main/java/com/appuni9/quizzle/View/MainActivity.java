package com.appuni9.quizzle.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.appuni9.quizzle.R;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mp.stop();
        mp = MediaPlayer.create(this, R.raw.djmarky);
        mp.start();
        mp.setLooping(true);
    }

    public void btnMudo(View view){
        mp.stop();
    }

//    public void onStop() {
//
//        super.onStop();
//
//        if (mp.isPlaying()) {
//            mp.stop();
//        }
//        mp.release();
//    }

    public void abrirLogin(View view){
        Intent it = new Intent(this, LoginActivity.class);
        startActivity(it);
    }

    public void abrirConvidado(View view){
        Intent it = new Intent(this, HomeActivity.class);
        startActivity(it);
    }

    public void abrirCadastro(View view){
        Intent it = new Intent(this, CadastroActivity.class);
        startActivity(it);
    }
}
