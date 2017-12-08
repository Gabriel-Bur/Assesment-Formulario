package com.example.gabrielbur.assesment_formulario;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    EditText nome;
    EditText email;
    EditText senha;
    EditText confirmarSenha;
    EditText cpf;
    Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        init();
    }

    private void init() {
        nome = (EditText) findViewById(R.id.Nome);
        email = (EditText) findViewById(R.id.Email);
        senha = (EditText) findViewById(R.id.Senha);
        confirmarSenha = (EditText) findViewById(R.id.Senha2);
        cpf = (EditText) findViewById(R.id.Cpf);
        cadastrar = (Button) findViewById(R.id.Cadastro);


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), senha.getText().toString())
                        .addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Tente novamente",Toast.LENGTH_LONG).show();
                                }else {
                                    Toast.makeText(getApplicationContext(),"Cadastro Efetuado",Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(),Login.class));
                                }

                            }
                        });
            }
        });
    }
}
