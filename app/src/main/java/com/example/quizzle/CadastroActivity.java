package com.example.quizzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;

public class CadastroActivity extends AppCompatActivity {

    private Spinner opcSexo;
    private ImageView img_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        this.opcSexo = findViewById(R.id.opcSexo);
        this.img_avatar = findViewById(R.id.img_avatar);
    }

    public void Validar_Sexo(){

        int sexo = this.opcSexo.getSelectedItemPosition();

        if (sexo == 0) {
            this.img_avatar.setImageResource(R.drawable.avatar1);
        }
        else if (sexo == 1){
            this.img_avatar.setImageResource(R.drawable.avatar2);
        }
    }
}
