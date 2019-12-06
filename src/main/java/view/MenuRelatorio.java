package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraAvisoCoordenacao;
import model.dto.AvisoCoordenacaoDTO;
import model.vo.UsuarioVO;

public class MenuRelatorio {

	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_RELATORIO_USUARIO = 1;
	private static final int OPCAO_MENU_RELATORIO_AVISO_ESTAGIO = 2;
	private static final int OPCAO_MENU_RELATORIO_AVISO_COORDENACAO = 3;
	private static final int OPCAO_MENU_RELATORIO_SAIR = 9;
	
	private static final int OPCAO_MENU_CONSULTAR_RELATORIO_USUARIO = 1;
	private static final int OPCAO_MENU_CONSULTAR_RELATORIO_AVISO_ESTAGIO = 2;
	private static final int OPCAO_MENU_CONSULTAR_RELATORIO_AVISO_COORDENACAO = 3;
	private static final int OPCAO_MENU_CONSULTAR_RELATORIO_SAIR = 9;
	
	private static final int ADMINISTRADOR = 1;

	public void apresentarMenuRelatorio(UsuarioVO usuarioVO) {
		int opcao = apresentarOpcoesMenu(usuarioVO.getIdTipoUsuario());
		while (opcao != OPCAO_MENU_RELATORIO_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_RELATORIO_USUARIO: {
					this.consultarRelatorioUsuario(usuarioVO);
					break;
				}
				case OPCAO_MENU_RELATORIO_AVISO_ESTAGIO: {
					this.consultarRelatorioAvisoEstagio();
					break;
				}
				case OPCAO_MENU_RELATORIO_AVISO_COORDENACAO: {
					this.consultarRelatorioAvisoCoordenacao(usuarioVO);
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			opcao = apresentarOpcoesMenu(usuarioVO.getIdTipoUsuario());
		}
		
	}

	private int apresentarOpcoesMenu(int idTipoUsuario) {
		System.out.println("\nSistema de Avisos \n-------- Menu Relatórios --------");
		System.out.println("\nOpções:");
		if(idTipoUsuario == ADMINISTRADOR) {
			System.out.println(OPCAO_MENU_CONSULTAR_RELATORIO_USUARIO + " - Consultar Relatório de Usuários");
		}
		System.out.println(OPCAO_MENU_CONSULTAR_RELATORIO_AVISO_ESTAGIO + " - Consultar Relatório de Avisos de Estágios");
		System.out.println(OPCAO_MENU_CONSULTAR_RELATORIO_AVISO_COORDENACAO + " - Consultar Relatório de Avisos da Coordenação");
		System.out.println(OPCAO_MENU_CONSULTAR_RELATORIO_SAIR + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void consultarRelatorioAvisoCoordenacao(UsuarioVO usuarioVO) {
		ControladoraAvisoCoordenacao controladoraAvisoCoordenacao = new ControladoraAvisoCoordenacao();
		ArrayList<AvisoCoordenacaoDTO> listaAvisoCoordenacaoDTO = controladoraAvisoCoordenacao.consultarRelatorioAvisosCoordenacaoController();
		System.out.print("\n--------- RESULTADO DO RELATÓRIO ---------");
		System.out.printf("\n%8s   %15s   %-50s   %-15s   %-15s  \n", "ID AVISO", "ID AVISO COORD.", "DESCRIÇÃO", "DATA CADASTRO", "DATA EXPIRAÇÃO");
		for (int i = 0; i < listaAvisoCoordenacaoDTO.size(); i++) {
			listaAvisoCoordenacaoDTO.get(i).imprimir();
		}
		
		
	}

	private void consultarRelatorioAvisoEstagio() {
		// TODO Auto-generated method stub
		
	}

	private void consultarRelatorioUsuario(UsuarioVO usuarioVO) {
		// TODO Auto-generated method stub
		
	}

}
