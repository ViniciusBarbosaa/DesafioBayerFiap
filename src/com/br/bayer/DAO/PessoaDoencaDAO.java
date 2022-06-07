package com.br.bayer.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.bayer.BO.Doenca;
import com.br.bayer.BO.Pessoa;
import com.br.bayer.BO.PessoaDoenca;
import com.br.bayer.BO.Regiao;


public class PessoaDoencaDAO {
	
	
	DAO dao = new DAO();
	
	public int add(PessoaDoenca pd) {
		
		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement("INSERT INTO T_PESSOADOENCA VALUES(SEQ_PESSOADOENCA.NEXTVAL,?,?)"); 
			stmt.setInt(1, pd.getDoenca().getId_doenca());
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			stmt.setDate(2, data);
			return dao.executeCommand(stmt);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<PessoaDoenca>getAllTudo(){
		
		List<PessoaDoenca> lst = new ArrayList<PessoaDoenca>();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnection().prepareStatement("SELECT B.ID_PESSOA, B.NM_PESSOA, B.DT_NASCIMENTO, C.NM_DOENCA, D.NM_REGIAO FROM T_PESSOADOENCA A "
					+ "INNER JOIN T_PESSOA B ON B.ID_PESSOA = A.ID_PESSOA\r\n"
					+ "INNER JOIN T_DOENCA C ON C.ID_DOENCA = A.ID_DOENCA\r\n"
					+ "INNER JOIN T_REGIAO D ON D.ID_REGIAO = B.ID_REGIAO");
		 
		ResultSet rs = null;
		rs = dao.getData(stmt);
			while(rs.next()) {
				Doenca d = new Doenca();
				Pessoa p = new Pessoa();
				PessoaDoenca pd= new PessoaDoenca();
				Regiao r = new Regiao();
				
				r.setNm_regiao(rs.getString("NM_REGIAO"));
				p.setRegiao(r);
				p.setNm_pessoa(rs.getString("NM_PESSOA"));
				p.setDt_nascimento(rs.getString("DT_NASCIMENTO"));
				p.setId_pessoa(rs.getInt("ID_PESSOA"));
				d.setNm_doenca(rs.getString("NM_DOENCA"));
				pd.setPessoa(p);
				pd.setDoenca(d);
				
				lst.add(pd);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}
	
	
	public int Delete(int id) {

		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement("DELETE FROM T_PESSOADOENCA WHERE ID_PESSOA = ?");
			stmt.setInt(1, id);
			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
