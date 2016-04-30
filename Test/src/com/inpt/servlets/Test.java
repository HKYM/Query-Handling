package com.inpt.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inpt.DAO.DataAccess;
import com.inpt.dataBase.DBUtils;


public class Test extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	
	ResultSet rs=null;
	boolean flag=false;
	boolean flagAdmin=false;
	
		public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			
			this.getServletContext().getRequestDispatcher( "/WEB-INF/bonjour.jsp" ).forward( request, response );
			
	}
		
		public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			String identifiant = request.getParameter("identifiant");
			String mp = request.getParameter("mp");
			
	        
	        
	        
	        try {
	        	
	        String sql ="SELECT * FROM users ";
			rs= DBUtils.getPreparedStatement(sql).executeQuery();
			
				while(rs.next()){
					if(((rs.getString("username")).equals(identifiant)) && ( (rs.getString("password")).equals(mp))){
						flag=true;
						if (rs.getString("groups").equals("Administrateur")){
							flagAdmin=true;
						}
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
	        	if(flagAdmin){
	        		request.setAttribute("allusers", DataAccess.getAllUsers());
	        		this.getServletContext().getRequestDispatcher( "/allusers.jsp" ).forward( request, response );
	        		flag=false;
	        		flagAdmin=false;
	        		
	        	}
	        	else{
	        		this.getServletContext().getRequestDispatcher( "/WEB-INF/logged.jsp" ).forward( request, response );
	        		flag=false;
	        		flagAdmin=false;
	        	}
	        	
	        	
	        	try{
					
	        		DBUtils.closeConnection();
					
					
				}
				catch(SQLException | ClassNotFoundException e){
					e.printStackTrace();
	       			}
	        	}
	        
	         else {
	        	 this.getServletContext().getRequestDispatcher( "/WEB-INF/bonjour.jsp" ).forward( request, response );
	        	 try{
	 				
	 				DBUtils.closeConnection();
	 				
	 				
	 				}
	 			catch(SQLException e){
	 				e.printStackTrace();
	         		} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
			} 
	        	
	        }
	        
	        
		}
	        
	



	 
		
}