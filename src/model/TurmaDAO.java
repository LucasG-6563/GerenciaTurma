package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.BD;

public class TurmaDAO {

	/**
	 * Faz a inserção de dados na tabela Turma
	 * @param t - Possui os dados da turma em uma classe.
	 */
	public void inserir(Turma t) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "insert into Turma(serie, periodo) values(?, ?)";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setString(1, t.getSerie());
			banco.st.setString(2, t.getPeriodo());
			banco.st.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}
	
	/**
	 * Faz a alteração de dados com o código da classe
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
			banco.st.execute();
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
			while (bd.rs.next()) { // enquanto existir próximo
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
	 * Deletar os dados da tabela que possuem um código específicado
	 * @param cod - código da turma que será deletada.
	 */
	public void delete(int cod) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "Delete from Turma where codigo = ?";

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
