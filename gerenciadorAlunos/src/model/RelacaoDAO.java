package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.BD;

public class RelacaoDAO {

	/**
	 * Faz a inserção de dados na tabela Relacao
	 * 
	 * @param t - Possui os dados da Relacao em uma classe.
	 */
	public void inserir(Relacao d) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "insert into Relacao(cod_prof_disc, cod_turma, ano) values(?, ?, ?)";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(1, d.getCod_prof_disc());
			banco.st.setInt(2, d.getCod_turma());
			banco.st.setInt(3, d.getAno());
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
	 * @param t - Possui os dados da Relacao em uma classe.
	 */
	public void alterar(Relacao d) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "Update Relacao set cod_prof_disc=?, cod_turma=?, ano=? where cod_relacao=?";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(4, d.getCod_relacao());
			banco.st.setInt(1, d.getCod_prof_disc());
			banco.st.setInt(2, d.getCod_turma());
			banco.st.setInt(3, d.getAno());
			banco.st.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}

	/**
	 * Lista todos os dados da tabela Relacao
	 * 
	 * @return - Retorna uma lista com as Relacaos.
	 */
	public ArrayList<Relacao> listarTodos() {
		BD bd = new BD();
		bd.getConnection();
		Relacao d;
		ArrayList<Relacao> lista = new ArrayList<Relacao>();
		String sql = "select * from Relacao";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) { // enquanto existir próximo
				d = new Relacao();
				d.setCod_relacao(bd.rs.getInt("cod_relacao"));
				d.setCod_prof_disc(bd.rs.getInt("cod_prof_disc"));
				d.setCod_turma(bd.rs.getInt("cod_turma"));
				d.setAno(bd.rs.getInt("ano"));
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
	 * @param cod - código da Relacao que será deletada.
	 */
	public void delete(int cod) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "Delete from Relacao where cod_relacao = ?";

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
