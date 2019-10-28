package com.appuni9.quizzle.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.appuni9.quizzle.Model.Sexo;
import com.appuni9.quizzle.Model.User;
import com.appuni9.quizzle.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CadastroActivity extends AppCompatActivity {
    EditText edtUser, edtEmail, edtPassword, edtPasswordConfirm;
    Spinner opcSexo;

    Button btnCadastrar;

    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Firebase
        database = FirebaseDatabase.getInstance();
        users = database.getReference();

        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        edtPasswordConfirm = (EditText)findViewById(R.id.edtPasswordConfirm);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        opcSexo = (Spinner)findViewById(R.id.opcSexo);

        btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

    }

    public void cadastrar(View view) throws Exception {
        try{
            edtUser.setError(null);
            edtPassword.setError(null);
            edtPasswordConfirm.setError(null);
            edtEmail.setError(null);

            boolean cancel = false;

            final User user = new User();
            user.setUserName(edtUser.getText().toString());
            user.setEmail(edtEmail.getText().toString());

            if (TextUtils.isEmpty(edtPassword.getText().toString())){
                edtPassword.setError(getString(R.string.error_field_required));
                view = edtPassword;
                cancel = true;
            } else if (!edtPassword.getText().toString().equals(edtPasswordConfirm.getText().toString())){
                edtPassword.setError(getString(R.string.error_invalid_password));
                view = edtPassword;
                cancel = true;
            } else {
                user.setPassword(edtPassword.getText().toString());
            }

            if (TextUtils.isEmpty(edtEmail.getText().toString())) {
                edtEmail.setError(getString(R.string.error_field_required));
                view = edtEmail;
                cancel = true;
            }

            if(opcSexo.getSelectedItemPosition() == 0)
                user.setSexo(Sexo.FEMININO);
            else
                user.setSexo(Sexo.MASCULINO);

            if (cancel) {
                view.requestFocus();
            } else {
                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(user.getUserName()).exists()){
                            Toast.makeText(CadastroActivity.this, "Nome de usuário já existent", Toast.LENGTH_SHORT).show();
                        } else {
                            users.child(user.getUserName()).setValue(user);
                            Toast.makeText(CadastroActivity.this, "Usuário registrado com sucesso", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        } catch (Exception e){
            Toast.makeText(CadastroActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
