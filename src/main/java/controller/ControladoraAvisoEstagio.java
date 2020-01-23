package controller;

import java.util.ArrayList;

import model.bo.AvisoEstagioLivreBO;
import model.dto.AvisoEstagioDTO;
import model.vo.AvisoEstagioVO;

public class ControladoraAvisoEstagio {
	public void cadastrarAvisoEstagioLivreController(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioLivreBO avisoEstagioLivreBO = new AvisoEstagioLivreBO();
		avisoEstagioLivreBO.cadastrarAvisoEstagiooBO(avisoEstagioVO);
	}

	public void excluirAvisoEstagioLivreController(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioLivreBO avisoEstagioLivreBO = new AvisoEstagioLivreBO();
		avisoEstagioLivreBO.excluirAvisoEstagioBO(avisoEstagioVO);
	}

	public void atualizarAvisoEstagioLivreController(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioLivreBO avisoEstagioLivreBO = new AvisoEstagioLivreBO();
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
