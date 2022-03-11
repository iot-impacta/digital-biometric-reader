package com.impacta.iot.vo;

import java.io.Serializable;

public class UserResponseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String fingerprint;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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