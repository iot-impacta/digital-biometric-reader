package com.impacta.iot.vo;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class ExceptionVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private OffsetDateTime timestamp;
	private String detail;
	private String type;
	
	public OffsetDateTime getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(OffsetDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}