package model.dto;

import model.vo.TipoUsuarioVO;

public class UsuarioDTO extends TipoUsuarioVO {
	private String nome;
	private String email;
	private String login;
	private String tipoUsuario;
	
	public UsuarioDTO(int idTipoUsuario, String descricao, String nome, String email, String login,
			String tipoUsuario) {
		super(idTipoUsuario, descricao);
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.tipoUsuario = tipoUsuario;
	}
	
	public UsuarioDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public void imprimir() {
		System.out.printf("\n%-15s   %-15s   %-15s   %8d  \n", 
				this.getNome(), 
				this.getEmail(), 
				this.getLogin(), 
				this.getTipoUsuario());
	}
	
}
