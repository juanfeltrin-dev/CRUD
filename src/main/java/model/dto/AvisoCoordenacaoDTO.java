package model.dto;

public class AvisoCoordenacaoDTO {

	private String descricao;
	private String dataCadastro;
	private String dataExpiracao;
	public AvisoCoordenacaoDTO(String descricao, String dataCadastro, String dataExpiracao) {
		super();
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.dataExpiracao = dataExpiracao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	
}
