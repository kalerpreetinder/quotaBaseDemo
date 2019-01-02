package com.spring.preetnew;

import org.codehaus.jackson.annotate.JsonProperty;

public class User {

	@JsonProperty("id")
	public String id;
		
	@JsonProperty("device_id")
	public String deviceId;
	
	@JsonProperty("token")
	public String token;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
			
}
