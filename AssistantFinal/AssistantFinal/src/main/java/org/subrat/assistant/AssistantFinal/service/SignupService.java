package org.subrat.assistant.AssistantFinal.service;
import java.sql.*;
import org.subrat.assistant.AssistantFinal.data.StatusData;

public class SignupService {

	public StatusData putUserData(String user_email, String user_fname, String user_mname, String user_lname, Date user_birthdate, String user_dlocation, String user_slocation, String user_clocation, String user_password) throws Exception{
		int user_access = 1;
		String url = "jdbc:mysql://localhost:3306/assistant";
		String uname = "root";
		String pass = "password";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		String query = "select user_fname from user_pdata where user_email = \""+user_email+"\"";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		if(rs.next()) {
			StatusData status = new StatusData(0, 0);
			return status;
		}
		else {
			String query1 = "select current_sessionid_empty from user_sessionid_generator";
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery(query1);
			rs1.next();
			int sessionid = rs1.getInt("current_sessionid_empty");
			StatusData status = new StatusData(1, sessionid);
			sessionid++;
			String query1_5 = "insert into user_sessionid_generator values("+sessionid+")";
			Statement st1_5 = con.createStatement();
			st1_5.execute(query1_5);
			String query2 = "insert into user_pdata values(\""+user_email+"\", \""+user_fname+"\", \""+user_mname+"\", \""+user_lname+"\", \""+user_birthdate+"\", \""+user_dlocation+"\", \""+user_slocation+"\", \""+user_clocation+"\", \""+user_access+"\")";
			Statement st2 = con.createStatement();
			st2.execute(query2);
			String query3 = "insert into user_ldata values(\""+user_email+"\", \""+user_password+"\")";
			Statement st3 = con.createStatement();
			st3.execute(query3);
			return status;

		}
	}
	/*public static void main(String[] args) throws Exception {
		String str="1997-03-31";  
	    Date date=Date.valueOf(str);
		System.out.println(putUserData("dasrajkumar15@stu.upes.ac.in", "Raj", "Kumar", "Das", date, "Patna", "Bihar", "India", "rajkumar@123"));
	}*/
}
