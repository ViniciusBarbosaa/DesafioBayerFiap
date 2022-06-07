package com.br.bayer.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.bayer.BO.Doenca;


public class DoencaDAO {
	
	public Doenca GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnection().prepareStatement("SELECT * FROM T_DOENCA WHERE ID_DOENCA = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.getData(stmt);
			while (result.next()) {
				Doenca d = new Doenca();
				d.setNm_doenca(result.getString("NM_DOENCA"));
				d.setId_doenca(result.getInt("ID_DOENCA"));
				return d;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
}