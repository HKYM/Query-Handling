package com.sdzee.jdbc;

import java.sql.*;

public class DemoJdbc {

	public static void Reading(){
		String url ="jdbc:mysql://localhost:3306/membres";
		String login ="root";
		String passwd="";
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn= DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql ="SELECT * FROM etudiant";
			rs= st.executeQuery(sql);
			
			while(rs.next()){
				System.out.println(rs.getString("Identifiant"));
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		finally{
			try{
				
				cn.close();
				st.close();
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          DemoJdbc a= new DemoJdbc();
          a.Reading();
	}

}
