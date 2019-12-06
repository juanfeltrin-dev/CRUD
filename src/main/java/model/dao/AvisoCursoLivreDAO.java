package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.vo.AvisoCoordenacaoVO;
import model.vo.AvisoCursoLivreVO;

public class AvisoCursoLivreDAO extends AvisoDAO {

	public boolean existeRegistroAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT avc.nome FROM avisocursolivre avc, aviso av "
				+ "WHERE avc.idaviso = av.idaviso "
				+ "and avc.nome like '" + avisoCursoLivreVO.getNome().toUpperCase() + "' "
				+ "and av.datacurso >= " + avisoCursoLivreVO.getDataCurso();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Aviso da Coordenação.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public boolean existeRegistroPorIdAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT avc.idavisocursolivre, av.idaviso FROM avisocursolivre avc, aviso av "
				+ "WHERE avc.idaviso = av.idaviso "
				+ " and av.idaviso = " + avisoCursoLivreVO.getIdAviso()
				+ " and avc.idavisocursolivre = " + avisoCursoLivreVO.getIdAvisoCursoLivre();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Aviso da Coordenação por ID.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
		int idAviso = this.cadastrarAvisoDAO(avisoCursoLivreVO);
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO avisocursolivre (idaviso, nome) VALUES (" 
				+ idAviso + ", '" 
				+ avisoCursoLivreVO.getNome() + "')";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Aviso de Curso Livre.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
		boolean atualizado = this.atualizarAvisoDAO(avisoCursoLivreVO);
		int resultado = 0;
		if(atualizado) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			String query = "UPDATE avisocoordenacao SET idaviso = " + avisoCursoLivreVO.getIdAviso() 
						+ ", nome = '" + avisoCursoLivreVO.getNome()
						+ "' WHERE idavisocursolivre = " + avisoCursoLivreVO.getIdAvisoCursoLivre();
			try {
				resultado = stmt.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("Erro ao executar a Query de Atualização do Aviso de Curso Livre.");
				System.out.println("Erro: " + e.getMessage());
			} finally {
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
		} 
		return resultado;
	}

	public int excluirAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM avisocursolivre WHERE idavisocursolivre = " + avisoCursoLivreVO.getIdAvisoCursoLivre();
		try{
			resultado = stmt.executeUpdate(query);
			if(resultado == 1) {
				query = "DELETE FROM aviso WHERE idaviso = " + avisoCursoLivreVO.getIdAviso();
				resultado = 0;
				resultado = stmt.executeUpdate(query);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão do Aviso de Curso Livre.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<AvisoCursoLivreVO> consultarTodosAvisoCursoLivreDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<AvisoCursoLivreVO> avisosCursoLivreVO = new ArrayList<AvisoCursoLivreVO>();
		String query = "SELECT av.idaviso, avc.idavisocursolivre, av.idusuario, avc.nome, av.datacadastro, av.dataexpiracao "
				+ " FROM aviso av, avisocoordenacao avc "
				+ " WHERE av.idaviso = avc.idaviso";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				AvisoCursoLivreVO avisoCursoLivreVO = new AvisoCursoLivreVO();
				avisoCursoLivreVO.setIdAviso(Integer.parseInt(resultado.getString(1)));
				avisoCursoLivreVO.setIdAvisoCursoLivre(Integer.parseInt(resultado.getString(2)));
				avisoCursoLivreVO.setIdUsuario(Integer.parseInt(resultado.getString(3)));
				avisoCursoLivreVO.setNome(resultado.getString(4));
				avisoCursoLivreVO.setPublicoAlvo(LocalDate.parse(resultado.getString(5), dataFormatter));
				avisoCursoLivreVO.setRequisito(LocalDate.parse(resultado.getString(6), dataFormatter));
				avisoCursoLivreVO.setRequisito(LocalDate.parse(resultado.getString(6), dataFormatter));
				avisoCursoLivreVO.setDataCurso(LocalDate.parse(resultado.getString(6), dataFormatter));
				avisoCursoLivreVO.setValor(Integer.parseInt(resultado.getString(6));
				avisosCursoLivreVO.add(avisoCursoLivreVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta dos Avisos da Coordenação.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return avisosCursoLivreVO;
	}

	public AvisoCursoLivreVO consultarAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		AvisoCursoLivreVO avisoCursoLivre = new AvisoCursoLivreVO();
		String query = "SELECT av.idaviso, avc.idavisocoordenacao, av.idusuario, avc.descricao, av.datacadastro, av.dataexpiracao "
				+ " FROM aviso av, avisocoordenacao avc "
				+ " WHERE av.idaviso = avc.idaviso "
				+ " and av.idaviso = " + avisoCursoLivreVO.getIdAviso()
				+ " and avc.idavisocoordenacao = " + avisoCursoLivreVO.getIdAvisoCursoLivre();
		try{
			resultado = stmt.executeQuery(query);
			if(resultado.next()){
				avisoCursoLivre.setIdAviso(Integer.parseInt(resultado.getString(1)));
				avisoCursoLivre.setIdAvisoCoordenacao(Integer.parseInt(resultado.getString(2)));
				avisoCursoLivre.setIdUsuario(Integer.parseInt(resultado.getString(3)));
				avisoCursoLivre.setDescricao(resultado.getString(4));
				avisoCursoLivre.setDataCadastro(LocalDate.parse(resultado.getString(5), dataFormatter));
				avisoCursoLivre.setDataExpiracao(LocalDate.parse(resultado.getString(6), dataFormatter));
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta do Aviso da Coordenação.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return avisoCursoLivre;
	}

}
