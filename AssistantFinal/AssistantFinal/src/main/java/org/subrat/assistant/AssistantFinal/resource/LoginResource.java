package org.subrat.assistant.AssistantFinal.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.subrat.assistant.AssistantFinal.data.LoginData;
import org.subrat.assistant.AssistantFinal.data.UserData;
import org.subrat.assistant.AssistantFinal.service.LoginService;

@Path("/user")
public class LoginResource {

	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserData Login(LoginData loginData) throws Exception {
		LoginService userData = new LoginService();
		return userData.getUserDetails(loginData.getUserEmail(), loginData.getUserPassword());
	}
}
