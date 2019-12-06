package model.dto;

public class AvisoEstagioDTO{
   private String empresa;
   private String cargo;
   private String jornada;
   private double remuneracao;
   private String telefone;
   
   public AvisoEstagioDTO(String nomeEmpresa, String cargo, String jornada, double remuneracao, String telefone) {
		super();
		this.empresa = nomeEmpresa;
		this.cargo = cargo;
		this.jornada = jornada;
		this.remuneracao = remuneracao;
		this.telefone = telefone;
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
		System.out.printf("\n%8d   %8d   %-15s   %-15s   %-15s  \n", 
				this.getNomeEmpresa(), 
				this.getCargo(), 
				this.getJornada(), 
				this.getRemuneracao(), 
				this.getTelefone());
	}

}
