package model.bo;

import java.util.ArrayList;

import model.dao.AvisoEstagioDAO;
import model.dto.AvisoEstagioDTO;
import model.vo.AvisoEstagioVO;

public class AvisoEstagioLivreBO {
	public void cadastrarAvisoEstagiooBO(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		if(avisoEstagioDAO.existeRegistroPorIdAvisoEstagioDAO(avisoEstagioVO)){
			System.out.println("\nAviso do Estagio já Cadastrado");
		} else {
			int resultado = avisoEstagioDAO.cadastrarAvisoEstagioDAO(avisoEstagioVO);
			if(resultado == 1){
				System.out.println("\nAviso do estagio cadastrado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar o Aviso do Estagio.");
			}
		}		
	}

	public void atualizarAvisoEstagioBO(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		if(avisoEstagioDAO.existeRegistroPorIdAvisoEstagioDAO(avisoEstagioVO)){
			int resultado = avisoEstagioDAO.atualizarAvisoEstagioDAO(avisoEstagioVO);
			if(resultado == 1){
				System.out.println("\nAviso da Estagio atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Aviso da Estagio.");
			}
		} else {
			System.out.println("\nAviso da Estagio ainda não foi cadastrado.");
		}
	}

	public void excluirAvisoEstagioBO(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		if(avisoEstagioDAO.existeRegistroPorIdAvisoEstagioDAO(avisoEstagioVO)){
			int resultado = avisoEstagioDAO.excluirAvisoEstagioDAO(avisoEstagioVO);
			if(resultado == 1){
				System.out.println("\nAviso do Estagio excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Aviso do Estagio.");
			}
		} else {
			System.out.println("\nAviso do Estagio não existe na base da dados.");
		}
	}


	public AvisoEstagioVO consultarAvisoEstagioLivreBO(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		AvisoEstagioVO avisoEstagio = avisoEstagioDAO.consultarAvisoEstagioDAO(avisoEstagioVO);
		if(avisoEstagio == null){
			System.out.println("\nAviso do Estagio não Localizado.");
		}
		return avisoEstagio;
	}

	public ArrayList<AvisoEstagioVO> consultarTodosAvisosEstagioLivreBO() {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		ArrayList<AvisoEstagioVO> avisosEstagioVO = avisoEstagioDAO.consultarTodosAvisoEstagioDAO();
		if(avisosEstagioVO.isEmpty()){
			System.out.println("\nLista de Avisos do Estagio está vazia.");
		}
		return avisosEstagioVO;
	}

	public ArrayList<AvisoEstagioDTO> consultarRelatorioAvisosEstagioBO() {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		ArrayList<AvisoEstagioDTO> avisoEstagioDTO = avisoEstagioDAO.consultarRelatorioAvisoEstagioDAO();
		if(avisoEstagioDTO.isEmpty()){
			System.out.println("\nLista de Avisos de Estágio está vazia.");
		}
		return avisoEstagioDTO;
	}
}
