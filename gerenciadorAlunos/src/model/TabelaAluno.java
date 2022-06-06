package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TabelaAluno extends AbstractTableModel{

	private ArrayList<Aluno> tabela;
	private String[] colunas = {"RA","Nome","Endereço","Data Nascimento","Telefone","CPF","RG","Responsável","CPF Resp","RG Resp"};
	
	
	public TabelaAluno() {
		this.tabela = new ArrayList<>();
	}
	
	public void addAluno(Aluno t) {
		tabela.add(t);
	}
	public void cleanTabela() {
		tabela.clear();
	}
	
	public Aluno getAluno(int linha) {
		return this.tabela.get(linha);
	}
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.tabela.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return this.tabela.get(rowIndex).getRa();
		case 1:
			return this.tabela.get(rowIndex).getNome();
		case 2:
			return this.tabela.get(rowIndex).getEndereco();
		case 3:
			return this.tabela.get(rowIndex).getDataNasc();
		case 4:
			return this.tabela.get(rowIndex).getTelefone();
		case 5:
			return this.tabela.get(rowIndex).getCpf();
		case 6:
			return this.tabela.get(rowIndex).getRg();
		case 7:
			return this.tabela.get(rowIndex).getNomeResp();
		case 8:
			return this.tabela.get(rowIndex).getCpfResp();
		case 9:
			return this.tabela.get(rowIndex).getRgResp();
		default:
			return this.tabela.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}
}
