package com.br.bayer.BO;

import com.br.bayer.DAO.RegiaoDAO;

public class Regiao {
	
	private int id_regiao;
	private String nm_regiao;
	
	
	public int getId_regiao() {
		return id_regiao;
	}
	public void setId_regiao(int id_regiao) {
		this.id_regiao = id_regiao;
	}
	public String getNm_regiao() {
		return nm_regiao;
	}
	public void setNm_regiao(String nm_regiao) {
		this.nm_regiao = nm_regiao;
	}
	
	public Regiao SelecionaRegiao(int id) {
		RegiaoDAO rDao = new RegiaoDAO();
		return rDao.GetById(id);
	}
	
	@Override
	public String toString() {
		return " [ nm_regiao = " + nm_regiao + "]";
	}
	
	
	
}
