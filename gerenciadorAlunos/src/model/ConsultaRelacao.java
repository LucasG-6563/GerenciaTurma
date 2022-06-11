package model;

public class ConsultaRelacao {

	private int cod_relacao;
	private String nomeProfessor;
	private String disciplina;
	private String turma;
	private String periodo;
	private int ano;
	
	/**
	 * Instancia a classe com os atributos vazios
	 */
	public ConsultaRelacao() {
		this.cod_relacao = 1;
		this.nomeProfessor = "";
		this.disciplina = "";
		this.turma = "";
		this.periodo = "";
		this.ano = 1920;
	}
	
	public int getCod_relacao() {
		return cod_relacao;
	}

	public void setCod_relacao(int cod_relacao) {
		this.cod_relacao = cod_relacao;
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
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
}
