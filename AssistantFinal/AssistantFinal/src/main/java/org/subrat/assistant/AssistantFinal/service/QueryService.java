package org.subrat.assistant.AssistantFinal.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.subrat.assistant.AssistantFinal.data.QueryData;

public class QueryService {
	
	private int flag = 0;

	public QueryData queryHandler(int sessionid, String query) throws Exception {
		String url = "jdbc:mysql://localhost:3306/assistant";
		String uname = "root";
		String pass = "password";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		String query1 = "select userquery1 from user_session_details where current_sessionid_inuse = \""+sessionid+"\"";
		Statement st1 = con.createStatement();
		ResultSet rs1 = st1.executeQuery(query1);
		if(rs1.next()) {
			String userquery2 = rs1.getString("userquery1");
			String query4 = "update user_session_details SET userquery2 = \""+userquery2+"\" where current_sessionid_inuse = \""+sessionid+"\"";
			Statement st4= con.createStatement();
			st4.execute(query4);
			String query5 = "update user_session_details SET userquery1 = \""+query+"\" where current_sessionid_inuse = \""+sessionid+"\"";
			Statement st5= con.createStatement();
			st5.execute(query5);
		}
		else {
			String query2 = "update user_session_details SET userquery1 = \""+query+"\" where current_sessionid_inuse = \""+sessionid+"\"";
			Statement st2= con.createStatement();
			st2.execute(query2);
		}
		String result = "";
		String query7 = "select keyword from query_keyword_finder";
		Statement st7 = con.createStatement();
		ResultSet rs7 = st7.executeQuery(query7);
		while(rs7.next()) {
				String keyword = rs7.getString("keyword");
				keyword = keyword.toLowerCase();
				query = query.toLowerCase();
				if(query.contains(keyword)) {
					this.flag = 1;
					String query9 = "select api_key from query_keyword_finder where keyword = \""+keyword+"\"";
					Statement st9 = con.createStatement();
					ResultSet rs9 = st9.executeQuery(query9);
					rs9.next();
					String res = rs9.getString("api_key");
					result = result.concat(res+" ");
				}
		}
		if(flag==1) {
			QueryData data = new QueryData(query, result, "SELF");
			String query6 = "insert into query_manager values(\""+query+"\", \""+sessionid+"\", 1)";
			Statement st6 = con.createStatement();
			st6.execute(query6);
			return data;
		}
		else {
			String res1 = "http://api.wolframalpha.com/v2/query?input=";
			String res1_5 = res1.concat(query);
			String res2 = "&appid=PYGWEU-EW3W8GT5H7";
			String res3 = res1_5.concat(res2);
			res3 = res3.replaceAll(" ", "%20");
			String query6 = "insert into query_manager values(\""+query+"\", \""+sessionid+"\", 0)";
			Statement st6 = con.createStatement();
			st6.execute(query6);
			QueryData data = new QueryData(query, res3, "API");
			return data;
		}
	}
}
