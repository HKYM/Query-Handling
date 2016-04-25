package com.sdzee.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Test extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	String url ="jdbc:mysql://localhost:3306/membres";
	String login ="root";
	String passwd="";
	Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
	boolean flag=false;
	
	
		public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			
			this.getServletContext().getRequestDispatcher( "/WEB-INF/bonjour.jsp" ).forward( request, response );
			
	}
		
		public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			String identifiant = request.getParameter("identifiant");
			String mp = request.getParameter("mp");
			
	        request.setAttribute("identifiant", identifiant);
	        
	        
	        try {
	        	
	        Class.forName("com.mysql.jdbc.Driver");
			cn= DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql ="SELECT * FROM etudiant";
			rs= st.executeQuery(sql);
			
				while(rs.next()){
					if(((rs.getString("Identifiant")).equals(identifiant)) && ( (rs.getString("Password")).equals(mp))){
						flag=true;
						
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         finally 
	        { if(flag){
	        	this.getServletContext().getRequestDispatcher( "/WEB-INF/logged.jsp" ).forward( request, response );
	        	flag=false;
	        	try{
					
					cn.close();
					st.close();
					
				}
				catch(SQLException e){
					e.printStackTrace();
	       			}
	        	}
	        
	         else {
	        	 this.getServletContext().getRequestDispatcher( "/WEB-INF/bonjour.jsp" ).forward( request, response );
	        	 try{
	 				
	 				cn.close();
	 				st.close();
	 				
	 				}
	 			catch(SQLException e){
	 				e.printStackTrace();
	         		}
	        	
			} 
	        	
	        }
	        
	        
		}
	        
	



	 
		
}