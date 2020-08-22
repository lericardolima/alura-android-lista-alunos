package com.example.listadealunos.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listadealunos.R;
import com.example.listadealunos.dao.SingletonAlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alunos);

        ListView listViewAlunos = findViewById(R.id.activity_list_alunos);
        listViewAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SingletonAlunoDAO.getInstance().listar()));

    }
}
