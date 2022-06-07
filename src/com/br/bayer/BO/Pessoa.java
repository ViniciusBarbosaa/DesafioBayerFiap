package com.br.bayer.BO;

import java.util.List;


import com.br.bayer.DAO.PessoaDAO;

public class Pessoa {
	
	private int id_pessoa;
	private String nm_pessoa;
	private String dt_nascimento;
	private Regiao regiao;
	
	public int getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public String getNm_pessoa() {
		return nm_pessoa;
	}
	public void setNm_pessoa(String nm_pessoa) {
		this.nm_pessoa = nm_pessoa;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	public String getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(String dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	
	@Override
	public String toString() {
		
		return "[id_pessoa= " + id_pessoa + ", nm_pessoa= " + nm_pessoa + ", dt_nascimento= " + dt_nascimento
				+ ", regiao=" + regiao + "]";
	}
	
	public int AdicionaPessoa() {
		PessoaDAO pDao = new PessoaDAO();
		return pDao.add(this);
	}
	
	public int RemovePessoa(int id) {
		PessoaDAO pDao = new PessoaDAO();
		return pDao.Delete(id);
	}
	
	
	public List<Pessoa> VisualizaPessoa() {
		PessoaDAO pDao = new PessoaDAO();
		return pDao.getAll();
	}
	
	public Pessoa SelecionaPessoa(int id) {
		PessoaDAO pDao = new PessoaDAO();
		return pDao.GetById(id);
	}
	
	
	

	
	
}
