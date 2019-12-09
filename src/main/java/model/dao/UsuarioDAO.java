package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.dto.AvisoCoordenacaoDTO;
import model.dto.UsuarioDTO;
import model.vo.TipoUsuarioVO;
import model.vo.UsuarioVO;

public class UsuarioDAO {

	public boolean existeRegistroPorCpfDAO(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select cpf from usuario where cpf = '" + cpf + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica a existência de usuário por CPF");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "insert into usuario (idtipousuario, nome, cpf, email, login, senha) values (" + usuarioVO.getIdTipoUsuario() + ", '" + usuarioVO.getNome() + "', '" + usuarioVO.getCpf() + "', '" + usuarioVO.getEmail() + "', '" + usuarioVO.getLogin() + "', '" + usuarioVO.getSenha() + "')";
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de usuário");
			System.out.println("Erro: " + e.getMessage());			
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosDAO() {
		Connection conn =  Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        ArrayList<UsuarioVO> listaUsuariosVO = new ArrayList<UsuarioVO>();
        String query = "SELECT idusuario, nome, cpf, email From usuario";
       
        try {
            resultado = stmt.executeQuery(query);
            while(resultado.next()) {
                UsuarioVO usuario = new UsuarioVO();
                usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
                usuario.setNome(resultado.getString(2));
                usuario.setCpf(resultado.getString(3));
                usuario.setEmail(resultado.getString(4));
                listaUsuariosVO.add(usuario);
            }
        }catch(SQLException e) {
           
            System.out.println("Erro ao executar a query de consulta todos usuarios .");
            System.out.println("Erro: " + e.getMessage());
        }finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return listaUsuariosVO;
	}

    public UsuarioVO consultarUsuarioDAO(UsuarioVO usuarioVO) {
        Connection conn =  Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        UsuarioVO usuario = new UsuarioVO();
        String query = "SELECT idusuario, nome, cpf, email from usuario where idusuario = " + usuarioVO.getIdUsuario();
       
        try {
            resultado = stmt.executeQuery(query);
            if(resultado.next()) {
               
                usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
                usuario.setNome(resultado.getString(2));
                usuario.setCpf(resultado.getString(3));
                usuario.setEmail(resultado.getString(4));
               
            }
        }catch(SQLException e) {
           
            System.out.println("Erro ao executar a query de consulta todos usuarios .");
            System.out.println("Erro: " + e.getMessage());
        }finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return usuario;
    }
	
	public int excluirUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from usuario where idUsuario = " + usuarioVO.getIdUsuario();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de exclusão de usuário");
			System.out.println("Erro: " + e.getMessage());			
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

    public int atualizarUsuarioDAO(UsuarioVO usuarioVO) {
        Connection conn =  Banco.getConnection();
		Statement stmt = (Statement) Banco.getStatement(conn);
        int  resultado = 0;
        String query = "UPDATE usuario SET nome = '" + usuarioVO.getNome() 
                + "', cpf = '" + usuarioVO.getCpf()
                + "', email = '" + usuarioVO.getEmail()
                + "', idTipoUsuario = " + usuarioVO.getIdTipoUsuario() 
                + ", senha = '" + usuarioVO.getSenha()
                + "' WHERE idusuario = " + usuarioVO.getIdUsuario();
        try {
            resultado = stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de atualizar usuario");
            System.out.println("Erro: "+ e.getMessage());
        }finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);        
            
        }
        return resultado;
    }

	public UsuarioVO recuperarUsuarioDAO(UsuarioVO usuarioVO) {
	       Connection conn =  Banco.getConnection();
	        Statement stmt = Banco.getStatement(conn);
	        ResultSet resultado = null;
	        String query = "SELECT idUsuario, idTipoUsuario, nome, cpf, email from usuario where login = '" + usuarioVO.getLogin() + "' and senha = '" + usuarioVO.getSenha() + "' ";
	       
	        try {
	            resultado = stmt.executeQuery(query);
	            while(resultado.next()) {
	            	usuarioVO.setIdUsuario(Integer.parseInt(resultado.getString(1)));
	            	usuarioVO.setIdTipoUsuario(Integer.parseInt(resultado.getString(2)));
	            	usuarioVO.setNome(resultado.getString(3));
	            	usuarioVO.setCpf(resultado.getString(4));
	            	usuarioVO.setEmail(resultado.getString(5));
	            }
	        }catch(SQLException e) {
	           
	            System.out.println("Erro ao executar a query que recupera o usuário.");
	            System.out.println("Erro: " + e.getMessage());
	        }finally {
	            Banco.closeResultSet(resultado);
	            Banco.closeStatement(stmt);
	            Banco.closeConnection(conn);
	        }
	        return usuarioVO;
	}

	public boolean existeRegistroPorIdUsuarioDAO(int idUsuario) {
		return false;
	}

	public ArrayList<TipoUsuarioVO> consultarTipoUsuarioDAO() {
	       	Connection conn =  Banco.getConnection();
	        Statement stmt = Banco.getStatement(conn);
	        ResultSet resultado = null;
	        ArrayList<TipoUsuarioVO> lista = new ArrayList<TipoUsuarioVO>();
	        String query = "SELECT IDTIPOUSUARIO, DESCRICAO from tipousuario";
	       
	        try {
	            resultado = stmt.executeQuery(query);
	            while(resultado.next()) {
	            	TipoUsuarioVO tipoUsuario = new TipoUsuarioVO();
	            	tipoUsuario.setIdTipoUsuario(Integer.parseInt(resultado.getString(1)));
	            	tipoUsuario.setDescricao(resultado.getString(2));
	            	lista.add(tipoUsuario);
	            }
	        }catch(SQLException e) {
	           
	            System.out.println("Erro ao executar a query que recupera os tipos de usuário.");
	            System.out.println("Erro: " + e.getMessage());
	        }finally {
	            Banco.closeResultSet(resultado);
	            Banco.closeStatement(stmt);
	            Banco.closeConnection(conn);
	        }
		return lista;
	}

	public static ArrayList<UsuarioDTO> consultarRelatorioUsuariosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		String query = "SELECT u.nome, u.email, u.login, t.descricao, t.acao "
				+ " FROM usuario u, tipousuario t where u.IDTIPOUSUARIO = t.IDTIPOUSUARIO";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				usuarioDTO.setNome(resultado.getString(1));
				usuarioDTO.setEmail(resultado.getString(2));
				usuarioDTO.setLogin(resultado.getString(3));
				usuarioDTO.setTipoUsuario(resultado.getString(4));
				usuarioDTO.setAcao(resultado.getString(5));
				usuariosDTO.add(usuarioDTO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta dos Avisos da Coordenação.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuariosDTO;
	}

}
