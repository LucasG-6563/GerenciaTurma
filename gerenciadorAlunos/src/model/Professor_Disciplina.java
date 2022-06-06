package model;

public class Professor_Disciplina {

	private int cod;
	private int idProfessor;
	private int codDisciplina;
	private String nomeProfessor;
	private String nomeDisciplina;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	public int getCodDisciplina() {
		return codDisciplina;
	}
	
	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
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
		return nomeDisciplina;
	}
	
	/**
	 * Set nome da disciplina pelo código dela.
	 * @param cod - Código da disciplina
	 */
	public void setDisciplina(int cod) {
		DisciplinaDAO dDAO = new DisciplinaDAO();
		this.nomeDisciplina = dDAO.listarDisciplina(cod);
	}
}
