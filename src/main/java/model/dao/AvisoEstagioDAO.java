package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.dto.AvisoEstagioDTO;
import model.vo.AvisoEstagioVO;

public class AvisoEstagioDAO extends AvisoDAO {
DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public boolean existeRegistroAvisoEstagioDAO(AvisoEstagioVO avisoEstagioVO) {
		
		Connection conn = Banco.getConnection();
		Statement stmt = (Statement) Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT ave.cargo FROM avisoestagio ave, aviso av "
				+ "WHERE ave.idaviso = av.idaviso "
				+ "and ave.cargo like '" + avisoEstagioVO.getCargo().toUpperCase() + "' "
				+ "and av.dataexpiracao >= " + avisoEstagioVO.getDataExpiracao();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência do aviso de Estágio.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}
	
	
	public boolean existeRegistroPorIdAvisoEstagioDAO(AvisoEstagioVO avisoEstagioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = (Statement) Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT ave.idavisoestagio, av.idaviso FROM avisoestagio ave, aviso av "
				+ "WHERE ave.idaviso = av.idaviso "
				+ " and av.idaviso = " + avisoEstagioVO.getIdAviso()
				+ " and ave.idavisoestagio = " + avisoEstagioVO.getIdAvisoEstagio();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência do aviso de Estágio por ID.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	
	public int cadastrarAvisoEstagioDAO(AvisoEstagioVO avisoEstagioVO) {
		int idAviso = this.cadastrarAvisoDAO(avisoEstagioVO);
		Connection conn = Banco.getConnection();
		Statement stmt = (Statement) Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO avisoestagio (idaviso, empresa, telefone, email, cargo, jornada, remuneracao) VALUES (" 
				+ idAviso 
				+ ", '" + avisoEstagioVO.getEmpresa()
				+ "', '" + avisoEstagioVO.getTelefone()
				+ "', '" + avisoEstagioVO.getEmail()
				+ "', '" + avisoEstagioVO.getCargo()
				+ "', '" + avisoEstagioVO.getJornada()
				+ "', " + avisoEstagioVO.getRemuneracao() + ")";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Aviso de Estágio.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}


	public int atualizarAvisoEstagioDAO(AvisoEstagioVO avisoEstagioVO) {
		boolean atualizado = this.atualizarAvisoDAO(avisoEstagioVO);
		int resultado = 0;
		if(atualizado) {
			Connection conn = Banco.getConnection();
			Statement stmt = (Statement) Banco.getStatement(conn);
			String query = "UPDATE avisoestagio SET idaviso = " + avisoEstagioVO.getIdAviso() 
						+ ", empresa = '" + avisoEstagioVO.getEmpresa() + "', telefone = '" + avisoEstagioVO.getTelefone() + "', email = '" + avisoEstagioVO.getEmail()
						+ "', cargo = '" + avisoEstagioVO.getCargo() + "', jornada = '" + avisoEstagioVO.getJornada() + "', remuneracao = " + avisoEstagioVO.getRemuneracao()
						+ " WHERE idavisoestagio = " + avisoEstagioVO.getIdAvisoEstagio();
			try {
				resultado = stmt.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("Erro ao executar a Query de Atualização do Aviso de Estágio.");
				System.out.println("Erro: " + e.getMessage());
			} finally {
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
		} 
		return resultado;
	}

	public int excluirAvisoEstagioDAO(AvisoEstagioVO avisoEstagioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = (Statement) Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM avisoestagio WHERE idavisoestagio = " + avisoEstagioVO.getIdAvisoEstagio();
		try{
			resultado = stmt.executeUpdate(query);
			if(resultado == 1) {
				query = "DELETE FROM aviso WHERE idaviso = " + avisoEstagioVO.getIdAviso();
				resultado = 0;
				resultado = stmt.executeUpdate(query);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão do Aviso de Estágio.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}


	public ArrayList<AvisoEstagioVO> consultarTodosAvisoEstagioDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<AvisoEstagioVO> avisosEstagioVO = new ArrayList<AvisoEstagioVO>();
		String query = "SELECT av.idaviso, ave.idavisoestagio, ave.empresa, ave.telefone, ave.email, ave.cargo, ave.jornada, ave.remuneracao, av.datacadastro, av.dataexpiracao "
				+ " FROM aviso av, avisoestagio ave "
				+ " WHERE av.idaviso = ave.idaviso";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				AvisoEstagioVO avisoEstagioVO = new AvisoEstagioVO();
				avisoEstagioVO.setIdAviso(Integer.parseInt(resultado.getString(1)));
				avisoEstagioVO.setIdAvisoEstagio(Integer.parseInt(resultado.getString(2)));
				avisoEstagioVO.setEmpresa(resultado.getString(3));
				avisoEstagioVO.setTelefone(resultado.getString(4));
				avisoEstagioVO.setEmail(resultado.getString(5));
				avisoEstagioVO.setCargo(resultado.getString(6));
				avisoEstagioVO.setJornada(resultado.getString(7));
				avisoEstagioVO.setRemuneracao(Double.parseDouble(resultado.getString(8)));
				avisoEstagioVO.setDataCadastro(LocalDate.parse(resultado.getString(9), dataFormatter));
				avisoEstagioVO.setDataExpiracao(LocalDate.parse(resultado.getString(10), dataFormatter));
				avisosEstagioVO.add(avisoEstagioVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta dos Avisos da estágio.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return avisosEstagioVO;
	}


	public AvisoEstagioVO consultarAvisoEstagioDAO(AvisoEstagioVO avisoEstagioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		AvisoEstagioVO avisoEstagio = new AvisoEstagioVO();
		String query = "SELECT av.idaviso, ave.idavisoestagio, ave.empresa, ave.telefone, ave.email, ave.cargo, ave.jornada, ave.remuneracao, av.datacadastro, av.dataexpiracao "
				+ " FROM aviso av, avisoestagio ave "
				+ " WHERE av.idaviso = ave.idaviso "
				+ " and av.idaviso = " + avisoEstagioVO.getIdAviso()
				+ " and ave.idavisoestagio = " + avisoEstagioVO.getIdAvisoEstagio();
		try{
			resultado = stmt.executeQuery(query);
			if(resultado.next()){
				avisoEstagio.setIdAviso(Integer.parseInt(resultado.getString(1)));
				avisoEstagio.setIdAvisoEstagio(Integer.parseInt(resultado.getString(2)));
				avisoEstagio.setEmpresa(resultado.getString(3));
				avisoEstagio.setTelefone(resultado.getString(4));
				avisoEstagio.setEmail(resultado.getString(5));
				avisoEstagio.setCargo(resultado.getString(6));
				avisoEstagio.setJornada(resultado.getString(7));
				avisoEstagio.setRemuneracao(Double.parseDouble(resultado.getString(8)));
				avisoEstagio.setDataCadastro(LocalDate.parse(resultado.getString(9), dataFormatter));
				avisoEstagio.setDataExpiracao(LocalDate.parse(resultado.getString(10), dataFormatter));
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta do Aviso de Estágio.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return avisoEstagio;
	}


	public ArrayList<AvisoEstagioDTO> consultarRelatorioAvisoEstagioDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<AvisoEstagioDTO> avisosEstagioDTO = new ArrayList<AvisoEstagioDTO>();
		String query = "SELECT ave.empresa, ave.cargo, ave.jornada, ave.remuneracao, ave.telefone "
				+ " FROM avisoestagio ave";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				AvisoEstagioDTO avisoEstagioDTO = new AvisoEstagioDTO();
				avisoEstagioDTO.setNomeEmpresa(resultado.getString(1));
				avisoEstagioDTO.setCargo(resultado.getString(2));
				avisoEstagioDTO.setJornada(resultado.getString(3));
				avisoEstagioDTO.setRemuneracao(Double.parseDouble(resultado.getString(4)));
				avisoEstagioDTO.setTelefone(resultado.getString(5));
				System.out.println(avisoEstagioDTO);
				avisosEstagioDTO.add(avisoEstagioDTO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Relatório de Avisos de Estágio.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return avisosEstagioDTO;
	}
}
