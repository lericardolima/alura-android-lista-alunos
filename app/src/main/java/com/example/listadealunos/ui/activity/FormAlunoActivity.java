package com.example.listadealunos.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listadealunos.R;
import com.example.listadealunos.dao.AlunoDAO;
import com.example.listadealunos.dao.SingletonAlunoDAO;
import com.example.listadealunos.model.Aluno;
import com.example.listadealunos.model.constants.ConstantsExtra;

public class FormAlunoActivity extends AppCompatActivity {

    private Aluno aluno;

    private EditText inputNome;
    private EditText inputTelefone;
    private EditText inputEmail;
    private Button buttonSalvar;

    private AlunoDAO alunoDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_aluno);

        carregaAluno();
        inicializarCampos();
        configurarBotao();
    }

    private void carregaAluno() {
        if (getIntent().hasExtra(ConstantsExtra.EXTRA_ALUNO)) {
            aluno = (Aluno) getIntent().getSerializableExtra(ConstantsExtra.EXTRA_ALUNO);
        } else {
            aluno = new Aluno();
        }
    }

    private void configurarBotao() {
        buttonSalvar = findViewById(R.id.activity_form_aluno_salvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aluno.setNome(inputNome.getText().toString());
                aluno.setTelefone(inputTelefone.getText().toString());
                aluno.setEmail(inputEmail.getText().toString());
                alunoDAO.salvar(aluno);

                finish();
            }
        });
    }

    private void inicializarCampos() {
        inputNome = findViewById(R.id.activity_form_aluno_nome);
        inputTelefone = findViewById(R.id.activity_form_aluno_telefone);
        inputEmail = findViewById(R.id.activity_form_aluno_email);

        inputNome.setText(aluno.getNome());
        inputTelefone.setText(aluno.getTelefone());
        inputEmail.setText(aluno.getEmail());

        alunoDAO = SingletonAlunoDAO.getInstance();
    }
}