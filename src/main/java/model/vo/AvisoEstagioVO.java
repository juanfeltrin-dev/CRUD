package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AvisoEstagioVO extends AvisoVO {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private int idAvisoEstagio;
	private int idAviso;
	private String empresa;
	private String telefone;
	private String email;
	private String cargo;
	private String jornada;
	private double remuneracao;
	
	public AvisoEstagioVO(int idAvisoEstagio, int idAviso, int idUsuario, LocalDate dataCadastro, LocalDate dataExpiracao, String empresa, String telefone, String email, String cargo,
			String jornada, double remuneracao) {
		super(idAviso, idUsuario, dataCadastro, dataExpiracao);
		this.idAvisoEstagio = idAvisoEstagio;
		this.idAviso = idAviso;
		this.empresa = empresa;
		this.telefone = telefone;
		this.email = email;
		this.cargo = cargo;
		this.jornada = jornada;
		this.remuneracao = remuneracao;
	}
	
	public AvisoEstagioVO() {
		super();
	}

	public int getIdAvisoEstagio() {
		return idAvisoEstagio;
	}
	public void setIdAvisoEstagio(int idAvisoEstagio) {
		this.idAvisoEstagio = idAvisoEstagio;
	}
	public int getIdAviso() {
		return idAviso;
	}
	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public double getRemuneracao() {
		return remuneracao;
	}
	public void setRemuneracao(double remuneracao) {
		this.remuneracao = remuneracao;
	}

	public void imprimir() {
		System.out.printf("\n%8d   %15d   %-50s   %-15s   %-15s   %-15s   %-15s   %-15s  \n", 
		this.getIdAvisoEstagio(),
		this.getIdAviso(),
		this.getEmpresa(),
		this.getTelefone(),
		this.getEmail(),
		this.getCargo(),
		this.getJornada(),
		this.getRemuneracao(),
		this.getDataCadastro().format(formataDate), 
		this.getDataExpiracao().format(formataDate));
	}

	public void cadastrarAvisoEstagioLivreBO(AvisoEstagioVO avisoEstagioVO) {
		// TODO Auto-generated method stub
		
	}

	public void excluirAvisoEstagioLivreBO(AvisoEstagioVO avisoEstagioVO) {
		// TODO Auto-generated method stub
		
	}

	public void atualizarAvisoEstagioBO(AvisoEstagioVO avisoEstagioVO) {
		// TODO Auto-generated method stub
		
	}

	public static boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
