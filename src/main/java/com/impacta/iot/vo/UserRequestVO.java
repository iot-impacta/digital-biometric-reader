package com.impacta.iot.vo;

import java.io.Serializable;

public class UserRequestVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String fingerprint;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
}