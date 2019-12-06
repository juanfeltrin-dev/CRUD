package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraAvisoEstagio;
import model.vo.AvisoEstagioVO;
import model.vo.UsuarioVO;

public class MenuEstagio {

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_LIVRE = 1;
	private static final int OPCAO_MENU_CADASTRAR_AVISO_ESTAGIO_LIVRE = 2;
	private static final int OPCAO_MENU_ATUALIZAR_AVISO_ESTAGIO_LIVRE = 3;
	private static final int OPCAO_MENU_EXCLUIR_AVISO_ESTAGIO_LIVRE = 4;
	private static final int OPCAO_MENU_AVISO_ESTAGIO_LIVRE_SAIR = 9;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_AVISOS_ESTAGIO_LIVRE = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_AVISO_ESTAGIO_LIVRE = 2;
	private static final int OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_LIVRE_SAIR = 9;
	
	private static final int ADMINISTRADOR = 1;
	private static final int COORDENADOR = 2;
	private static final int SECRETARIA = 3;
	
	public void apresentarMenuEstagio(AvisoEstagioVO avisoEstagioVO) {
		
			int opcao = this.apresentarOpcoesMenu(avisoEstagioVO.getIdUsuario());
			while (opcao != OPCAO_MENU_AVISO_ESTAGIO_LIVRE_SAIR) {
				switch (opcao) {
					case OPCAO_MENU_CADASTRAR_AVISO_ESTAGIO_LIVRE: {
						this.cadastrarAvisoEstagioLivre(avisoEstagioVO);
						break;
					}
					case OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_LIVRE: {
						this.consultarAvisoEstagioLivre();
						break;
					}
					case OPCAO_MENU_ATUALIZAR_AVISO_ESTAGIO_LIVRE: {
						this.atualizarAvisoEstagioLivre(avisoEstagioVO);
						break;
					}
					case OPCAO_MENU_EXCLUIR_AVISO_ESTAGIO_LIVRE: {
						this.excluirAvisoEstagioLivre();
						break;
					}
					default: {
						System.out.println("\nOpção Inválida");
					}
				}
				opcao = this.apresentarOpcoesMenu(avisoEstagioVO.getIdUsuario());
			}
		}

		private void cadastrarAvisoEstagioLivre(AvisoEstagioVO avisoEstagioVO) {
			AvisoEstagioVO avisoEstagioLivreVO = new AvisoEstagioVO();
			avisoEstagioVO.setIdUsuario(AvisoEstagioVO.getIdUsuario());
			System.out.print("\nDigite o Aviso do estágio: ");
			avisoEstagioVO.setNome(teclado.nextLine());
			System.out.print("\nDigite o Aviso do estágio: ");
			avisoEstagioVO.setPublicoAlvo(teclado.nextLine());
			System.out.print("Digite a data de cadastro do Aviso do estágio: ");
			avisoEstagioVO.setDataExpiracao(teclado.nextLine());
			System.out.print("Digite a data de expiração do Aviso do estágio: ");
			avisoEstagioVO.setCargo(teclado.nextLine());
			System.out.print("Digite a data de cadastro do Aviso do estágio: ");
			avisoEstagioVO.setDataExpiracao(LocalDate.parse(teclado.nextLine(), dataFormatter));
			System.out.print("Digite a data de expiração do Aviso do estágio: ");
			avisoEstagioVO.setValor(Double.parseDouble(teclado.nextLine()));
			
			ControladoraAvisoEstagio controladoraAvisoEstagio = new ControladoraAvisoEstagio();
			controladoraAvisoEstagio.cadastrarAvisoEstagioLivreController(avisoEstagioVO);
			
		
	}

		private int apresentarOpcoesMenu(int idTipoUsuario) {
			System.out.println("\nSistema de Avisos \n-------- Menu Avisos de Cursos Livres --------");
			System.out.println("\nOpções:");
			System.out.println(OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_LIVRE + " - Consultar Avisos de estágios Livres");
			if(idTipoUsuario == ADMINISTRADOR || idTipoUsuario == COORDENADOR || idTipoUsuario == SECRETARIA) {
				System.out.println(OPCAO_MENU_CADASTRAR_AVISO_ESTAGIO_LIVRE + " - Cadastrar Avisos de estágios Livres");
				System.out.println(OPCAO_MENU_ATUALIZAR_AVISO_ESTAGIO_LIVRE + " - Atualizar Avisos de estágios Livres");
				System.out.println(OPCAO_MENU_EXCLUIR_AVISO_ESTAGIO_LIVRE + " - Excluir Avisos de estágis Livres");
			}
			System.out.println(OPCAO_MENU_AVISO_ESTAGIO_LIVRE_SAIR + " - Voltar");
			System.out.print("\nDigite a Opção: ");
			return Integer.parseInt(teclado.nextLine());
		}

		

		private void excluirAvisoEstagioLivre() {
			AvisoEstagioVO avisoEstagioLivreVO = new AvisoEstagioVO();
			System.out.print("\nInforme o código do Aviso: ");
			avisoEstagioLivreVO.setIdAviso(Integer.parseInt(teclado.nextLine()));
			System.out.print("\nInforme o código do Aviso do estágio: ");
			avisoEstagioLivreVO.setIdAvisoEstagio(Integer.parseInt(teclado.nextLine()));

			ControladoraAvisoEstagio controladoraAvisoEstagioLivre = new ControladoraAvisoEstagio();
			controladoraAvisoEstagioLivre.excluirAvisoEstagioLivreController(avisoEstagioLivreVO);
			
		}

		private void atualizarAvisoEstagioLivre(AvisoEstagioVO avisoEstagioVO) {
			AvisoEstagioVO avisoEstagioLivreVO = new AvisoEstagioVO();
			avisoEstagioVO.setIdUsuario(avisoEstagioVO.getIdUsuario());
			System.out.print("\nDigite o Aviso do estágio: ");
			avisoEstagioVO.setIdAvisoEstagio(teclado.nextInt());
			System.out.print("\nDigite a empresa a tualizar do estágio: ");
			avisoEstagioVO.setEmpresa(teclado.nextLine());
			System.out.print("Digite a data de cadastro do Aviso do estágio: ");
			avisoEstagioVO.setDataCadastro(LocalDate.parse(teclado.nextLine(), dataFormatter));
			System.out.print("Digite a data de expiração do Aviso do estágio: ");
			avisoEstagioVO.setCargo(teclado.nextLine());
			System.out.print("Digite a data de cadastro do Aviso do estágio: ");
			avisoEstagioVO.setDataExpiracao(LocalDate.parse(teclado.nextLine(), dataFormatter));
			System.out.print("Digite o valor da remumeracao do estágio: ");
			avisoEstagioVO.setRemuneracao(Double.parseDouble(teclado.nextLine()));

			ControladoraAvisoEstagio controladoraAvisoEstagioLivre = new ControladoraAvisoEstagio();
			controladoraAvisoEstagioLivre.atualizarAvisoEstagioLivreController(avisoEstagioLivreVO);
			
		}

		private void consultarAvisoEstagioLivre() {
			int opcao = this.apresentarOpcoesConsulta();
			ControladoraAvisoEstagio controladoraAvisoEstagio = new ControladoraAvisoEstagio();
			while (opcao != OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_LIVRE_SAIR) {
				switch (opcao) {
					case OPCAO_MENU_CONSULTAR_TODOS_AVISOS_ESTAGIO_LIVRE: {
						opcao = OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_LIVRE_SAIR;
						ArrayList<AvisoEstagioVO> listaAvisosEstagioLivreVO = controladoraAvisoEstagio.consultarTodosAvisosEstagioLivreController();
						System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
						System.out.printf("\n%8s   %15s   %-50s   %-15s   %-15s  \n", "ID AVISO", "ID AVISO COORD.", "DESCRIÇÃO", "DATA CADASTRO", "DATA EXPIRAÇÃO");
						for (int i = 0; i < listaAvisosEstagioLivreVO.size(); i++) {
							listaAvisosEstagioLivreVO.get(i).imprimir();
						}
						break;
					}
					case OPCAO_MENU_CONSULTAR_UM_AVISO_ESTAGIO_LIVRE: {
						opcao = OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_LIVRE_SAIR;
						AvisoEstagioVO avisoEstagioLivreVO = new AvisoEstagioVO();
						System.out.print("\nInforme o código do Aviso: ");
						avisoEstagioLivreVO.setIdAviso(Integer.parseInt(teclado.nextLine()));
						System.out.print("\nInforme o código do Aviso do estagio: ");
						avisoEstagioLivreVO.setIdAvisoEstagio(Integer.parseInt(teclado.nextLine()));
						AvisoEstagioVO avisoEstagio = controladoraAvisoEstagio.consultarAvisoEstagioLivreController(avisoEstagioLivreVO);
						System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
						System.out.printf("\n%8s   %15s   %-50s   %-15s   %-15s   %-15s   %-15s   %-15s  \n", "ID AVISO", "ID AVISO COORD.", "NOME", "PÚBLICO ALVO", "REQUISITO", "AMBIENTE", "DATA CURSO", "VALOR");
						avisoEstagioLivreVO.imprimir();
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
			System.out.println(OPCAO_MENU_CONSULTAR_TODOS_AVISOS_ESTAGIO_LIVRE + " - Consultar todos os Avisos do Estagio");
			System.out.println(OPCAO_MENU_CONSULTAR_UM_AVISO_ESTAGIO_LIVRE + " - Consultar um Aviso do Estagio Específico");
			System.out.println(OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_LIVRE_SAIR + " - Voltar");
			System.out.print("\nDigite a Opção: ");
			return Integer.parseInt(teclado.nextLine());
		}
		
	}


