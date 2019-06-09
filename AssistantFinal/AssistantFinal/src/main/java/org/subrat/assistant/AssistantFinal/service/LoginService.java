package org.subrat.assistant.AssistantFinal.service;

import java.sql.*;
import org.subrat.assistant.AssistantFinal.data.UserData;

public class LoginService {

	public UserData getUserDetails(String emailUser, String passwordUser) throws Exception{
		String url = "jdbc:mysql://localhost:3306/assistant";
		String uname = "root";
		String pass = "password";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		String query="select user_password from user_ldata where user_email=\""+emailUser+"\"";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String passCheck = rs.getString("user_password");
		if(passwordUser.equals(passCheck)) {
			ResultSet  rs2 = st.executeQuery("select * from user_pdata where user_email = \""+emailUser+"\"");
			rs2.next();
			if(rs2.getInt("user_access")==1) {
			String user_fname = rs2.getString("user_fname");
			String user_mname = rs2.getString("user_mname");
			String user_lname = rs2.getString("user_lname");
			Date user_birthdate = rs2.getDate("user_birthdate");
			String user_dlocation = rs2.getString("user_dlocation");
			String user_slocation = rs2.getString("user_slocation");
			String user_clocation = rs2.getString("user_clocation");
			int user_access = rs2.getInt("user_access");

			String query3 = "select current_sessionid_empty from user_sessionid_generator";
			Statement st3 = con.createStatement();
			ResultSet rs3 = st3.executeQuery(query3);
			rs3.next();
			int sessionid = rs3.getInt("current_sessionid_empty");
			String query1_4 ="DELETE FROM user_sessionid_generator WHERE current_sessionid_empty = \""+sessionid+"\"";
			Statement st1_4= con.createStatement();
			st1_4.execute(query1_4);
			UserData userData = new UserData(emailUser, user_fname, user_mname, user_lname, user_birthdate, user_dlocation, user_slocation, user_clocation, user_access, sessionid);
			int newsessionid = sessionid+1;
			String query1_5 = "insert into user_sessionid_generator values("+newsessionid+")";
			System.out.println(newsessionid);
			Statement st1_5 = con.createStatement();
			st1_5.execute(query1_5);
			String query1_6 = "insert into user_session_details values(\""+sessionid+"\", \""+emailUser+"\", \"\", \"\")";
			Statement st1_6 = con.createStatement();
			st1_6.execute(query1_6);
			st.close();
			st3.close();
			st1_4.close();
			st1_5.close();
			con.close();
			return userData;
			}
			else {
				UserData userNullData = new UserData(0);
				st.close();
				con.close();
				return userNullData;
			}
		}
		else {
			UserData userNullData = new UserData(0);
			st.close();
			con.close();
			return userNullData;
		}
	}
}
