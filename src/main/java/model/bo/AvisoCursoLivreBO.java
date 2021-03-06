package model.bo;

import java.util.ArrayList;

import model.dao.AvisoCursoLivreDAO;
import model.vo.AvisoCursoLivreVO;

public class AvisoCursoLivreBO {

	public void cadastrarAvisoCursoLivreBO(AvisoCursoLivreVO avisoCursoLivreVO) {
		AvisoCursoLivreDAO avisoCursoLivreDAO = new AvisoCursoLivreDAO();
		if(avisoCursoLivreDAO.existeRegistroAvisoCursoLivreDAO(avisoCursoLivreVO)){
			System.out.println("\nAviso de Curso Livre já Cadastrado");
		} else {
			int resultado = avisoCursoLivreDAO.cadastrarAvisoCursoLivreDAO(avisoCursoLivreVO);
			if(resultado == 1){
				System.out.println("\nAviso de Curso Livre cadastrado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar o Aviso de Curso Livre.");
			}
		}
	}

	public void excluirAvisoCursoLivreBO(AvisoCursoLivreVO avisoCursoLivreVO) {
		AvisoCursoLivreDAO avisoCursoLivreDAO = new AvisoCursoLivreDAO();
		if(avisoCursoLivreDAO.existeRegistroPorIdAvisoCursoLivreDAO(avisoCursoLivreVO)){
			int resultado = avisoCursoLivreDAO.excluirAvisoCursoLivreDAO(avisoCursoLivreVO);
			if(resultado == 1){
				System.out.println("\nAviso da Coordenação excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Aviso da Coordenação.");
			}
		} else {
			System.out.println("\nAviso da Coordenação não existe na base da dados.");
		}
	}

	public void atualizarAvisoCursoLivreBO(AvisoCursoLivreVO avisoCursoLivreVO) {
		AvisoCursoLivreDAO avisoCursoLivreDAO = new AvisoCursoLivreDAO();
		if(avisoCursoLivreDAO.existeRegistroPorIdAvisoCursoLivreDAO(avisoCursoLivreVO)){
			int resultado = avisoCursoLivreDAO.atualizarAvisoCursoLivreDAO(avisoCursoLivreVO);
			if(resultado == 1){
				System.out.println("\nAviso da Coordenação atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Aviso da Coordenação.");
			}
		} else {
			System.out.println("\nAviso da Coordenação ainda não foi cadastrado.");
		}
	}

	public ArrayList<AvisoCursoLivreVO> consultarTodosAvisosCursoLivreBO() {
		AvisoCursoLivreDAO avisoCursoLivreDAO = new AvisoCursoLivreDAO();
		ArrayList<AvisoCursoLivreVO> avisosCursoLivreVO = avisoCursoLivreDAO.consultarTodosAvisoCursoLivreDAO();
		if(avisosCursoLivreVO.isEmpty()){
			System.out.println("\nLista de Avisos da Coordenação está vazia.");
		}
		return avisosCursoLivreVO;
	}

	public AvisoCursoLivreVO consultarAvisoCursoLivreBO(AvisoCursoLivreVO avisoCursoLivreVO) {
		AvisoCursoLivreDAO avisoCursoLivreDAO = new AvisoCursoLivreDAO();
		AvisoCursoLivreVO avisoCursoLivre = avisoCursoLivreDAO.consultarAvisoCursoLivreDAO(avisoCursoLivreVO);
		if(avisoCursoLivre == null){
			System.out.println("\nAviso da Coordenação não Localizado.");
		}
		return avisoCursoLivre;
	}

}
