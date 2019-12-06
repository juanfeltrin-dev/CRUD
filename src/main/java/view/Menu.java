package view;

import java.util.Scanner;

import model.vo.UsuarioVO;

public class Menu {

	Scanner teclado = new Scanner(System.in);
	private static final int OPCAO_MENU_AVISO = 1;
	private static final int OPCAO_MENU_RELATORIO = 2;
	private static final int OPCAO_MENU_USUARIO = 3;
	private static final int OPCAO_MENU_SAIR = 9;

	private static final int ADMINISTRADOR = 1;
	private static final int COORDENADOR = 2;
	private static final int ALUNO = 3;
	private static final int SECRETARIA = 4;
	
	public void apresentarMenu(UsuarioVO usuarioVO) {
		int opcao = this.apresentarOpcoesMenu(usuarioVO.getIdTipoUsuario());
		while(opcao != OPCAO_MENU_SAIR) {
			switch(opcao) {
				case 1: {
					MenuAviso menuAviso = new MenuAviso();
					menuAviso.apresentarMenuAviso(usuarioVO);
					break;
				}
				case 2: {
					MenuRelatorio menuRelatorio = new MenuRelatorio();
					menuRelatorio.apresentarMenuRelatorio();
					break;
				}
				case 3: {
					MenuUsuario menuUsuario = new MenuUsuario();
					menuUsuario.apresentarMenuUsuario();
					break;
				}
				default: {
					System.out.println("\nOpção inválida!");
				}
			}
			opcao = this.apresentarOpcoesMenu(usuarioVO.getIdTipoUsuario());
		}
	}

	private int apresentarOpcoesMenu(int tipoUsuario) {
		System.out.println("\nSistema de Aviso - Menu Principal");
		System.out.println("\nOpções");
		System.out.println(OPCAO_MENU_AVISO + " - Menu de Avisos");
		if(tipoUsuario != ALUNO) {
			System.out.println(OPCAO_MENU_RELATORIO + " - Menu de Relatórios");
		}
		if(tipoUsuario == ADMINISTRADOR || tipoUsuario == COORDENADOR) {
			System.out.println(OPCAO_MENU_USUARIO + " - Menu de Usuários");
		}
		System.out.println(OPCAO_MENU_SAIR + " - Sair");
		
		System.out.print("Digite uma opção: ");
		
		return Integer.parseInt(teclado.nextLine());
				
	}

}
