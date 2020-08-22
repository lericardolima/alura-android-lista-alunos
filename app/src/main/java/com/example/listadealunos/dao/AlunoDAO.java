package com.example.listadealunos.dao;

import com.example.listadealunos.model.Aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlunoDAO {

    private final List<Aluno> alunos = new ArrayList<>();

    protected AlunoDAO() {
    }

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listar() {
        return Collections.unmodifiableList(this.alunos);
    }

}
