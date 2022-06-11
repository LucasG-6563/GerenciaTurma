package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.BD;

public class ConsultaRelacaoDAO {

	/**
	 * Faz a consulta personalizada da tabela Relacao com os dados informados
	 * @param lista - Lista de palavras - Nome do professor, Nome da disciplina, serie da turma, período da turma
	 * @param ano - Ano da relação
	 * @return Lista com os dados filtrados da tabela Relacao
	 */
	public ArrayList<ConsultaRelacao> consultaRelacao(ConsultaRelacao cr) {
		BD bd = new BD();
		bd.getConnection();
		ConsultaRelacao resp;
		ArrayList<ConsultaRelacao> listaCr = new ArrayList<>();
		String sql = "select r.cod_relacao as 'Código Relação',p.nome as 'Professor',d.nome as 'Disciplina',t.serie,t.periodo, r.ano from relacao r\r\n"
				+ "inner join professor_disciplina pd on pd.cod = r.cod_prof_disc\r\n"
				+ "inner join professor p on p.idProfessor = pd.idProfessor\r\n"
				+ "inner join disciplina d on d.cod = pd.codDisciplina\r\n"
				+ "inner join turma t on t.cod = r.cod_turma\r\n"
				+ "where p.nome like ? and d.nome like ? and t.serie like ? and t.periodo like ? and r.ano >= ?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, cr.getNomeProfessor()+'%');
			bd.st.setString(2, cr.getDisciplina()+'%');
			bd.st.setString(3, cr.getTurma()+'%');
			bd.st.setString(4, cr.getPeriodo()+'%');
			bd.st.setInt(5, cr.getAno());
			bd.rs = bd.st.executeQuery();
			
			while(bd.rs.next()) {
				resp = new ConsultaRelacao();
				resp.setCod_relacao(bd.rs.getInt(1));
				resp.setNomeProfessor(bd.rs.getString(2));
				resp.setDisciplina(bd.rs.getString(3));
				resp.setTurma(bd.rs.getString(4));
				resp.setPeriodo(bd.rs.getString(5));
				resp.setAno(bd.rs.getInt(6));
				listaCr.add(resp);
			}
		} catch(SQLException ex) {
			System.out.println("Erro: "+ex);
		}
		finally {
			bd.close();
		}
		
		return listaCr;
	}
	
	public ArrayList<ConsultaRelacao> consultaRelacaoPadrao() {
		BD bd = new BD();
		bd.getConnection();
		ConsultaRelacao resp;
		ArrayList<ConsultaRelacao> listaCr = new ArrayList<>();
		String sql = "select r.cod_relacao as 'Código Relação',p.nome as 'Professor',d.nome as 'Disciplina',t.serie,t.periodo, r.ano from relacao r\r\n"
				+ "inner join professor_disciplina pd on pd.cod = r.cod_prof_disc\r\n"
				+ "inner join professor p on p.idProfessor = pd.idProfessor\r\n"
				+ "inner join disciplina d on d.cod = pd.codDisciplina\r\n"
				+ "inner join turma t on t.cod = r.cod_turma\r\n";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			
			while(bd.rs.next()) {
				resp = new ConsultaRelacao();
				resp.setCod_relacao(bd.rs.getInt(1));
				resp.setNomeProfessor(bd.rs.getString(2));
				resp.setDisciplina(bd.rs.getString(3));
				resp.setTurma(bd.rs.getString(4));
				resp.setPeriodo(bd.rs.getString(5));
				resp.setAno(bd.rs.getInt(6));
				listaCr.add(resp);
			}
		} catch(SQLException ex) {
			System.out.println("Erro: "+ex);
		}
		finally {
			bd.close();
		}
		
		return listaCr;
	}
}
