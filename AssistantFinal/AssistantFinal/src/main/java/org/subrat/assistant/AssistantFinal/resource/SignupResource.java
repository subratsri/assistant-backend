package org.subrat.assistant.AssistantFinal.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.subrat.assistant.AssistantFinal.data.SignupData;
import org.subrat.assistant.AssistantFinal.data.StatusData;
import org.subrat.assistant.AssistantFinal.service.SignupService;

@Path("/newuser")
public class SignupResource {


	static boolean confirmed;
	@Path("/signup")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public StatusData SignupNow(SignupData signupData) throws Exception{
		SignupService signup = new SignupService();
		confirmed=true;
		return signup.putUserData(signupData.getUser_email(), signupData.getUser_fname(), signupData.getUser_mname(), signupData.getUser_lname(), signupData.getUser_birthdate(), signupData.getUser_dlocation(), signupData.getUser_slocation(), signupData.getUser_clocation(), signupData.getUser_password());
	}
	
	@Path("/{user_email}/welcome")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String welcome(@PathParam("user_email") String user_email) {
		if(confirmed) {
			confirmed = false;
			return "Welcome new user, your email id: "+user_email+" is registered. Please login to contine.";
		}
		else {
			return "THERE WAS AN ERROR, PLEASE RETURN TO THE LOGIN PAGE";
		}
	}
}
