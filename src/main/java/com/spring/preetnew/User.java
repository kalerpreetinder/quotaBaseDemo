package com.spring.preetnew;

import org.codehaus.jackson.annotate.JsonProperty;

public class User {

	@JsonProperty("first_name")
	public String first_name;
		
	@JsonProperty("last_name")
	public String last_name;
	
	@JsonProperty("email")
	public String email;

	@JsonProperty("password")
	public String password;
	
	@JsonProperty("latitude")
	public String latitude;
	
	@JsonProperty("longitude")
	public String longitude;
	
	@JsonProperty("address")
	public String address;
	
	@JsonProperty("device_token")
	public String device_token;
	
	@JsonProperty("device_type")
	public String device_type;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDevice_token() {
		return device_token;
	}

	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	
}
