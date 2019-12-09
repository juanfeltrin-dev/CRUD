package model.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.vo.AvisoVO;

public class AvisoEstagioDTO extends AvisoVO {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
   private String empresa;
   private String cargo;
   private String jornada;
   private double remuneracao;
   private String telefone;
   
	public AvisoEstagioDTO(int idAviso, int idUsuario, LocalDate dataCadastro, LocalDate dataExpiracao,
		DateTimeFormatter formataDate, String empresa, String cargo, String jornada, double remuneracao,
		String telefone) {
	super(idAviso, idUsuario, dataCadastro, dataExpiracao);
	this.formataDate = formataDate;
	this.empresa = empresa;
	this.cargo = cargo;
	this.jornada = jornada;
	this.remuneracao = remuneracao;
	this.telefone = telefone;
}

	public AvisoEstagioDTO() {
	super();
	}

	public String getNomeEmpresa() {
		return empresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.empresa = nomeEmpresa;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void imprimir() {
		System.out.printf("\n%-15s   %-20s   %-15s   %-15s   %-15s  \n", 
				this.getNomeEmpresa(), 
				this.getCargo(), 
				this.getJornada(), 
				this.getRemuneracao(), 
				this.getTelefone(), 
				this.getDataCadastro().format(formataDate), 
				this.getDataExpiracao().format(formataDate));
	}

}
