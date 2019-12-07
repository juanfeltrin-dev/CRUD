package controller;

import java.util.ArrayList;

import model.bo.AvisoCoordenacaoBO;
import model.bo.AvisoEstagioLivreBO;
import model.dto.AvisoEstagioDTO;
import model.vo.AvisoEstagioVO;

public class ControladoraAvisoEstagio {
	public void cadastrarAvisoEstagioLivreController(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioVO avisoEstagioLivreBO = new AvisoEstagioVO();
		avisoEstagioLivreBO.cadastrarAvisoEstagioLivreBO(avisoEstagioVO);
	}

	public void excluirAvisoEstagioLivreController(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioVO avisoEstagioLivreBO = new AvisoEstagioVO();
		avisoEstagioLivreBO.excluirAvisoEstagioLivreBO(avisoEstagioVO);
	}

	public void atualizarAvisoEstagioLivreController(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioVO avisoEstagioLivreBO = new AvisoEstagioVO();
		avisoEstagioLivreBO.atualizarAvisoEstagioBO(avisoEstagioVO);
	}

	public ArrayList<AvisoEstagioVO> consultarTodosAvisosEstagioLivreController() {
		AvisoEstagioLivreBO avisoEstagioLivreBO = new AvisoEstagioLivreBO();
		return avisoEstagioLivreBO.consultarTodosAvisosEstagioLivreBO();
	}

	public AvisoEstagioVO consultarAvisoEstagioLivreController(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioLivreBO avisoEstagioLivreBO = new AvisoEstagioLivreBO();
		return avisoEstagioLivreBO.consultarAvisoEstagioLivreBO(avisoEstagioVO);
	}

	public ArrayList<AvisoEstagioDTO> consultarRelatorioAvisosEstagioController() {
		AvisoEstagioLivreBO avisoEstagioLivreBO = new AvisoEstagioLivreBO();
		return avisoEstagioLivreBO.consultarRelatorioAvisosEstagioBO();
	}
}
