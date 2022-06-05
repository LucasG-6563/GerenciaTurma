package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import services.BD;

public class ProfessorDAO {

	/**
	 * Faz a inserção de dados na tabela Professor
	 * @param p - Possui os dados do Professor em uma classe.
	 */
	public void inserir(Professor p) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "insert into Professor(nome, endereco, datanasc, telefone, cpf, rg) values(?, ?, ?, ?, ?, ?)";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setString(1, p.getNome());
			banco.st.setString(2, p.getEndereco());
			banco.st.setDate(3, p.getDataNasc());
			banco.st.setString(4, p.getTelefone());
			banco.st.setString(5, p.getCpf());
			banco.st.setString(6, p.getRg());
			banco.st.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}
	
	/**
	 * Faz a alteração de dados com o código da classe
	 * @param p - Possui os dados do Professor em uma classe.
	 */
	public void alterar(Professor p) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "Update Professor set nome=?, endereco=?, datanasc=?, telefone=?, cpf=?, rg=? where idProfessor=?";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(7, p.getIdProfessor());
			banco.st.setString(1, p.getNome());
			banco.st.setString(2, p.getEndereco());
			banco.st.setDate(3, p.getDataNasc());
			banco.st.setString(4, p.getTelefone());
			banco.st.setString(5, p.getCpf());
			banco.st.setString(6, p.getRg());
			banco.st.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}
	
	/**
	 * Lista todos os dados da tabela Professor
	 */
	public ArrayList<Professor> listarTodos() {
		BD bd = new BD();
		bd.getConnection();
		Professor p;
		ArrayList<Professor> lista = new ArrayList<Professor>();
		String sql = "select * from Professor";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) { // enquanto existir próximo
				p = new Professor();
				p.setIdProfessor(bd.rs.getInt("idProfessor"));
				p.setNome(bd.rs.getString("nome"));
				p.setEndereco(bd.rs.getString("endereco"));
				p.setDataNasc(bd.rs.getString("dataNasc"));
				p.setTelefone(bd.rs.getString("telefone"));
				p.setCpf(bd.rs.getString("cpf"));
				p.setRg(bd.rs.getString("rg"));
				lista.add(p);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bd.close();
		}
		return lista;
	}
	
	/**
	 * Deletar os dados da tabela que possuem um código específicado
	 * @param cod - código do Professor que será deletado.
	 */
	public void delete(int cod) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "Delete from Professor where idProfessor = ?";

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
