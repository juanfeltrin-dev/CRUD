package model.dto;

import java.time.LocalDate;

import model.vo.AvisoVO;

public class AvisoCoordenacaoDTO extends AvisoVO {

	private int idAvisoCoordenacao;
	private String descricao;

	public AvisoCoordenacaoDTO(int idAvisoCoordenacao, int idAviso, int idUsuario, LocalDate dataCadastro, LocalDate dataExpiracao,
			String descricao) {
		super(idAviso, idUsuario, dataCadastro, dataExpiracao);
		this.idAvisoCoordenacao = idAvisoCoordenacao;
		this.descricao = descricao;
	}	
	
	public AvisoCoordenacaoDTO() {
		super();
	}
	
	public int getIdAvisoCoordenacao() {
		return idAvisoCoordenacao;
	}
	public void setIdAvisoCoordenacao(int idAvisoCoordenacao) {
		this.idAvisoCoordenacao = idAvisoCoordenacao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void imprimir() {
		System.out.printf("\n%8d   %8d   %-50s   %-15s   %-15s  \n", 
				this.getIdAvisoCoordenacao(), 
				this.getIdAviso(), 
				this.getDescricao(), 
				this.getDataCadastro(), 
				this.getDataExpiracao());
	}
	
	
}
