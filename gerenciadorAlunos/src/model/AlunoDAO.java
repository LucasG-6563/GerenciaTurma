package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import services.BD;

public class AlunoDAO {

	/**
	 * Faz a inserção de dados na tabela Aluno
	 * @param p - Possui os dados do Aluno em uma classe.
	 */
	public void inserir(Aluno p) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "insert into Aluno(nome, endereco, datanasc, telefone, cpf, rg, nomeResp, cpfResp, rgResp) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setString(1, p.getNome());
			banco.st.setString(2, p.getEndereco());
			banco.st.setDate(3, p.getDataNasc());
			banco.st.setString(4, p.getTelefone());
			banco.st.setString(5, p.getCpf());
			banco.st.setString(6, p.getRg());
			banco.st.setString(7, p.getNomeResp());
			banco.st.setString(8, p.getCpfResp());
			banco.st.setString(9, p.getRgResp());
			banco.st.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}
	
	/**
	 * Faz a alteração de dados com o código da classe
	 * @param p - Possui os dados do Aluno em uma classe.
	 */
	public void alterar(Aluno p) {

		BD banco = new BD();
		banco.getConnection();
		String sql = "Update Aluno set nome=?, endereco=?, datanasc=?, telefone=?, cpf=?, rg=?, nomeResp=?, cpfResp=?, rgResp=? where ra=?";

		try {
			banco.st = banco.con.prepareStatement(sql);
			banco.st.setInt(10, p.getRa());
			banco.st.setString(1, p.getNome());
			banco.st.setString(2, p.getEndereco());
			banco.st.setDate(3, p.getDataNasc());
			banco.st.setString(4, p.getTelefone());
			banco.st.setString(5, p.getCpf());
			banco.st.setString(6, p.getRg());
			banco.st.setString(7, p.getNomeResp());
			banco.st.setString(8, p.getCpfResp());
			banco.st.setString(9, p.getRgResp());
			banco.st.execute();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			banco.close();
		}
	}
	
	/**
	 * Lista todos os dados da tabela Aluno
	 */
	public ArrayList<Aluno> listarTodos() {
		BD bd = new BD();
		bd.getConnection();
		Aluno p;
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		String sql = "select * from Aluno";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) { // enquanto existir próximo
				p = new Aluno();
				p.setRa(bd.rs.getInt("ra"));
				p.setNome(bd.rs.getString("nome"));
				p.setEndereco(bd.rs.getString("endereco"));
				p.setDataNasc(bd.rs.getString("dataNasc"));
				p.setTelefone(bd.rs.getString("telefone"));
				p.setCpf(bd.rs.getString("cpf"));
				p.setRg(bd.rs.getString("rg"));
				p.setNomeResp(bd.rs.getString("nomeResp"));
				p.setCpfResp(bd.rs.getString("cpfResp"));
				p.setRgResp(bd.rs.getString("rgResp"));
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
	 * @param cod - código do Aluno que será deletado.
	 */
	public void delete(int cod) {
		BD banco = new BD();
		banco.getConnection();
		String sql = "Delete from Aluno where ra = ?";

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
