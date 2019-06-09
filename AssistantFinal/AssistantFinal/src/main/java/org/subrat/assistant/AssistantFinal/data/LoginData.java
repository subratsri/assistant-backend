package org.subrat.assistant.AssistantFinal.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginData {

	private String userEmail;
	private String userPassword;
	
	public LoginData(String userEmail, String userPassword){
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	public LoginData() {
		
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
