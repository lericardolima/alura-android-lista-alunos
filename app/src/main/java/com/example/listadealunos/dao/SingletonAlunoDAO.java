package com.example.listadealunos.dao;

public abstract class SingletonAlunoDAO {

    private static final AlunoDAO alunoDao = new AlunoDAO();

    public static AlunoDAO getInstance() {
        return alunoDao;
    }

}
