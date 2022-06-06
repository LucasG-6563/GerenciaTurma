package model;

import java.sql.Date;
import java.text.ParseException;

public abstract class Pessoa {

	private String nome;
	private String endereco;
	private Date dataNasc;
	private String telefone;
	private String cpf;
	private String rg;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	
	/**
	 * Set dataNasc de uma String
	 * @param dataNasc - Data de nascimento em String no formato yyyy-MM-dd
	 * @throws ParseException - Joga uma mensagem caso de erro na conversão de String para Date
	 */
	public void setDataNasc(String dataNasc) throws ParseException {
		this.dataNasc = Date.valueOf(dataNasc);
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
