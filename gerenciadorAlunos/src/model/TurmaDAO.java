package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.BD;

public class TurmaDAO {

	/**
	 * Faz a inser��o de dados na tabela Turma
	 * @param t - Possui os dados da turma em uma classe.
	 */
	public void inserir(Turma t) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "insert into Turma values(?, ?, ?)";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(1, t.getCod());
			banco.st.setString(2, t.getSerie());
			banco.st.setString(3, t.getPeriodo());
			boolean confirma = banco.st.execute();
			System.out.println(confirma);
			if (!confirma) {
				System.out.println("Inser��o feita com sucesso em Turma.");
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
	 * @param t - Possui os dados da turma em uma classe.
	 */
	public void alterar(Turma t) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "Update Turma set serie=?, periodo=? where codigo=?";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(3, t.getCod());
			banco.st.setString(1, t.getSerie());
			banco.st.setString(2, t.getPeriodo());
			boolean confirma = banco.st.execute();
			if (confirma) {
				System.out.println("Altera��o feita com sucesso em Turma.");
			} else
				System.out.println("N�o foi poss�vel fazer a Altera��o");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}
	
	/**
	 * Lista todos os dados da tabela Turma
	 */
	public ArrayList<Turma> listarTodos() {
		BD bd = new BD();
		bd.getConnection();
		Turma d;
		ArrayList<Turma> lista = new ArrayList<Turma>();
		String sql = "select * from turma";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) { // enquanto existir pr�ximo
				d = new Turma();
				d.setCod(Integer.parseInt(bd.rs.getString("cod")));
				d.setSerie(bd.rs.getString("serie"));
				d.setPeriodo(bd.rs.getString("periodo"));
				lista.add(d);
			}
			return lista;

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			bd.close();
		}
	}
	
	/**
	 * Deletar os dados da tabela que possuem um c�digo espec�ficado
	 * @param cod - c�digo da turma que ser� deletada.
	 */
	public void delete(int cod) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "Delete from Turma where codigo = ?";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(1, cod);
			boolean confirma = banco.st.execute();
			if (confirma) {
				System.out.println("Turma deletada com sucesso.");
			} else
				System.out.println("N�o foi poss�vel deletar a turma.");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}
}
