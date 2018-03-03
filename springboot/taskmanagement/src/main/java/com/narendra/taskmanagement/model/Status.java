package com.narendra.taskmanagement.model;

import java.io.Serializable;

public class Status implements Serializable {
  

	private static final long serialVersionUID = 1L;
	private boolean status;
	private String errorMsg;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
