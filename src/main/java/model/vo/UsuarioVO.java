package model.vo;

public class UsuarioVO extends TipoUsuarioVO {
	private int idUsuario;
	private String nome;
	private String cpf;
	private String email;
	private String login;
	private String senha;
	
	public UsuarioVO(int idTipoUsuario, String descricao, String acao, int idUsuario, String nome, String cpf,
			String email, String login, String senha) {
		super(idTipoUsuario, descricao, acao);
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}

	public UsuarioVO() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void imprimir() {
        System.out.printf("%3d %-40s %-15s %-15s\n",
                this.getIdTipoUsuario(),
                this.getNome(),
                this.getCpf(),
                this.getEmail());
	}
	
}
