package controller;

import java.util.List;

import Model.Estudante;
import Model.Professor;
import dao.Professor;

public class ProfessorController {
	private ProfessorDao dao;
	
	public ProfessorController() {
		this.dao = new ProfessorDao();
	}
	
	public boolean salvar(Professor professor) {
		if(professor.getMatricula() == null || professor.getMatricula().isEmpty()) {
			return dao.inserir(professor);
		} else {
			return dao.atualizar(professor);
		}
	}
	
	public boolean deletar() {
		return dao.deletar();
	}
	
	public List<ProfessorDao> listar() {
		return dao.listar;
	}
}

