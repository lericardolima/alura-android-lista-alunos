package com.example.listadealunos.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listadealunos.R;
import com.example.listadealunos.dao.SingletonAlunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alunos);

        FloatingActionButton buttonCriar = findViewById(R.id.activity_list_alunos_criar);
        buttonCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAlunosActivity.this, FormAlunoActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listViewAlunos = findViewById(R.id.activity_list_alunos);
        listViewAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SingletonAlunoDAO.getInstance().listar()));
        listViewAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("POSICAO_ALUNO", "onItemClick: " + position);
            }
        });
    }
}
