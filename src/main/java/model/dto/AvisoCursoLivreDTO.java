package model.dto;

public class AvisoCursoLivreDTO {
	private String nome;
	private String email;
	private String login;
	private int idTipoUsuario;
	private String descricao;
	
	public AvisoCursoLivreDTO(String nome, String email, String login, int idTipoUsuario, String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.idTipoUsuario = idTipoUsuario;
		this.descricao = descricao;
	}

	public AvisoCursoLivreDTO() {
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
	
	
}
