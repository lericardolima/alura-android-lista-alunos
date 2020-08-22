package com.example.listadealunos.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listadealunos.R;
import com.example.listadealunos.dao.AlunoDAO;
import com.example.listadealunos.dao.SingletonAlunoDAO;
import com.example.listadealunos.model.Aluno;

public class FormAlunoActivity extends AppCompatActivity {

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_form_aluno);

                final AlunoDAO alunoDAO = SingletonAlunoDAO.getInstance();

                final EditText inputNome = findViewById(R.id.activity_form_aluno_nome);
                final EditText inputTelefone = findViewById(R.id.activity_form_aluno_telefone);
                final EditText inputEmail = findViewById(R.id.activity_form_aluno_email);

                Button buttonSalvar = findViewById(R.id.activity_form_aluno_salvar);
                buttonSalvar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                final String nome = inputNome.getText().toString();
                                final String telefone = inputTelefone.getText().toString();
                                final String email = inputEmail.getText().toString();

                                Aluno aluno = new Aluno(nome, telefone, email);
                                alunoDAO.salvar(aluno);

                                startActivity(new Intent(FormAlunoActivity.this, ListaAlunosActivity.class));
                        }
                });
        }
}