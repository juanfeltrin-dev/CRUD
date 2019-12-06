package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraAvisoCursoLivre;
import model.vo.AvisoCursoLivreVO;
import model.vo.UsuarioVO;

public class MenuCursoLivre {

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_MENU_CONSULTAR_AVISO_CURSO_LIVRE = 1;
	private static final int OPCAO_MENU_CADASTRAR_AVISO_CURSO_LIVRE = 2;
	private static final int OPCAO_MENU_ATUALIZAR_AVISO_CURSO_LIVRE = 3;
	private static final int OPCAO_MENU_EXCLUIR_AVISO_CURSO_LIVRE = 4;
	private static final int OPCAO_MENU_AVISO_CURSO_LIVRE_SAIR = 9;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_AVISOS_CURSO_LIVRE = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_AVISO_CURSO_LIVRE = 2;
	private static final int OPCAO_MENU_CONSULTAR_AVISO_CURSO_LIVRE_SAIR = 9;
	
	private static final int ADMINISTRADOR = 1;
	private static final int COORDENADOR = 2;
	private static final int SECRETARIA = 3;
	
	public void apresentarMenuCursoLivre(UsuarioVO usuarioVO) {
		int opcao = this.apresentarOpcoesMenu(usuarioVO.getIdTipoUsuario());
		while (opcao != OPCAO_MENU_AVISO_CURSO_LIVRE_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CADASTRAR_AVISO_CURSO_LIVRE: {
					this.cadastrarAvisoCursoLivre(usuarioVO);
					break;
				}
				case OPCAO_MENU_CONSULTAR_AVISO_CURSO_LIVRE: {
					this.consultarAvisoCursoLivre();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_AVISO_CURSO_LIVRE: {
					this.atualizarAvisoCursoLivre(usuarioVO);
					break;
				}
				case OPCAO_MENU_EXCLUIR_AVISO_CURSO_LIVRE: {
					this.excluirAvisoCursoLivre();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			opcao = this.apresentarOpcoesMenu(usuarioVO.getIdTipoUsuario());
		}
	}

	private int apresentarOpcoesMenu(int idTipoUsuario) {
		System.out.println("\nSistema de Avisos \n-------- Menu Avisos de Cursos Livres --------");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CONSULTAR_AVISO_CURSO_LIVRE + " - Consultar Avisos de Cursos Livres");
		if(idTipoUsuario == ADMINISTRADOR || idTipoUsuario == COORDENADOR || idTipoUsuario == SECRETARIA) {
			System.out.println(OPCAO_MENU_CADASTRAR_AVISO_CURSO_LIVRE + " - Cadastrar Avisos de Cursos Livres");
			System.out.println(OPCAO_MENU_ATUALIZAR_AVISO_CURSO_LIVRE + " - Atualizar Avisos de Cursos Livres");
			System.out.println(OPCAO_MENU_EXCLUIR_AVISO_CURSO_LIVRE + " - Excluir Avisos de Cursos Livres");
		}
		System.out.println(OPCAO_MENU_AVISO_CURSO_LIVRE_SAIR + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarAvisoCursoLivre(UsuarioVO usuarioVO) {
		AvisoCursoLivreVO avisoCursoLivreVO = new AvisoCursoLivreVO();
		avisoCursoLivreVO.setIdUsuario(usuarioVO.getIdUsuario());
		System.out.print("\nDigite o Aviso da Coordenação: ");
		avisoCursoLivreVO.setNome(teclado.nextLine());
		System.out.print("\nDigite o Aviso da Coordenação: ");
		avisoCursoLivreVO.setPublicoAlvo(teclado.nextLine());
		System.out.print("Digite a data de cadastro do Aviso da Coordenação: ");
		avisoCursoLivreVO.setRequisito(teclado.nextLine());
		System.out.print("Digite a data de expiração do Aviso da Coordenação: ");
		avisoCursoLivreVO.setAmbiente(teclado.nextLine());
		System.out.print("Digite a data de cadastro do Aviso da Coordenação: ");
		avisoCursoLivreVO.setDataCurso(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("Digite a data de expiração do Aviso da Coordenação: ");
		avisoCursoLivreVO.setValor(Double.parseDouble(teclado.nextLine()));
		
		ControladoraAvisoCursoLivre controladoraAvisoCursoLivre = new ControladoraAvisoCursoLivre();
		controladoraAvisoCursoLivre.cadastrarAvisoCursoLivreController(avisoCursoLivreVO);
		
	}

	private void excluirAvisoCursoLivre() {
		AvisoCursoLivreVO avisoCursoLivreVO = new AvisoCursoLivreVO();
		System.out.print("\nInforme o código do Aviso: ");
		avisoCursoLivreVO.setIdAviso(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nInforme o código do Aviso da Coordenacao: ");
		avisoCursoLivreVO.setIdAvisoCursoLivre(Integer.parseInt(teclado.nextLine()));

		ControladoraAvisoCursoLivre controladoraAvisoCursoLivre = new ControladoraAvisoCursoLivre();
		controladoraAvisoCursoLivre.excluirAvisoCursoLivreController(avisoCursoLivreVO);
		
	}

	private void atualizarAvisoCursoLivre(UsuarioVO usuarioVO) {
		AvisoCursoLivreVO avisoCursoLivreVO = new AvisoCursoLivreVO();
		avisoCursoLivreVO.setIdUsuario(usuarioVO.getIdUsuario());
		System.out.print("\nDigite o Aviso da Coordenação: ");
		avisoCursoLivreVO.setNome(teclado.nextLine());
		System.out.print("\nDigite o Aviso da Coordenação: ");
		avisoCursoLivreVO.setPublicoAlvo(teclado.nextLine());
		System.out.print("Digite a data de cadastro do Aviso da Coordenação: ");
		avisoCursoLivreVO.setRequisito(teclado.nextLine());
		System.out.print("Digite a data de expiração do Aviso da Coordenação: ");
		avisoCursoLivreVO.setAmbiente(teclado.nextLine());
		System.out.print("Digite a data de cadastro do Aviso da Coordenação: ");
		avisoCursoLivreVO.setDataCurso(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("Digite a data de expiração do Aviso da Coordenação: ");
		avisoCursoLivreVO.setValor(Double.parseDouble(teclado.nextLine()));

		ControladoraAvisoCursoLivre controladoraAvisoCursoLivre = new ControladoraAvisoCursoLivre();
		controladoraAvisoCursoLivre.atualizarAvisoCursoLivreController(avisoCursoLivreVO);
		
	}

	private void consultarAvisoCursoLivre() {
		int opcao = this.apresentarOpcoesConsulta();
		ControladoraAvisoCursoLivre controladoraAvisoCursoLivre = new ControladoraAvisoCursoLivre();
		while (opcao != OPCAO_MENU_CONSULTAR_AVISO_CURSO_LIVRE_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CONSULTAR_TODOS_AVISOS_CURSO_LIVRE: {
					opcao = OPCAO_MENU_CONSULTAR_AVISO_CURSO_LIVRE_SAIR;
					ArrayList<AvisoCursoLivreVO> listaAvisosCursoLivreVO = controladoraAvisoCursoLivre.consultarTodosAvisosCursoLivreController();
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%8s   %15s   %-50s   %-15s   %-15s  \n", "ID AVISO", "ID AVISO COORD.", "DESCRIÇÃO", "DATA CADASTRO", "DATA EXPIRAÇÃO");
					for (int i = 0; i < listaAvisosCursoLivreVO.size(); i++) {
						listaAvisosCursoLivreVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UM_AVISO_CURSO_LIVRE: {
					opcao = OPCAO_MENU_CONSULTAR_AVISO_CURSO_LIVRE_SAIR;
					AvisoCursoLivreVO avisoCursoLivreVO = new AvisoCursoLivreVO();
					System.out.print("\nInforme o código do Aviso: ");
					avisoCursoLivreVO.setIdAviso(Integer.parseInt(teclado.nextLine()));
					System.out.print("\nInforme o código do Aviso da Coordenação: ");
					avisoCursoLivreVO.setIdAvisoCursoLivre(Integer.parseInt(teclado.nextLine()));
	
					AvisoCursoLivreVO avisoCursoLivre = controladoraAvisoCursoLivre.consultarAvisoCursoLivreController(avisoCursoLivreVO);
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%8s   %15s   %-50s   %-15s   %-15s   %-15s   %-15s   %-15s  \n", "ID AVISO", "ID AVISO COORD.", "NOME", "PÚBLICO ALVO", "REQUISITO", "AMBIENTE", "DATA CURSO", "VALOR");
					avisoCursoLivre.imprimir();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
					opcao = this.apresentarOpcoesConsulta();
				}
			}
		}
	}

	private int apresentarOpcoesConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_AVISOS_CURSO_LIVRE + " - Consultar todos os Avisos da Coordenação");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_AVISO_CURSO_LIVRE + " - Consultar um Aviso da Coordenação Específico");
		System.out.println(OPCAO_MENU_CONSULTAR_AVISO_CURSO_LIVRE_SAIR + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
}
