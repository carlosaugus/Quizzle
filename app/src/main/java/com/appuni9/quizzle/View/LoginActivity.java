package com.appuni9.quizzle.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appuni9.quizzle.Model.User;
import com.appuni9.quizzle.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    EditText edtUser, edtPassword;

    Button btnLogin;

    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Firebase
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Usuarios");

        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPassword = (EditText)findViewById(R.id.edtPassword);

        btnLogin = (Button)findViewById(R.id.btnLogin);
    }

    public void login(View view) {
        try{
            final String user = edtUser.getText().toString();
            final String password = edtPassword.getText().toString();

            users.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child(user).exists()){
                        if (!user.isEmpty()){
                            User login = dataSnapshot.child(user).getValue(User.class);
                            if(login.getPassword().equals(password)) {
                                Intent homeActivity = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(homeActivity);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Usuário e/ou senha incorreto(s)", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "Por favor, digite o usuário!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Usuário inexistente!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e){
            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
