package org.subrat.assistant.AssistantFinal.data;

import java.sql.Date;

public class SignupData {

	private String user_email;
	private String user_fname;
	private String user_mname;
	private String user_lname;
	private Date user_birthdate;
	private String user_dlocation;
	private String user_slocation;
	private String user_clocation;
	private String user_password;
	
	public SignupData(String user_email, String user_fname, String user_mname, String user_lname, Date user_birthdate, String user_dlocation, String user_slocation, String user_clocation, String user_password) {
		this.user_email = user_email;
		this.user_fname = user_fname;
		this.user_mname = user_mname;
		this.user_lname = user_lname;
		this.user_birthdate = user_birthdate;
		this.user_dlocation = user_dlocation;
		this.user_slocation = user_slocation;
		this.user_clocation = user_clocation;
		this.user_password = user_password;
	}
	
	public SignupData() {
		
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
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	
}
