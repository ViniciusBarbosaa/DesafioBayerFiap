package com.br.bayer.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	private Connection conn;
	
	public DAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		
		openConnection();
		return this.conn;
	}
	
	private void openConnection() {
		try {
			if (this.conn == null) {
				this.conn = DriverManager.getConnection("jdbc:oracle:thin:@ORACLE.FIAP.COM.BR:1521:ORCL", "--------", "--------");
			}
			
			System.out.println("Conexao esta aberta");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.openConnection();
	}
	
	private void closeConnection() {
		try {
			if (this.conn != null) {
				this.conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int executeCommand(PreparedStatement stmt) {
		int j = 0;
		
		try {
			j = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		return j;
	}
	
	public ResultSet getData(PreparedStatement stmt) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	

	
}
