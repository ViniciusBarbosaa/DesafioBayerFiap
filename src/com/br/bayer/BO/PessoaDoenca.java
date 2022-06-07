package com.br.bayer.BO;

import java.util.List;


import com.br.bayer.DAO.PessoaDoencaDAO;

public class PessoaDoenca {
	
	private Pessoa pessoa;
	private Doenca doenca;
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Doenca getDoenca() {
		return doenca;
	}
	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}
	
	@Override
	public String toString() {
		return "pessoa= " + pessoa + ", doenca= " + doenca;
	}
	
	public int AdicionaPessoaDoenca() {
		PessoaDoencaDAO pdDao = new PessoaDoencaDAO();
		return pdDao.add(this);
	}
	
	public int RemovePessoaDoemca(int id) {
		PessoaDoencaDAO pdDao = new PessoaDoencaDAO();
		return pdDao.Delete(id);
	}
	
	public List<PessoaDoenca> VisualizaPessoaDoencaTudo() {
		PessoaDoencaDAO pdDao = new PessoaDoencaDAO();
		return pdDao.getAllTudo();
	}

	
	
	
}
