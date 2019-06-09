package org.subrat.assistant.AssistantFinal.data;

public class QueryData {

	private String query;
	private String response;
	private String type;
	
	public QueryData(String query, String response, String type) {
		this.query = query;
		this.response = response;
		this.type = type;
	}
	
	public QueryData() {}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
