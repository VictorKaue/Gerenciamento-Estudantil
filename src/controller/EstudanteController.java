package controller;

import java.util.List;
import Model.Estudante;
import dao.EstudanteDao;



public class EstudanteController {
	private EstudanteDao dao;
	
	public EstudanteController() {
		this.dao = new EstudanteDao();
	}
	
	public boolean salvar(Estudante estudante) {
		if(estudante.getMatricula()estudante == null || estudante.getMatricula().isEmpty()) {
			return dao.inserir(estudante);
		} else {
			return dao.atualizar(estudante);
		}
	}
	
	public boolean deletar() {
		return dao.deletar();
	}
	
	public List<EstudanteDao> listar() {
		return dao.listar;
	}
}
