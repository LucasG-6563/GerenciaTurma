package model;

public class Relacao {

	private int cod_relacao;
	private int cod_prof_disc;
	private int cod_turma;
	private int ano;
	private String nomeProfessor;
	private String disciplina;
	private String turma;
	
	public int getCod_relacao() {
		return cod_relacao;
	}
	public void setCod_relacao(int cod_relacao) {
		this.cod_relacao = cod_relacao;
	}
	public int getCod_prof_disc() {
		return cod_prof_disc;
	}
	public void setCod_prof_disc(int cod_prof_disc) {
		this.cod_prof_disc = cod_prof_disc;
	}
	public int getCod_turma() {
		return cod_turma;
	}
	public void setCod_turma(int cod_turma) {
		this.cod_turma = cod_turma;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	
	/**
	 * Set nome do professor pelo id dele.
	 * @param idProfessor - Identificador do professor
	 */
	public void setNomeProfessor(int idProfessor) {
		ProfessorDAO pDAO=new ProfessorDAO();
		this.nomeProfessor = pDAO.listarNomeProfessor(idProfessor);
	}
	public String getDisciplina() {
		return disciplina;
	}
	
	/**
	 * Set nome da disciplina pelo código dela.
	 * @param cod - Código da disciplina
	 */
	public void setDisciplina(int cod) {
		DisciplinaDAO dDAO = new DisciplinaDAO();
		this.disciplina = dDAO.listarDisciplina(cod);
	}
	public String getTurma() {
		return turma;
	}
	
	/**
	 * Set nome da turma pelo código dela.
	 * @param cod - Código da Turma
	 */
	public void setTurma(int cod) {
		TurmaDAO tDAO = new TurmaDAO();
		this.turma = tDAO.listarTurma(cod);
	}
	
}
