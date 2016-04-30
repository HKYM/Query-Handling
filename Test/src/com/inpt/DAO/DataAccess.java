package com.inpt.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.inpt.dataBase.DBUtils;
import com.inpt.model.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccess {
	
	 public static void addUser(User n){
	        try {
	            PreparedStatement ps = DBUtils.getPreparedStatement("insert into Users(username,password,firstName,lastName,groups,image) values(?,?,?,?,?,?)");
	            ps.setString(1, n.getlastName()+n.getfirstName());
	            ps.setString(2, n.getfirstName());
	            ps.setString(3, n.getfirstName());
	            ps.setString(4, n.getlastName());
	            ps.setString(5, n.getGroups());
	            ps.setString(6, n.getImage());
	            ps.executeUpdate();
	            
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	public static List<User> getAllUsers(){
		List<User> ls = new LinkedList<>();
	        
	        try {
	            ResultSet rs = DBUtils.getPreparedStatement("select * from users").executeQuery();
	            while(rs.next()){
	            	User n = new User(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
	            	n.setId(rs.getInt(1));
	                ls.add(n);
					
	            }
	            
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        
	        return ls;
	    }
	
	    
	    
	    public static HashMap getUserById(int id){
	    	HashMap map = new HashMap<>();
	        String sql = "select * from Users where id = " +id;
	        try {
	            ResultSet rs = DBUtils.getPreparedStatement(sql).executeQuery();
	            while(rs.next()){
	                User n = new User(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
	                map.put( "firstName", n.getfirstName());
	                map.put("lastName", n.getlastName());
	                map.put("groups", n.getGroups());
	                map.put("image", n.getImage());
	            }
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        
	        return map;
	    }
	    
	   

	    public void edit(int id, String firstName, String lastName, String groups, String category, String image){
	        try {
	            String sql = "update users SET firstName = ?, lastName = ?, groups = ?, image = ?" + " where id = ?";
	            PreparedStatement ps= DBUtils.getPreparedStatement(sql);
	            ps.setString(1, firstName);
	            ps.setString(2, lastName);
	            ps.setString(3, groups);
	            ps.setString(5, image);
	            ps.setInt(6, id);
	            ps.executeUpdate();
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	    }
	    
	    public void delete(int id){
	        try {
	            String sql = "delete users where id = ?";
	            PreparedStatement ps = DBUtils.getPreparedStatement(sql);
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
}
