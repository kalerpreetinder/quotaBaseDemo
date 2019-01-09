package models;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserList {

	@JsonProperty("user_id")
	public String user_id;
	
	@JsonProperty("name")
	public String name;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
