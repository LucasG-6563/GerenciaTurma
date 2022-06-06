package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.BD;

public class Professor_DisciplinaDAO {

	/**
	 * Faz a inserção de dados na tabela Professor_Disciplina
	 * 
	 * @param t - Possui os dados da Professor_Disciplina em uma classe.
	 */
	public void inserir(Professor_Disciplina d) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "insert into Professor_Disciplina(idProfessor, codDisciplina) values(?, ?)";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(1, d.getIdProfessor());
			banco.st.setInt(2, d.getCodDisciplina());
			banco.st.execute();

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}

	/**
	 * Faz a alteração de dados com o código da classe
	 * 
	 * @param t - Possui os dados da Professor_Disciplina em uma classe.
	 */
	public void alterar(Professor_Disciplina d) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "Update Professor_Disciplina set idProfessor=?, codDisciplina=? where cod=?";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(3, d.getCod());
			banco.st.setInt(1, d.getIdProfessor());
			banco.st.setInt(2, d.getCodDisciplina());
			banco.st.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}

	/**
	 * Lista todos os dados da tabela Professor_Disciplina
	 * 
	 * @return - Retorna uma lista com as Professor_Disciplinas.
	 */
	public ArrayList<Professor_Disciplina> listarTodos() {
		BD bd = new BD();
		bd.getConnection();
		Professor_Disciplina d;
		ArrayList<Professor_Disciplina> lista = new ArrayList<Professor_Disciplina>();
		String sql = "select * from Professor_Disciplina";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) { // enquanto existir próximo
				d = new Professor_Disciplina();
				d.setCod(bd.rs.getInt("cod"));
				d.setIdProfessor(bd.rs.getInt("idProfessor"));
				d.setCodDisciplina(bd.rs.getInt("codDisciplina"));
				lista.add(d);
			}
			return lista;

		} catch (SQLException e) {
			return null;
		} finally {
			bd.close();
		}
	}

	/**
	 * Deletar os dados da tabela que possuem um código específicado
	 * 
	 * @param cod - código da Professor_Disciplina que será deletada.
	 */
	public void delete(int cod) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "Delete from Professor_Disciplina where cod = ?";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(1, cod);
			banco.st.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}
	
	public String buscarNomeProfessor(int id) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "select nome from Professor where idProfessor=?";
		String nome = null;
		
		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(1, id);
			banco.rs = banco.st.executeQuery();
			nome = banco.rs.getString("nome");
			System.out.println("ALOO"+nome);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		finally {
			banco.close();
		}
		return nome;
	}
	public String buscarNomeDisciplina(int cod) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "select nome from Disciplina where cod=?";
		String nome = null;
		
		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(1, cod);
			banco.rs = banco.st.executeQuery();
			nome = banco.rs.getString("nome");
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		finally {
			banco.close();
		}
		return nome;
	}
}
