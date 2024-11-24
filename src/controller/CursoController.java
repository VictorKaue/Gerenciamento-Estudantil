package controller;

import java.util.List;

public class CursoController {
    private CursoDao dao;

    public CursoController() {
        this.dao = new CursoDao();
    }

    public boolean salvar(Curso curso) {
        if (curso.getId() == 0) {  
            return dao.inserir(curso); 
        } else {
            return dao.atualizar(curso);  
        }
    }


    public boolean deletar(int id) {
        return dao.deletar(id);  
    }

    
    public List<Curso> listar() {
        return dao.listar();  
    }
}
