package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AvisoCursoLivreVO extends AvisoVO {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private int idAvisoCursoLivre;
	private int idAviso;
	private String nome;
	private String publicoAlvo;
	private String requisito;
	private String ambiente;
	private LocalDate dataCurso;
	private double valor;

	public AvisoCursoLivreVO(int idAvisoCursoLivre, int idAviso, int idUsuario, LocalDate dataCadastro, LocalDate dataExpiracao, String nome, String publicoAlvo, String requisito,
			String ambiente, LocalDate dataCurso, double valor) {
		super(idAviso, idUsuario, dataCadastro, dataExpiracao);
		this.idAvisoCursoLivre = idAvisoCursoLivre;
		this.idAviso = idAviso;
		this.nome = nome;
		this.publicoAlvo = publicoAlvo;
		this.requisito = requisito;
		this.ambiente = ambiente;
		this.dataCurso = dataCurso;
		this.valor = valor;
	}

	public AvisoCursoLivreVO() {
		super();
	}

	public int getIdAvisoCursoLivre() {
		return idAvisoCursoLivre;
	}

	public void setIdAvisoCursoLivre(int idAvisoCursoLivre) {
		this.idAvisoCursoLivre = idAvisoCursoLivre;
	}

	public int getIdAviso() {
		return idAviso;
	}

	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPublicoAlvo() {
		return publicoAlvo;
	
	}
	

	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	public String getRequisito() {
		return requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public LocalDate getDataCurso() {
		return dataCurso;
	}

	public void setDataCurso(LocalDate dataCurso) {
		this.dataCurso = dataCurso;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}	

	public void imprimir() {
		System.out.printf("\n%8s   %15s   %-50s   %-15s   %-15s   %-15s   %-15s   %-15s   %-15s   %-15s  \n", 
				this.getIdAviso(), 
				this.getIdAvisoCursoLivre(), 
				this.getNome(), 
				this.getPublicoAlvo(), 
				this.getRequisito(), 
				this.getAmbiente(), 
				this.getDataCurso().format(formataDate), 
				this.getValor(), 
				this.getDataCadastro().format(formataDate), 
				this.getDataExpiracao().format(formataDate));
	}
}
