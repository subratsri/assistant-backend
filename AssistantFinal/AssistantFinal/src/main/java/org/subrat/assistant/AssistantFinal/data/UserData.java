package org.subrat.assistant.AssistantFinal.data;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserData {

	private String user_email;
	private String user_fname;
	private String user_mname;
	private String user_lname;
	public Date user_birthdate;
	private String user_dlocation;
	private String user_slocation;
	private String user_clocation;
	private int user_access;
	private int sessionid;
	
	public int getSessionid() {
		return sessionid;
	}

	public void setSessionid(int sessionid) {
		this.sessionid = sessionid;
	}

	public UserData(String user_email, String user_fname, String user_mname, String user_lname, Date user_birthdate, String user_dlocation, String user_slocation, String user_clocation, int user_access, int sessionid) {
		this.user_email = user_email;
		this.user_fname = user_fname;
		this.user_mname = user_mname;
		this.user_lname = user_lname;
		this.user_birthdate = user_birthdate;
		this.user_dlocation = user_dlocation;
		this.user_slocation = user_slocation;
		this.user_clocation = user_clocation;
		this.user_access = user_access;
		this.sessionid = sessionid;
	}
	
	public UserData(int user_access) {
		this.user_access = user_access;
	}
	public UserData() {
		
	}
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_fname() {
		return user_fname;
	}
	public void setUser_fname(String user_fname) {
		this.user_fname = user_fname;
	}
	public String getUser_mname() {
		return user_mname;
	}
	public void setUser_mname(String user_mname) {
		this.user_mname = user_mname;
	}
	public String getUser_lname() {
		return user_lname;
	}
	public void setUser_lname(String user_lname) {
		this.user_lname = user_lname;
	}
	public Date getUser_birthdate() {
		return user_birthdate;
	}
	public void setUser_birthdate(Date user_birthdate) {
		this.user_birthdate = user_birthdate;
	}
	public String getUser_dlocation() {
		return user_dlocation;
	}
	public void setUser_dlocation(String user_dlocation) {
		this.user_dlocation = user_dlocation;
	}
	public String getUser_slocation() {
		return user_slocation;
	}
	public void setUser_slocation(String user_slocation) {
		this.user_slocation = user_slocation;
	}
	public String getUser_clocation() {
		return user_clocation;
	}
	public void setUser_clocation(String user_clocation) {
		this.user_clocation = user_clocation;
	}
	public int getUser_access() {
		return user_access;
	}
	public void setUser_access(int user_access) {
		this.user_access = user_access;
	}
	
}
