package model.vo;

public class TipoUsuarioVO {
	private int idTipoUsuario;
	private String descricao;
	private String acao;

	public TipoUsuarioVO(int idTipoUsuario, String descricao, String acao) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.descricao = descricao;
		this.acao = acao;
	}
	
	public TipoUsuarioVO() {
		super();
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	
}
