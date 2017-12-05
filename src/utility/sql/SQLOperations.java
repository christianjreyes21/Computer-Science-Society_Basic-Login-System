package utility.sql;

import java.sql.*;

import javax.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import utility.Security;
import utility.sql.SQLCommands;
import model.MemberBean;

public class SQLOperations implements SQLCommands {

	private static Connection connection;
	
	private SQLOperations() {
	}
	
	private static Connection getDBConnection() {
		try {
		    InitialContext context = new InitialContext();
		    DataSource dataSource = (DataSource) 
		     context.lookup("java:comp/env/jdbc/CSS-DS");
		    
		    if (dataSource != null) {
		    	connection = dataSource.getConnection();
		    } else {
		    	System.err.println("DataSource is NULL.");
		    }
		} catch (NamingException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return connection;
	 }
	
	public static Connection getConnection() {
		return (connection!=null)?connection:getDBConnection();
	}
	
	public static boolean addMember(MemberBean member, 
		Connection connection) {
		
		try {
	        PreparedStatement pstmt = connection.prepareStatement(INSERT_MEMBER);
	        pstmt.setString(1, member.getUsername());
	        pstmt.setString(2, Security.encrypt(member.getPassword())); 
	        pstmt.setString(3, member.getFirstName());
	        pstmt.setString(4, member.getLastName());
	        pstmt.setString(5, member.getGender());   
	        pstmt.setString(6, member.getBirthdate());  
	        pstmt.setString(7, member.getEmail());  
	        pstmt.executeUpdate(); // execute insert statement  
		} catch (SQLException sqle) {
			System.out.println("SQLException - addMember: " + sqle.getMessage());
			return false; 
		}	
		return true;
	}
	
	public static MemberBean retrieveMember(String username, 
		Connection connection) {
		MemberBean member = new MemberBean();
		 
		try {
	        PreparedStatement pstmt = 
	        	connection.prepareStatement(RETRIEVE_MEMBER);
	        pstmt.setString(1, username);             
	        ResultSet rs  = pstmt.executeQuery();
	        
	        while (rs.next()) { 
	        	member.setUsername(rs.getString("USERNAME"));
	        	member.setPassword(Security.decrypt(rs.getString("PASSWORD")));
	        	member.setLastName(rs.getString("LASTNAME"));
	        	member.setFirstName(rs.getString("FIRSTNAME"));
	        	member.setGender(rs.getString("GENDER"));
	        	member.setBirthdate(rs.getString("BIRTHDATE"));
	        	member.setEmail(rs.getString("EMAIL"));
	        }
		} catch (SQLException sqle) {
			System.out.println("SQLException - retrieveMember: " 
					+ sqle.getMessage());
			return member; 
		}	
		return member;
	}
}
