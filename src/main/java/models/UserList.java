package models;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserList {

	@JsonProperty("user_id")
	public String user_id;
	
	@JsonProperty("first_name")
	public String first_name;
	
	@JsonProperty("last_name")
	public String last_name;
	
	@JsonProperty("company_name")
	public String company_name;
	
	@JsonProperty("image")
	public String image;
	
	@JsonProperty("verified")
	public String verified;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

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

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}
	
	
}
