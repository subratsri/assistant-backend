package org.subrat.assistant.AssistantFinal.data;

public class StatusData {

	private int status;
	private int current_sessionid_empty;

	public StatusData(int status, int current_sessionid_empty) {
		this.status = status;
		this.current_sessionid_empty = current_sessionid_empty;
	}

	public StatusData() {
		
	}

	public int getCurrent_sessionid_empty() {
		return current_sessionid_empty;
	}

	public void setCurrent_sessionid_empty(int current_sessionid_empty) {
		this.current_sessionid_empty = current_sessionid_empty;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
