package com.spring.preetnew;

import org.codehaus.jackson.annotate.JsonProperty;

public class User {

	@JsonProperty("first_name")
	public String first_name;
		
	@JsonProperty("last_name")
	public String last_name;
	
	@JsonProperty("email")
	public String email;

//	@JsonProperty("password")
//	public String password;
	
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
	
	@JsonProperty("social_id")
	public String social_id;
	
	@JsonProperty("company_name")
	public String company_name;
	
	@JsonProperty("image")
	public String image;
	
	@JsonProperty("job_title")
	public String job_title;
	
	

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

//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

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

	public String getSocial_id() {
		return social_id;
	}

	public void setSocial_id(String social_id) {
		this.social_id = social_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	
	
	
}
