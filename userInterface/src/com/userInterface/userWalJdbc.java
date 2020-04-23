package com.userInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.userInterface.userInterface;

public class userWalJdbc implements userWal {
	public static String url = "jdbc:mysql://localhost:/cognizant";
	public static String driverName = "com.mysql.jdbc.Driver";
	public static String user = "root";
	public static String password = "root";

	// we need to load the driver

	public static Connection getDbConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);

		} catch (ClassNotFoundException e1) {
			System.out.println("No driver found ");

		}
		try {
			// obtain the connection using the driver manager
			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			System.out.println("unable to connect to sql workbench ");

		}
		return con;
	}

	public static  String addUserDetails(userInterface user) {
		System.out.println("inside this meathod");
		System.out.println(user);
		  Connection con = getDbConnection();
		  if(con!=null) {
			  try {
			  String sql="insert into user(userName,email,password,mobileNo)values(?,?,?,?)";
			  PreparedStatement psmt= con.prepareStatement(sql);
			  psmt.setString(1, user.userName);
				psmt.setString(2, user.emial);
				psmt.setString(3, user.password);
				psmt.setLong(4, user.mobileNo);
				
				int noOfRowsAffected=psmt.executeUpdate();
				System.out.println(noOfRowsAffected);
				if(noOfRowsAffected>0) {
					System.out.println("Data is sucessfully add");
					return "Data is sucessfully add";
				}
				
				
			  
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }finally {
			  try {
				  con.close();
			  }catch(SQLException e) {
				  e.printStackTrace();
			  }
		  }
			  
		  }
		return null;
	}

	@Override
	public userInterface checkLoginDetails(String userName, String password) {
		System.out.println("inside the check login meathod");
		System.out.println(userName);
		System.out.println(password);
		Connection con = getDbConnection();
		//note connection should not ne null hence we check 
		System.out.println(con);
		userInterface user=null;
		String sql="select *from user where userName=? and password=?";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, userName);
			psmt.setString(2,password);
			ResultSet rs= psmt.executeQuery();
			
			while(rs.next()) {
				user=new userInterface();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("userName"));
			user.setEmial(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setMobileNo(rs.getLong("mobileNo"));
				
			}}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}return user;}
		
		
		
		
		
	

	@Override
	public ArrayList<userInterface> getAllTheUserDetails() {
		ArrayList<userInterface> ulist=new ArrayList<userInterface>();
		Connection con = getDbConnection();
		try {
			PreparedStatement psmt=con.prepareStatement("select * from the user");
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				userInterface user=new userInterface();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setEmial(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setMobileNo(rs.getLong("mobileNo"));
				ulist.add(user);
			}}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		System.out.println("--->"+ulist);
		return ulist;
	}

	@Override
	public userInterface getUserById(Integer id) {
		userInterface user = null;
		Connection con = getDbConnection();
		try {
			PreparedStatement psmt = con.prepareStatement("select *from user where id =?");
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				user = new userInterface();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setEmial(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setMobileNo(rs.getLong("mobileNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		

		return user;
	}

	@Override
	public boolean updateUserById(userInterface user) {
		Connection con = getDbConnection();
		String sql = "update user set userName=?,email=?,password=?,mobileNo=?where id=?";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, user.userName);
			psmt.setString(2, user.emial);
			psmt.setString(3, user.password);
			psmt.setLong(4, user.mobileNo);
			psmt.setInt(5, user.id);

			int executeUpdate = psmt.executeUpdate();
			if (executeUpdate > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteUserById(Integer id) {
		Connection con = getDbConnection();
		String sql = "delete from user where id=?";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1, id);
			int update=psmt.executeUpdate();
			if(update>0) {
				return true;
			}}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
