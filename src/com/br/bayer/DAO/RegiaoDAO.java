package com.br.bayer.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.bayer.BO.Regiao;


public class RegiaoDAO {
	
	public Regiao GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnection().prepareStatement("SELECT * FROM T_REGIAO WHERE ID_REGIAO = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.getData(stmt);
			result.next();
			Regiao r = new Regiao();
			r.setNm_regiao(result.getString("NM_REGIAO"));
			r.setId_regiao(result.getInt("ID_REGIAO"));
			return r;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
}
