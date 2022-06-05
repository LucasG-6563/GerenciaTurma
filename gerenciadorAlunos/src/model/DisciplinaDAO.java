package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.BD;

public class DisciplinaDAO {

	/**
	 * Faz a inserção de dados na tabela Disciplina
	 * 
	 * @param t - Possui os dados da Disciplina em uma classe.
	 */
	public void inserir(Disciplina d) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "insert into Disciplina(nome, area) values(?, ?)";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setString(1, d.getNome());
			banco.st.setString(2, d.getArea());
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
	 * @param t - Possui os dados da Disciplina em uma classe.
	 */
	public void alterar(Disciplina d) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "Update Disciplina set nome=?, area=? where codigo=?";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(3, d.getCod());
			banco.st.setString(1, d.getNome());
			banco.st.setString(2, d.getArea());
			banco.st.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}

	/**
	 * Lista todos os dados da tabela Disciplina
	 * 
	 * @return - Retorna uma lista com as disciplinas.
	 */
	public ArrayList<Disciplina> listarTodos() {
		BD bd = new BD();
		bd.getConnection();
		Disciplina d;
		ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
		String sql = "select * from disciplina";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) { // enquanto existir próximo
				d = new Disciplina();
				d.setCod(Integer.parseInt(bd.rs.getString("cod")));
				d.setNome(bd.rs.getString("nome"));
				d.setArea(bd.rs.getString("area"));
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
	 * @param cod - código da Disciplina que será deletada.
	 */
	public void delete(int cod) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "Delete from Disciplina where codigo = ?";

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

}
