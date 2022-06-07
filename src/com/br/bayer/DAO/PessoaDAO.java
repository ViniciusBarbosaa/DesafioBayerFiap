package com.br.bayer.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.bayer.BO.Pessoa;
import com.br.bayer.BO.Regiao;


public class PessoaDAO {
	
	DAO dao = new DAO();
	
	public int add(Pessoa u) {
		
		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement("INSERT INTO T_PESSOA VALUES(SEQ_PESSOA.NEXTVAL, ?,?,?)"); 
			stmt.setString(1, u.getNm_pessoa());
			stmt.setString(2, u.getDt_nascimento());
			stmt.setInt(3, u.getRegiao().getId_regiao());
			return dao.executeCommand(stmt);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Pessoa>getAll(){
		
		List<Pessoa> lst = new ArrayList<Pessoa>();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnection().prepareStatement("SELECT A.ID_PESSOA, A.NM_PESSOA, A.DT_NASCIMENTO, B.ID_REGIAO,"
					+ " B.NM_REGIAO FROM T_PESSOA A INNER JOIN T_REGIAO B ON A.ID_REGIAO = B.ID_REGIAO");
		 
		ResultSet rs = null;
		rs = dao.getData(stmt);
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setId_pessoa(rs.getInt("ID_PESSOA"));
				p.setNm_pessoa(rs.getString("NM_PESSOA"));
				p.setDt_nascimento(rs.getString("DT_NASCIMENTO"));
				
				Regiao r = new Regiao();
				r.setId_regiao(rs.getInt("ID_REGIAO"));
				r.setNm_regiao(rs.getString("NM_REGIAO"));
				p.setRegiao(r);
				lst.add(p);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}
	
	public int Delete(int id) {

		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement("DELETE FROM T_PESSOA WHERE ID_PESSOA = ?");
			stmt.setInt(1, id);
			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public Pessoa GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnection().prepareStatement("SELECT A.ID_PESSOA, A.NM_PESSOA, A.DT_NASCIMENTO,B.ID_REGIAO, B.NM_REGIAO"
					+ " FROM T_PESSOA A INNER JOIN T_REGIAO B ON A.ID_REGIAO = B.ID_REGIAO WHERE A.ID_PESSOA = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.getData(stmt);
			result.next();
			Pessoa p = new Pessoa();
			p.setId_pessoa(result.getInt("ID_PESSOA"));
			p.setNm_pessoa(result.getString("NM_PESSOA"));
			p.setDt_nascimento(result.getString("DT_NASCIMENTO"));
			
			Regiao r = new Regiao();
			r.setId_regiao(result.getInt("ID_REGIAO"));
			r.setNm_regiao(result.getString("NM_REGIAO"));
			p.setRegiao(r);
			
			return p;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
}