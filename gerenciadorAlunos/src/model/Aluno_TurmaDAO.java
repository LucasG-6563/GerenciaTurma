package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.BD;

public class Aluno_TurmaDAO {

	/**
	 * Faz a inserção de dados na tabela Aluno_Turma
	 * 
	 * @param t - Possui os dados da Aluno_Turma em uma classe.
	 */
	public void inserir(Aluno_Turma d) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "insert into Aluno_Turma(ra_aluno, cod_turma, ano) values(?, ?, ?)";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(1, d.getRa_aluno());
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
	 * @param t - Possui os dados da Aluno_Turma em uma classe.
	 */
	public void alterar(Aluno_Turma d) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "Update Aluno_Turma set ra_aluno=?, cod_turma=?, ano=? where cod_alun_turm=?";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(4, d.getCod_alun_turm());
			banco.st.setInt(1, d.getRa_aluno());
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
	 * Lista todos os dados da tabela Aluno_Turma
	 * 
	 * @return - Retorna uma lista com as Aluno_Turmas.
	 */
	public ArrayList<Aluno_Turma> listarTodos() {
		BD bd = new BD();
		bd.getConnection();
		Aluno_Turma d;
		ArrayList<Aluno_Turma> lista = new ArrayList<Aluno_Turma>();
		String sql = "select * from Aluno_Turma";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) { // enquanto existir próximo
				d = new Aluno_Turma();
				d.setCod_alun_turm(bd.rs.getInt("cod_alun_turm"));
				d.setRa_aluno(bd.rs.getInt("ra_aluno"));
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
	 * @param cod - código da Aluno_Turma que será deletada.
	 */
	public void delete(int cod) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "Delete from Aluno_Turma where cod = ?";

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
