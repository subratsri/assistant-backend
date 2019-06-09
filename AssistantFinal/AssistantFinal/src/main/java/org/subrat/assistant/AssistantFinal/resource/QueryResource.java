package org.subrat.assistant.AssistantFinal.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.subrat.assistant.AssistantFinal.data.QueryData;
import org.subrat.assistant.AssistantFinal.data.SessionData;
import org.subrat.assistant.AssistantFinal.service.QueryService;

@Path("/user")
public class QueryResource {
	
	@Path("/search")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public QueryData queryHandler(@QueryParam("query")String query, SessionData sessionid) throws Exception {
		QueryService response = new QueryService();
		return response.queryHandler(sessionid.getSession_id(), query);
	}
	
}
