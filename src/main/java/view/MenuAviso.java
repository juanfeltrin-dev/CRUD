package view;

import java.util.Scanner;

import model.vo.UsuarioVO;

public class MenuAviso {
	
	Scanner teclado = new Scanner(System.in);
	
    private static final int OPCAO_MENU_COORDENACAO  = 1;
    private static final int OPCAO_MENU_ESTAGIO = 2;
    private static final int OPCAO_MENU_CURSO_LIVRE = 3;
    private static final int OPCAO_MENU_SAIR = 9;

	public void apresentarMenuAviso(UsuarioVO usuarioVO) {
		 int opcao = this.apresentarOpcoesMenu();
		    while(opcao != 9) {
		        switch(opcao) {
		        case OPCAO_MENU_COORDENACAO: {
		            MenuCoordenacao menuCoordenacao = new MenuCoordenacao();
		            menuCoordenacao.apresentarMenuCoordenacao(usuarioVO);
		            break;
		        }
		        case OPCAO_MENU_ESTAGIO: {
		            MenuEstagio menuEstagio = new MenuEstagio();
		            menuEstagio.apresentarMenuEstagio(usuarioVO);
		            break;
		        }
		        case OPCAO_MENU_CURSO_LIVRE: {
		            MenuCursoLivre menuCursoLivre = new MenuCursoLivre();
		            menuCursoLivre.apresentarMenuCursoLivre(usuarioVO);
		            break;
		        }
		        default: {
		            System.out.println("\nopção invalida.");
		        }
		    }
		    opcao = this.apresentarOpcoesMenu();
		}
	}
	
    private int apresentarOpcoesMenu() {
        System.out.println("\nSistema de Aviso - Menu Principal");
        System.out.println("\nOpções");
        System.out.println( OPCAO_MENU_COORDENACAO + " - Menu de Coordenação");
        System.out.println(OPCAO_MENU_ESTAGIO + " - Menu de Estágios");
        System.out.println( OPCAO_MENU_CURSO_LIVRE + " - Menu de Cursos Livres");
        System.out.println(OPCAO_MENU_SAIR +" - Sair");
        
        System.out.print("Digite uma opção: ");
        
        return Integer.parseInt(teclado.nextLine());
                
    }

}
