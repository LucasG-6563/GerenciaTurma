package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.BD;

public class DisciplinaDAO {

	/**
	 * Faz a inser��o de dados na tabela Disciplina
	 * 
	 * @param t - Possui os dados da Disciplina em uma classe.
	 */
	public void inserir(Disciplina d) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "insert into Disciplina values(?, ?, ?)";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(1, d.getCod());
			banco.st.setString(2, d.getNome());
			banco.st.setString(3, d.getArea());
			boolean confirma = banco.st.execute();
			System.out.println(confirma);
			if (!confirma) {
				System.out.println("Inser��o feita com sucesso em Disciplina.");
			} else
				System.out.println("N�o foi poss�vel fazer a inser��o");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}

	/**
	 * Faz a altera��o de dados com o c�digo da classe
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
			boolean confirma = banco.st.execute();
			if (!confirma) {
				System.out.println("Altera��o feita com sucesso em Disciplina.");
			} else
				System.out.println("N�o foi poss�vel fazer a Altera��o");
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
		String sql = "select * from Disciplina";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) { // enquanto existir pr�ximo
				d = new Disciplina();
				d.setCod(Integer.parseInt(bd.rs.getString("codigo")));
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
	 * Deletar os dados da tabela que possuem um c�digo espec�ficado
	 * 
	 * @param cod - c�digo da Disciplina que ser� deletada.
	 */
	public void delete(int cod) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "Delete from Disciplina where codigo = ?";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(1, cod);
			boolean confirma = banco.st.execute();
			if (!confirma) {
				System.out.println("Disciplina deletada com sucesso.");
			} else
				System.out.println("N�o foi poss�vel deletar a disciplina.");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}

}
