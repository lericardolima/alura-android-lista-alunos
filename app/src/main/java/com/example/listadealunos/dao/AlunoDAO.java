package com.example.listadealunos.dao;

import com.example.listadealunos.model.Aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlunoDAO {

    private static int contadorIds = 1;

    private final List<Aluno> alunos = new ArrayList<>();

    protected AlunoDAO() {
    }

    public void salvar(Aluno aluno) {

        Aluno alunoEditado = null;
        for (Aluno alunoPersistido : alunos) {
            if (alunoPersistido.getId() == aluno.getId()) {
                alunoEditado = alunoPersistido;
            }
        }

        if (alunoEditado != null) {
            int posicaoAluno = alunos.indexOf(alunoEditado);
            alunos.set(posicaoAluno, aluno);

        } else {
            aluno.setId(contadorIds++);
            alunos.add(aluno);
        }

    }

    public List<Aluno> listar() {
        return Collections.unmodifiableList(this.alunos);
    }

}
