package com.database.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDao extends BaseDao{
	
	public int createUser(String userId, String userName, String pswrd, String email){
		int result = 0;
		try{
			openConnection();
			Statement stmt = connection.createStatement();
			String sqlQuery = "INSERT INTO USR_TBL (USR_ID, USR_NME, USR_PWD, USR_EMAIL ) VALUES "
					+ "('"+userId+"', '"+userName+"', '"+pswrd+"', '"+email+"')";
			result = stmt.executeUpdate(sqlQuery);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeConnection();
		}
		return result;
	}
	
	public int updateUser(String userId, String userName, String pswrd, String email){
		int result = 0;
		try{
			openConnection();
			String sqlQuery = "UPDATE USR_TBL SET USR_NME = ?, USR_PWD = ?, USR_EMAIL=? WHERE USR_ID = ?";
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setString(1, userName);
			pstmt.setString(2, pswrd);
			pstmt.setString(3, email);
			pstmt.setString(4, userId);
			result = pstmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeConnection();
		}
		return result;
	}
	
	public int deleteUser(String userId){
		int result = 0;
		try{
			openConnection();
			Statement stmt = connection.createStatement();
			String sqlQuery = "DELETE FROM USR_TBL WHERE USR_ID="+userId;
			result = stmt.executeUpdate(sqlQuery);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeConnection();
		}
		return result;
	}
	
	public int checkUser(String userNme, String pswrd){
		int result = 0;
		try{
			openConnection();
			Statement stmt = connection.createStatement();
			/*String sqlQuery = "SELECT COUNT(*) RESULT FROM USR_TBL WHERE USR_NME='"+userNme+"'"
										+ " AND USR_PWD='"+pswrd+"'";*/
			String sqlQuery = "SELECT * FROM USR_TBL WHERE USR_NME='"+userNme+"'"
					+ " AND USR_PWD='"+pswrd+"'";
			ResultSet rset = stmt.executeQuery(sqlQuery);
			if(rset.next()){
				//result = rset.getInt("RESULT");
				result = 1;
			}
							
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeConnection();
		}
		return result;
	}
	
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<User>();
		try{
			openConnection();
			Statement stmt = connection.createStatement();
			String sqlQuery = "SELECT * FROM USR_TBL ";
			ResultSet rset = stmt.executeQuery(sqlQuery);
			while(rset.next()){
				User user = new User();
				user.setUserId(rset.getString("USR_ID"));
				user.setUserName(rset.getString("USR_NME"));
				user.setPassword(rset.getString("USR_PWD"));
				user.setEmail(rset.getString("USR_EMAIL"));
				userList.add(user);
			}
							
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeConnection();
		}
		return userList;
	}

	
	

}
