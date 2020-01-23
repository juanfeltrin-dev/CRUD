package model.dto;


public class UsuarioDTO {
	private String nome;
	private String email;
	private String login;
	private String tipoUsuario;
	private String acao;

	public UsuarioDTO(String nome, String email, String login, String tipoUsuario, String acao) {
		super();
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.tipoUsuario = tipoUsuario;
		this.acao = acao;
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
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}

	public void imprimir() {
		System.out.printf("\n%-15s   %-15s   %-15s   %8s   %8s  \n", 
				this.getNome(), 
				this.getEmail(), 
				this.getLogin(), 
				this.getTipoUsuario(), 
				this.getAcao());
	}
	
}
