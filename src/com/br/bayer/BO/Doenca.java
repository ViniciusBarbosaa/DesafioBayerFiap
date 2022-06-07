package com.br.bayer.BO;

import com.br.bayer.DAO.DoencaDAO;

public class Doenca {
	
	private int id_doenca;
	private String nm_doenca;
	
	
	public int getId_doenca() {
		return id_doenca;
	}
	public void setId_doenca(int id_doenca) {
		this.id_doenca = id_doenca;
	}
	public String getNm_doenca() {
		return nm_doenca;
	}
	public void setNm_doenca(String nm_doenca) {
		this.nm_doenca = nm_doenca;
	}
	
	@Override
	public String toString() {
		return "[nm_doenca= " + nm_doenca + "]";
	}
	
	public Doenca SelecionaDoenca(int id) {
		DoencaDAO dDao = new DoencaDAO();
		return dDao.GetById(id);
	}
	
	

}
